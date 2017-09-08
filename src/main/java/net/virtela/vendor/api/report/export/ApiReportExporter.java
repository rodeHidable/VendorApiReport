package net.virtela.vendor.api.report.export;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.virtela.vendor.api.report.model.CostReportSummary;
import net.virtela.vendor.api.report.util.CommonHelper;

@Component
public class ApiReportExporter extends ExcelExport {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String HEADER_ADDRESS = "ADDRESS";
	private static final String HEADER_LCC = "LCC";
	private static final String HEADER_VIRTELA_PRODUCT = "VIRTELA PRODUCT";
	private static final String HEADER_ACCESS_TYPE = "ACCESS TYPE";
	private static final String HEADER_CIRCUIT_SPEED = "CIRCUIT SPEED";
	private static final String HEADER_PORT_SPEED = "PORT SPEED";
	private static final String HEADER_UP_SPEED = "UPLOAD SPEED";
	private static final String HEADER_TERM = "CIRCUIT TERM";
	private static final String HEADER_EXACT_SPEED = "EXACT SPEED";
	
	public ApiReportExporter() {
		super();
	}
	
	public ApiReportExporter(String templatePath, String sheetName) {
		super(templatePath, sheetName);
	}
	
	public <T> void populateContent(List<T> dataList, Set<String> vendorList) {
		logger.debug("preparing to export file...");

		this.setCellValue(HEADER_ADDRESS, 0, 0);
		this.setCellValue(HEADER_LCC, 0, 1);
		this.setCellValue(HEADER_VIRTELA_PRODUCT, 0, 2);
		this.setCellValue(HEADER_ACCESS_TYPE, 0, 3);
		this.setCellValue(HEADER_CIRCUIT_SPEED, 0, 4);
		this.setCellValue(HEADER_PORT_SPEED, 0, 5);
		this.setCellValue(HEADER_UP_SPEED, 0, 6);
		this.setCellValue(HEADER_TERM, 0, 7);
		this.setCellValue(HEADER_EXACT_SPEED, 0, 8);
		
		// set header per vendor
		int colHeadIndex= 9;
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
			this.setCellValue(summary.getFullAddress(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getLcc(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getVirtelaProduct(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getAccessType(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getCircuitSpeed(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getPortSpeed(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getUpSpeed(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(summary.getTerm(), row, colIndex++, this.getCellStyleNormal());
			this.setCellValue(CommonHelper.isBooleanFlagActive(summary.getExactSpeed()) ? "YES" : "NO", row, colIndex++, this.getCellStyleNormal());
			
			summary.getResultSummaryMap().forEach((vendor, tally) -> {
				int index = 9;
				for (final String vendorHeader : vendorList) {
					if (vendorHeader.equals(vendor)) {
						this.setCellValue(tally, row, index, this.getCellStyleNormal());
					} else {
						this.setCellValue(0, row, index, this.getCellStyleNormal());
					}
					
					index++;
				}
			});
			
			rowIndex++;
		}
		
		this.autoSizeCol(this.getSheet(), 0, colIndex +1);
		
	}
	
}
