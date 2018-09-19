package com.stackroute.findmeclinic.bookingappointment.model;

public class DoctorAddress {
	
	private int addressNo;
    private String streetName;
    private String locality;
    private String state;
    private String doctorAddress;
    public DoctorAddress() {
        
    }
    

    public DoctorAddress(int addressNo, String streetName, String locality, String state,String doctorAddress) {
        super();
        this.addressNo = addressNo;
        this.streetName = streetName;
        this.locality = locality;
        this.state = state;
        this.doctorAddress=doctorAddress;
    }


    public int getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(int addressNo) {
        this.addressNo = addressNo;
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





    public String getDoctorAddress() {
        return doctorAddress;
    }





    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }





    @Override
    public String toString() {
        return "DoctorAddress [addressNo=" + addressNo + ", streetName=" + streetName + ", locality=" + locality
                + ", state=" + state + ", doctorAddress=" + doctorAddress + "]";
    }

}
