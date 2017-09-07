package net.virtela.vendor.api.report.export;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;

import net.virtela.vendor.api.report.model.CostReportSummary;

public class ApiReportExporter extends ExcelExport {
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	private static final String TEMPLATE_PATH = "src/main/resources/ApiReportTemplate.xlsx";
	private static final String SHEET_NAME = "Report";
	
	private static final String HEADER_ADDRESS = "Address";
	private static final String HEADER_SERVICE_ID = "Service Id";
	
	public ApiReportExporter() {
		super(TEMPLATE_PATH, SHEET_NAME);
	}
	
	public ApiReportExporter(String tempaltePath, String sheetName) {
		super(tempaltePath, sheetName);
	}
	
	public <T> void populateContent(List<T> dataList, Set<String> vendorList) {
		logger.debug("preparing to export file...");
		this.setCellValue(HEADER_ADDRESS, 0, 1);
		this.setCellValue(HEADER_SERVICE_ID, 0, 1);
		
		// set header per vendor
		int colHeadIndex= 2;
		for (final String vendor : vendorList) {
			this.setCellValue(vendor, 0, colHeadIndex);
			colHeadIndex++;
		}
		
		// populate data
		final List<CostReportSummary> reportSummList = dataList.stream()
															   .filter(data -> data instanceof CostReportSummary)
															   .map(CostReportSummary.class::cast)
															   .collect(Collectors.toList());
		
		int rowIndex = 1;
		int colIndex = 0;
		
		for (final CostReportSummary summary : reportSummList) {
			final Row row = this.getRowInstance(rowIndex);
			colIndex = 0;
			this.setCellValue(summary.getFullAddress(), row, colIndex++, null);
			this.setCellValue(summary.getServiceId(), row, colIndex++, null);
			
			summary.getResultSummaryMap().forEach((vendor, tally) -> {
				final int headerIndex = this.getHeaderIndex(vendor, vendorList);
				this.setCellValue(tally, row, headerIndex, null);
			});
			
			rowIndex++;
		}
		
		this.autoSizeCol(this.getSheet(), 0, colIndex +1);
	}
	
	private int getHeaderIndex(String vendor, Set<String> vendorList) {
		int index = 2;
		for (final String vendorHeader : vendorList) {
			if (vendorHeader.equals(vendor)) {
				return index;
			}
			index++;
		}
		return index;
	}

}
