package com.stackroute.findmeclinic.searchservice.model;

public class DoctorAddress {
	private int addressNo;
	private String hospitalName;
	private String streetName;
	private String locality;
	private String state;
	
	public DoctorAddress() {
		
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public DoctorAddress(int addressNo, String hospitalName, String streetName, String locality, String state) {
		
		this.addressNo = addressNo;
		this.hospitalName = hospitalName;
		this.streetName = streetName;
		this.locality = locality;
		this.state = state;
	}

	@Override
	public String toString() {
		return "DoctorAddress [addressNo=" + addressNo + ", hospitalName=" + hospitalName + ", streetName=" + streetName
				+ ", locality=" + locality + ", state=" + state + "]";
	}
	
}
