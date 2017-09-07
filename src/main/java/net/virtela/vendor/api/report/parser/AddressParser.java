package net.virtela.vendor.api.report.parser;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.virtela.vendor.api.report.model.Address;
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
	private Map<String, Integer> cellMapper;
	
	public  AddressParser(InputStream input) {
		super(input, XLSX_FORMAT);
		this.cellMapper = this.initializeCelMapper(FIELD_LIST, ROW_INDEX_HEADER);
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		for (Object columns : rowItem) {
			Integer columnIndexInteger = Integer.valueOf(columnIndex++);
			
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_SERVICE_REQUEST))) {
				final String serviceRequest = (String) columns;
				final String [] serviceRequestSplit = serviceRequest.split(Constants.COMMA);
				
				final List<Integer> serviceRequestList = new ArrayList<>();
				for (String sRequest : serviceRequestSplit) {
					serviceRequestList.add(Integer.parseInt(sRequest));
				}
				
				address.setServerSetList(serviceRequestList);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_COUNTRY))) {
				address.setCountry((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_STATE))) {
				address.setState((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_ZIPCODE))) {
				address.setZipCode((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_CITY))) {
				address.setCity((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_STREET))) {
				address.setStreet((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_SECONDARY_STREET))) {
				address.setSecondaryStreet((String) columns);
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_LONGITUDE))) {
				address.setLongitude(((BigDecimal)columns).doubleValue());
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_LATITUDE))) {
				address.setLatitude(((BigDecimal)columns).doubleValue());
			}
		}
	}

}
