package com.stackroute.findmeclinic.doctorauth.model;

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
	private String doctorFirstName;
	private String doctorLastName;


	public Doctor() {
		super();
	}


	public Doctor(@Email String doctorEmail, @NotBlank String doctorPhoneNumber, @NotBlank String doctorPassword,
			String doctorFirstName, String doctorLastName) {
		super();
		this.doctorEmail = doctorEmail;
		this.doctorPhoneNumber = doctorPhoneNumber;
		this.doctorPassword = doctorPassword;
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
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


	@Override
	public String toString() {
		return "Doctor [doctorEmail=" + doctorEmail + ", doctorPhoneNumber=" + doctorPhoneNumber + ", doctorPassword="
				+ doctorPassword + ", doctorFirstName=" + doctorFirstName + ", doctorLastName=" + doctorLastName + "]";
	}

	

}
