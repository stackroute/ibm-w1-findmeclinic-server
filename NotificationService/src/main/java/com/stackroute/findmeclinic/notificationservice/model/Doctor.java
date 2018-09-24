package com.stackroute.findmeclinic.notificationservice.model;

public class Doctor {
	private String doctorFirstName;
	  private String doctorLastName;
	  private String doctorName;
	  private String doctorPhoneNumber;
	  
	  private String doctorGender;
	  private String doctorQualification;
	  private String doctorSpeciality;
	  private String doctorEmail;
	  public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorFirstName() {
		return doctorFirstName;
	}
	public void setDoctorFirstName(String doctorFirstName) {
		this.doctorFirstName = doctorFirstName;
	}
	public String getDoctorLastName() {
		return doctorLastName;
	}
	public void setDoctorLastName(String doctorLastName) {
		this.doctorLastName = doctorLastName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorPhoneNumber() {
		return doctorPhoneNumber;
	}
	public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		this.doctorPhoneNumber = doctorPhoneNumber;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	public String getDoctorQualification() {
		return doctorQualification;
	}
	
	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}
	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}
	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}
	@Override
	public String toString() {
		return "Doctor [doctorFirstName=" + doctorFirstName + ", doctorLastName=" + doctorLastName + ", doctorName="
				+ doctorName + ", doctorPhoneNumber=" + doctorPhoneNumber + ", doctorGender=" + doctorGender
				+ ", doctorQualification=" + doctorQualification + ", doctorSpeciality=" + doctorSpeciality
				+ ", doctorEmail=" + doctorEmail + "]";
	}
	
}
