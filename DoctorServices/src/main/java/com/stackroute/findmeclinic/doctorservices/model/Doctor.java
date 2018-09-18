package com.stackroute.findmeclinic.doctorservices.model;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


  @Document
public class Doctor {

	
   @Id
	private String doctorLicenceId;
	;
	private String doctorGender;
	private String doctorQualification;
	private String doctorSpeciality;
	private int doctorExperience;
	private List<DoctorAddress> doctorAddress;

	public Doctor() {
		
	}

	public Doctor(String doctorLicenceId, String doctorGender, String doctorQualification,
			String doctorSpeciality, int doctorExperience, List<DoctorAddress> doctorAddress) {
		super();
		this.doctorLicenceId=doctorLicenceId;
		
		this.doctorGender = doctorGender;
		this.doctorQualification = doctorQualification;
		this.doctorSpeciality = doctorSpeciality;
		this.doctorExperience = doctorExperience;
		this.doctorAddress = doctorAddress;
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

	
	public String getDoctorLicenceId() {
		return doctorLicenceId;
	}

	public void setDoctorLicenceId(String doctorLicenceId) {
		this.doctorLicenceId = doctorLicenceId;
	}

	@Override
	public String toString() {
		return "Doctor [doctorLicenceId=" + doctorLicenceId +  ", doctorGender=" + doctorGender + ", doctorQualification="
				+ doctorQualification + ", doctorSpeciality=" + doctorSpeciality + ", doctorExperience="
				+ doctorExperience + ", doctorAddress=" + doctorAddress + "]";
	}

	
	
	
	
	
}
