package net.virtela.vendor.api.report.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PricingParam {

	private LocationParam locationParam;
	private String vProduct;
	private String term;
	private String accessType;
	private String extactSpeed;
	private String costTable;
	private String vendorAPI;
	private String lcc;
	private String skipCache;
	private String historical;
	private String historicalExact;
	private String forBulkPricing;
	private long downSpeed;
	private long upSpeed;
	private String portSpeed;
	private Long vProductID;

	public LocationParam getLocationParam() {
		return this.locationParam;
	}

	public void setLocationParam(LocationParam locationParam) {
		this.locationParam = locationParam;
	}

	public String getvProduct() {
		return this.vProduct;
	}

	public void setvProduct(String vProduct) {
		this.vProduct = vProduct;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getAccessType() {
		return this.accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getExtactSpeed() {
		return this.extactSpeed;
	}

	public void setExtactSpeed(String extactSpeed) {
		this.extactSpeed = extactSpeed;
	}

	public String getCostTable() {
		return this.costTable;
	}

	public void setCostTable(String costTable) {
		this.costTable = costTable;
	}

	public String getVendorAPI() {
		return this.vendorAPI;
	}

	public void setVendorAPI(String vendorAPI) {
		this.vendorAPI = vendorAPI;
	}

	public String getLcc() {
		return this.lcc;
	}

	public void setLcc(String lcc) {
		this.lcc = lcc;
	}

	public String getSkipCache() {
		return this.skipCache;
	}

	public void setSkipCache(String skipCache) {
		this.skipCache = skipCache;
	}

	public String getHistorical() {
		return this.historical;
	}

	public void setHistorical(String historical) {
		this.historical = historical;
	}

	public String getHistoricalExact() {
		return this.historicalExact;
	}

	public void setHistoricalExact(String historicalExact) {
		this.historicalExact = historicalExact;
	}

	public String getForBulkPricing() {
		return this.forBulkPricing;
	}

	public void setForBulkPricing(String forBulkPricing) {
		this.forBulkPricing = forBulkPricing;
	}

	public long getDownSpeed() {
		return this.downSpeed;
	}

	public void setDownSpeed(long downSpeed) {
		this.downSpeed = downSpeed;
	}

	public long getUpSpeed() {
		return this.upSpeed;
	}

	public void setUpSpeed(long upSpeed) {
		this.upSpeed = upSpeed;
	}

	public String getPortSpeed() {
		return this.portSpeed;
	}

	public void setPortSpeed(String portSpeed) {
		this.portSpeed = portSpeed;
	}

	public Long getvProductID() {
		return this.vProductID;
	}

	public void setvProductID(Long vProductID) {
		this.vProductID = vProductID;
	}
	
	public static String toJson(PricingParam pricingParam) throws JsonProcessingException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pricingParam);
	}

}
