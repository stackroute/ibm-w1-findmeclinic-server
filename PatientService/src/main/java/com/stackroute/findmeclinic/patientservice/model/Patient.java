package com.stackroute.findmeclinic.patientservice.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Patient {
	
	
	@Id
	private String patientEmailId;
	@NotBlank
	private String patientFirstName;
	@NotBlank
	private String patientLastName;
	private String patientPhoneNumber;
	@NotBlank
	private String patientAddress;
	@NotBlank
	private String patientGender;
	@NotBlank
	private Date patientDOB;
	@NotBlank
	private String patientBloodGroup;
	
	
	
	public Patient(String patientEmailId, String patientFirstName, String patientLastName, String patientPhoneNumber,
			String patientAddress, String patientGender, Date patientDOB, String patientBloodGroup) {
		super();
		this.patientEmailId = patientEmailId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientPhoneNumber = patientPhoneNumber;
		this.patientAddress = patientAddress;
		this.patientGender = patientGender;
		this.patientDOB = patientDOB;
		this.patientBloodGroup = patientBloodGroup;
	}
	
	
	
	public String getPatientEmailId() {
		return patientEmailId;
	}
	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
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
	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}



	@Override
	public String toString() {
		return "Patient [patientEmailId=" + patientEmailId + ", patientFirstName=" + patientFirstName
				+ ", patientLastName=" + patientLastName + ", patientPhoneNumber=" + patientPhoneNumber
				+ ", patientAddress=" + patientAddress + ", patientGender=" + patientGender + ", patientDOB="
				+ patientDOB + ", patientBloodGroup=" + patientBloodGroup + "]";
	}

	
	

}
