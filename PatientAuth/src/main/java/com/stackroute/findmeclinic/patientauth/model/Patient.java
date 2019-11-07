package com.stackroute.findmeclinic.patientauth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Patient {

	@Id
	@Email
	private String patientEmail;
	@NotBlank
	private String patientPhoneNumber;
	private String patientFirstName;
	private String patientLastName;
	@NotBlank
	private String patientPassword;

	public Patient() {

	}

	

	public Patient(@Email String patientEmail, @NotBlank String patientPhoneNumber, String patientFirstName,
			String patientLastName, @NotBlank String patientPassword) {
		super();
		this.patientEmail = patientEmail;
		this.patientPhoneNumber = patientPhoneNumber;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientPassword = patientPassword;
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

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}



	@Override
	public String toString() {
		return "Patient [patientEmail=" + patientEmail + ", patientPhoneNumber=" + patientPhoneNumber
				+ ", patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName
				+ ", patientPassword=" + patientPassword + "]";
	}

	

}
