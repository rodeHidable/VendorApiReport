package net.virtela.vendor.api.report.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

import net.virtela.vendor.api.report.model.Address;
import net.virtela.vendor.api.report.util.CommonHelper;
import net.virtela.vendor.api.report.util.Constants;

public class AddressParser extends BaseExcelParser {

	public static final String HEADER_SERVICE_REQUEST = "SERVICE REQUEST";
	public static final String HEADER_COUNTRY = "COUNTRY";
	public static final String HEADER_STATE = "STATE";
	public static final String HEADER_ZIPCODE = "ZIP CODE";
	public static final String HEADER_CITY = "CITY";
	public static final String HEADER_STREET = "STREET";
	public static final String HEADER_SECONDARY_STREET = "SECONDARY STREET";
	public static final String HEADER_LONGITUDE = "LON";
	public static final String HEADER_LATITUDE = "LAT";
	
	private static final int ROW_INDEX_HEADER = 0;
	public static final int ROW_INDEX_START = 1;
	private static final String SHEET_ADDRESS = "Address";
	
	private static final List<String> FIELD_LIST = new ArrayList<>(Arrays.asList(HEADER_SERVICE_REQUEST, HEADER_COUNTRY, HEADER_STATE, HEADER_ZIPCODE, HEADER_CITY, HEADER_STREET, HEADER_SECONDARY_STREET, HEADER_LONGITUDE, HEADER_LATITUDE));
	private final Map<String, Integer> cellMapper;
	
	public  AddressParser(InputStream input) {
		super(input, XLSX_FORMAT);
		this.cellMapper = this.initializeCelMapper(FIELD_LIST, ROW_INDEX_HEADER);
		try {
			input.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getCellValue(Cell cell) {

		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getRichStringCellValue().getString().trim();
			case Cell.CELL_TYPE_NUMERIC:
				return Double.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_BOOLEAN:
				return Boolean.valueOf(cell.getBooleanCellValue());
			}
		}
		return "";
	}
	
	@Override
	public int getStartRowIndex() {
		return ROW_INDEX_START;
	}

	@Override
	public String getSheetName() {
		return SHEET_ADDRESS;
	}
	
	public List<Address> getParsedList() {
		final List<List<Object>> rows = this.extractRows(ROW_INDEX_HEADER);
		final List<Address> addressList = new ArrayList<>(rows.size());
		
		rows.forEach(rowItem -> {
			final Address address = new Address();
			this.processRecords(rowItem, address);
			addressList.add(address);
		});
		
		return addressList;
	}
	
	private void processRecords(List<Object> rowItem, Address address) {
		int columnIndex = 0;
		for (final Object columns : rowItem) {
			final Integer columnIndexInteger = Integer.valueOf(columnIndex++);
			
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_SERVICE_REQUEST))) {
				final String serviceRequest = CommonHelper.getStringValue(columns);
				final String [] serviceRequestSplit = serviceRequest.split(Constants.COMMA);
				
				final List<Integer> serviceRequestList = new ArrayList<>();
				for (final String sRequest : serviceRequestSplit) {
					serviceRequestList.add(Integer.parseInt(sRequest));
				}
				
				address.setServerSetList(serviceRequestList);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_COUNTRY))) {
				address.setCountry(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_STATE))) {
				address.setState(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_ZIPCODE))) {
				address.setZipCode(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_CITY))) {
				address.setCity(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_STREET))) {
				address.setStreet(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_SECONDARY_STREET))) {
				address.setSecondaryStreet(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_LONGITUDE))) {
				address.setLongitude(CommonHelper.toDecimalNumber(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_LATITUDE))) {
				address.setLatitude(CommonHelper.toDecimalNumber(columns));
			}
		}
	}

}
