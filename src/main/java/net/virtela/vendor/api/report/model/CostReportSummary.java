package net.virtela.vendor.api.report.model;

import java.util.Map;

public class CostReportSummary {

	private String fullAddress;
	private Integer serviceId;
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
