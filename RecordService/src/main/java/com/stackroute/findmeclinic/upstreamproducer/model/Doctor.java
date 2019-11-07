package com.stackroute.findmeclinic.upstreamproducer.model;


public class Doctor {
	private String doctorEmail;
    private String doctorName;
    private String doctorSpeciality;
    
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String doctorEmail, String doctorName, String doctorSpeciality) {
		super();
		this.doctorEmail = doctorEmail;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}

	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}

	@Override
	public String toString() {
		return "Doctor [doctorEmail=" + doctorEmail + ", doctorName=" + doctorName + ", doctorSpeciality="
				+ doctorSpeciality + "]";
	}
	
	

}