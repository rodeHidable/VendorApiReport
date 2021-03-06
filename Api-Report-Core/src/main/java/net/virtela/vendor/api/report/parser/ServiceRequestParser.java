package net.virtela.vendor.api.report.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.virtela.vendor.api.report.model.ServiceRequest;
import net.virtela.vendor.api.report.util.CommonHelper;

public class ServiceRequestParser extends BaseExcelParser {

	public static final String HEADER_ID = "ID";
	public static final String HEADER_VIRTELA_PRODUCT = "VIRTELA PRODUCT";
	public static final String HEADER_ACCESS_TYPE = "ACCESS TYPE";
	public static final String HEADER_LCC = "LCC";
	public static final String HEADER_CIRCUIT_SPEED = "CIRCUIT SPEED";
	public static final String HEADER_PORT_SPEED = "PORT SPEED";
	public static final String HEADER_UPLOAD_SPEED = "UPLOAD SPEED";
	public static final String HEADER_TERM = "TERM";
	public static final String HEADER_EXACT_SPEED = "EXACT SPEED";
	
	private static final Integer ROW_INDEX_HEADER = 0;
	public static final Integer ROW_INDEX_START = 1;
	private static final String SHEET_REQUEST_SERVICE = "RequestService";
	
	private static final List<String> FIELD_LIST = new ArrayList<>(Arrays.asList(HEADER_ID, HEADER_VIRTELA_PRODUCT, HEADER_ACCESS_TYPE, HEADER_LCC, HEADER_CIRCUIT_SPEED, HEADER_PORT_SPEED, HEADER_UPLOAD_SPEED, HEADER_TERM, HEADER_EXACT_SPEED));
	private final Map<String, Integer> cellMapper;
	
	public ServiceRequestParser(InputStream input) {
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
		return SHEET_REQUEST_SERVICE;
	}
	
	public List<ServiceRequest> getParsedList() {
		final List<List<Object>> rows = this.extractRows(ROW_INDEX_HEADER);
		final List<ServiceRequest> serviceRequestList = new ArrayList<>(rows.size());
		
		rows.forEach(rowItem -> {
			final ServiceRequest serviceRequest = new ServiceRequest();
			this.processRecords(rowItem, serviceRequest);
			serviceRequestList.add(serviceRequest);
		});
		
		return serviceRequestList;
	}

	private void processRecords(List<Object> rowItem, ServiceRequest serviceRequest) {
		int columnIndex = 0;
		for (Object columns : rowItem) {
			Integer columnIndexInteger = Integer.valueOf(columnIndex++);
			
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_ID))) {
				serviceRequest.setId(CommonHelper.toInteger(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_VIRTELA_PRODUCT))) {
				serviceRequest.setVirtelaProduct(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_ACCESS_TYPE))) {
				serviceRequest.setAccessType(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_LCC))) {
				serviceRequest.setLcc(CommonHelper.getStringValue(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_CIRCUIT_SPEED))) {
				serviceRequest.setCircuitSpeed(CommonHelper.toNumber(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_PORT_SPEED))) {
				serviceRequest.setPortSpeed(CommonHelper.toNumber(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_UPLOAD_SPEED))) {
				serviceRequest.setUploadSpeed(CommonHelper.toNumber(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_TERM))) {
				serviceRequest.setTerm(CommonHelper.toInteger(columns));
			}
			if(columnIndexInteger.equals(this.cellMapper.get(HEADER_EXACT_SPEED))) {
				serviceRequest.setExactSpeed(CommonHelper.getStringValue(columns));
			}
		}
	}

}
