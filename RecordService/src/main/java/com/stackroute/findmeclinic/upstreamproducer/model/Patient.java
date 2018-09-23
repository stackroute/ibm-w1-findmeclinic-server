package com.stackroute.findmeclinic.upstreamproducer.model;

public class Patient {
	private String patientEmail;
	private String patientFirstName;
    private String patientAge;

	public Patient() {

	}

	public Patient(String patientEmail, String patientFirstName, String patientAge) {
		super();
		this.patientEmail = patientEmail;
		this.patientFirstName = patientFirstName;
		this.patientAge = patientAge;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	@Override
	public String toString() {
		return "Patient [patientEmail=" + patientEmail + ", patientFirstName=" + patientFirstName + ", patientAge="
				+ patientAge + "]";
	}

	
}
