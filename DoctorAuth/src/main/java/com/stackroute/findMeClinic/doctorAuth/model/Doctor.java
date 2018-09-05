package com.stackroute.findMeClinic.doctorAuth.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {

	@Id
	private String doctorEmail;
	private String doctorPhoneNumber;
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
