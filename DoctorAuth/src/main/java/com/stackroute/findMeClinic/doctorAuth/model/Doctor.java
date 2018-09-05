package com.stackroute.findMeClinic.doctorAuth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Doctor {

	@Id
	@Email
	private String doctorEmail;
@NotBlank
	private String doctorPhoneNumber;
@NotBlank
	private String doctorPassword;

	public Doctor() {
		super();
    }
	
	

	public Doctor(String doctorEmail, String doctorPhoneNumber, String doctorPassword) {
		super();
		this.doctorEmail = doctorEmail;
		this.doctorPhoneNumber = doctorPhoneNumber;
		this.doctorPassword = doctorPassword;
	}



	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorPhoneNumber() {
		return doctorPhoneNumber;
	}

	public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		this.doctorPhoneNumber = doctorPhoneNumber;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}



}
