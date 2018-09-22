package com.stackroute.findmeclinic.searchservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("doctor")
public class Doctor {
	@Id

	private String doctorEmail;
	private String doctorFirstName;
	private String doctorLastName;
	private String doctorName;
	private String doctorPhoneNumber;

	private String doctorGender;
	private String doctorQualification;
	private String doctorSpeciality;
	private int doctorExperience;
	private List<DoctorAddress> doctorAddress;

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

	public int getDoctorExperience() {
		return doctorExperience;
	}

	public void setDoctorExperience(int doctorExperience) {
		this.doctorExperience = doctorExperience;
	}

	public List<DoctorAddress> getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(List<DoctorAddress> doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public Doctor() {

	}

	public Doctor(String doctorEmail, String doctorFirstName, String doctorLastName, String doctorName,
			String doctorPhoneNumber, String doctorGender, String doctorQualification, String doctorSpeciality,
			int doctorExperience, List<DoctorAddress> doctorAddress) {

		this.doctorEmail = doctorEmail;
		this.doctorFirstName = doctorFirstName;
		this.doctorLastName = doctorLastName;
		this.doctorName = doctorName;
		this.doctorPhoneNumber = doctorPhoneNumber;
		this.doctorGender = doctorGender;
		this.doctorQualification = doctorQualification;
		this.doctorSpeciality = doctorSpeciality;
		this.doctorExperience = doctorExperience;
		this.doctorAddress = doctorAddress;
	}

	@Override
	public String toString() {
		return "Doctor [doctorEmail=" + doctorEmail + ", doctorFirstName=" + doctorFirstName + ", doctorLastName="
				+ doctorLastName + ", doctorName=" + doctorName + ", doctorPhoneNumber=" + doctorPhoneNumber
				+ ", doctorGender=" + doctorGender + ", doctorQualification=" + doctorQualification
				+ ", doctorSpeciality=" + doctorSpeciality + ", doctorExperience=" + doctorExperience
				+ ", doctorAddress=" + doctorAddress + "]";
	}

}
