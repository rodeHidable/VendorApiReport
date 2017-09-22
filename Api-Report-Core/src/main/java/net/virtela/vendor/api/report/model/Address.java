package net.virtela.vendor.api.report.model;

import java.util.List;

import net.virtela.vendor.api.report.util.CommonHelper;
import net.virtela.vendor.api.report.util.Constants;

public class Address {

	private String country;
	private String countryCode;
	private String state;
	private String city;
	private String street;
	private String zipCode;
	private Double longitude;
	private Double latitude;
	private String secondaryStreet;
	private List<Integer> serverSetList;

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

	public List<Integer> getServerSetList() {
		return this.serverSetList;
	}

	public void setServerSetList(List<Integer> serverSetList) {
		this.serverSetList = serverSetList;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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

	@Override
	public String toString() {
		final StringBuilder address = new StringBuilder();
		address.append(this.street);
		address.append(Constants.COMMA);
		address.append(Constants.SPACE);
		if (CommonHelper.hasValidValue(this.secondaryStreet)) {
			address.append(this.secondaryStreet);
			address.append(Constants.COMMA);
			address.append(Constants.SPACE);
		}
		address.append(this.city);
		address.append(Constants.COMMA);
		address.append(Constants.SPACE);
		address.append(this.state);
		address.append(Constants.COMMA);
		address.append(Constants.SPACE);
		address.append(this.zipCode);
		address.append(Constants.COMMA);
		address.append(Constants.SPACE);
		address.append(this.country);
		
		return address.toString();
	}

}
