package net.virtela.vendor.api.report.model;

import java.util.Map;

public class CostReportSummary {

	private String fullAddress;
	private Integer serviceId;
	private String virtelaProduct;
	private String accessType;
	private String lcc;
	private Long circuitSpeed;
	private Long portSpeed;
	private Long upSpeed;
	private String term;
	private String exactSpeed;
	
	public String getVirtelaProduct() {
		return virtelaProduct;
	}

	public void setVirtelaProduct(String virtelaProduct) {
		this.virtelaProduct = virtelaProduct;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getLcc() {
		return lcc;
	}

	public void setLcc(String lcc) {
		this.lcc = lcc;
	}

	public Long getCircuitSpeed() {
		return circuitSpeed;
	}

	public void setCircuitSpeed(Long circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}

	public Long getPortSpeed() {
		return portSpeed;
	}

	public void setPortSpeed(Long portSpeed) {
		this.portSpeed = portSpeed;
	}

	public Long getUpSpeed() {
		return upSpeed;
	}

	public void setUpSpeed(Long upSpeed) {
		this.upSpeed = upSpeed;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getExactSpeed() {
		return exactSpeed;
	}

	public void setExactSpeed(String exactSpeed) {
		this.exactSpeed = exactSpeed;
	}

	private Map<String, Long> resultSummaryMap;

	public String getFullAddress() {
		return this.fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Map<String, Long> getResultSummaryMap() {
		return this.resultSummaryMap;
	}

	public void setResultSummaryMap(Map<String, Long> summary) {
		this.resultSummaryMap = summary;
	}

	@Override
	public String toString() {
		return "CostReportSummary [fullAddress=" + this.fullAddress + ", serviceId=" + this.serviceId
				+ ", resultSummaryMap=" + this.resultSummaryMap + "]";
	}

}
