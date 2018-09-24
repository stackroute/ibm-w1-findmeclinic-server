package com.stackroute.findmeclinic.notificationservice.model;

public class Patient {
	private String patientFirstName;
	private String patientLastName;
	private String patientPhoneNumber;
	private String patientAddress;
	private String patientGender;
	private int patientAge;
	private String patientBloodGroup;
	private int patientDobDate;
	private int patientDobMonth;
	private int patientDobYear;
	private String patientEmail;
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
	public int getPatientDobDate() {
		return patientDobDate;
	}
	public void setPatientDobDate(int patientDobDate) {
		this.patientDobDate = patientDobDate;
	}
	public int getPatientDobMonth() {
		return patientDobMonth;
	}
	
	public void setPatientDobMonth(int patientDobMonth) {
		this.patientDobMonth = patientDobMonth;
	}
	public int getPatientDobYear() {
		return patientDobYear;
	}
	public void setPatientDobYear(int patientDobYear) {
		this.patientDobYear = patientDobYear;
	}
	@Override
	public String toString() {
		return "Patient [patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName
				+ ", patientPhoneNumber=" + patientPhoneNumber + ", patientAddress=" + patientAddress
				+ ", patientGender=" + patientGender + ", patientAge=" + patientAge + ", patientBloodGroup="
				+ patientBloodGroup + ", patientDobDate=" + patientDobDate + ", patientDobMonth=" + patientDobMonth
				+ ", patientDobYear=" + patientDobYear + ", patientEmail=" + patientEmail + "]";
	}
}
