package net.virtela.vendor.api.report.model;

public class LocationParam {

	private String country;
	private String state;
	private String city;
	private String street;
	private String zipCode;
	private Double longitude;
	private Double latitude;
	private String secondaryStreet;

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getSecondaryStreet() {
		return this.secondaryStreet;
	}

	public void setSecondaryStreet(String secondaryStreet) {
		this.secondaryStreet = secondaryStreet;
	}
	
	public static LocationParam toLocationParam(Address address) {
		final LocationParam locationParam = new LocationParam();
		locationParam.setCity(address.getCity());
		locationParam.setCountry(address.getCountry());
		locationParam.setLatitude(address.getLatitude());
		locationParam.setLongitude(address.getLongitude());
		locationParam.setSecondaryStreet(address.getSecondaryStreet());
		locationParam.setState(address.getState());
		locationParam.setStreet(address.getStreet());
		locationParam.setZipCode(address.getZipCode());
		
		return locationParam;
	}

}
