package net.virtela.vendor.api.report.model;

public class ServiceRequest {

	private Integer id;
	private String virtelaProduct;
	private String accessType;
	private String lcc;
	private Long circuitSpeed;
	private Long portSpeed;
	private Long uploadSpeed;
	private Integer term;
	private String exactSpeed;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVirtelaProduct() {
		return this.virtelaProduct;
	}

	public void setVirtelaProduct(String virtelaProduct) {
		this.virtelaProduct = virtelaProduct;
	}

	public String getAccessType() {
		return this.accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getLcc() {
		return this.lcc;
	}

	public void setLcc(String lcc) {
		this.lcc = lcc;
	}

	public Long getCircuitSpeed() {
		return this.circuitSpeed;
	}

	public void setCircuitSpeed(Long circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}

	public Long getPortSpeed() {
		return this.portSpeed;
	}

	public void setPortSpeed(Long portSpeed) {
		this.portSpeed = portSpeed;
	}

	public Long getUploadSpeed() {
		return this.uploadSpeed;
	}

	public void setUploadSpeed(Long uploadSpeed) {
		this.uploadSpeed = uploadSpeed;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + this.id + ", virtelaProduct=" + this.virtelaProduct + ", accessType="
				+ this.accessType + ", lcc=" + this.lcc + ", circuitSpeed=" + this.circuitSpeed + ", portSpeed="
				+ this.portSpeed + ", uploadSpeed=" + this.uploadSpeed + ", term=" + this.term + "]";
	}

	public String getExactSpeed() {
		return this.exactSpeed;
	}

	public void setExactSpeed(String exactSpeed) {
		this.exactSpeed = exactSpeed;
	}

}
