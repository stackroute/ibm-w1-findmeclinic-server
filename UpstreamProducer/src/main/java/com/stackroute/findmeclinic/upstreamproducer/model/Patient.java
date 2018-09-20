package com.stackroute.findmeclinic.upstreamproducer.model;

import java.util.Date;

public class Patient {
	private String patientFirstName;
	private String patientLastName;
	private String patientPhoneNumber;
	private String patientAddress;
	private String patientGender;
	private Date patientDOB;
	private int patientAge;
	private String patientBloodGroup;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String patientFirstName, String patientLastName, String patientPhoneNumber, String patientAddress,
			String patientGender, Date patientDOB, int patientAge, String patientBloodGroup) {
		super();
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientPhoneNumber = patientPhoneNumber;
		this.patientAddress = patientAddress;
		this.patientGender = patientGender;
		this.patientDOB = patientDOB;
		this.patientAge = patientAge;
		this.patientBloodGroup = patientBloodGroup;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}
	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public Date getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(Date patientDOB) {
		this.patientDOB = patientDOB;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}
	@Override
	public String toString() {
		return "Patient [patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress
				+ ", patientGender=" + patientGender + ", patientDOB=" + patientDOB + ", patientAge=" + patientAge
				+ ", patientBloodGroup=" + patientBloodGroup + "]";
	}

	
	
}
