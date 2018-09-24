package com.stackroute.findmeclinic.doctorservices.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


  @Document
public class Doctor {

	  @Id

	  @Email
	  private String doctorEmail;
	  private String doctorFirstName;
	  private String doctorLastName;
	  private String doctorName;
	  private String doctorPhoneNumber;
<<<<<<< HEAD
	
	  private String doctorGender;
	  private String doctorQualification;
	  private String doctorSpeciality;
	
=======
	  
	  private String doctorGender;
	  private String doctorQualification;
	  private String doctorSpeciality;
	  
	 
>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63
	  private int doctorExperience;
	  private List<DoctorAddress> doctorAddress;

	  public Doctor() {
	  }

<<<<<<< HEAD
	  public Doctor(String doctorEmail, String doctorFirstName, String doctorLastName, String doctorName, String doctorPhoneNumber, String doctorGender, String doctorQualification, String doctorSpeciality, int doctorExperience, List<DoctorAddress> doctorAddress){
=======
	  public Doctor(String doctorEmail, String doctorFirstName, String doctorLastName, String doctorName, String doctorPhoneNumber, Date doctorDob, String doctorGender, String doctorQualification, String doctorSpeciality, int doctorExperience, List<DoctorAddress> doctorAddress){
>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63
	  	this.doctorEmail = doctorEmail;
		  this.doctorFirstName = doctorFirstName;
		  this.doctorLastName = doctorLastName;
		  this.doctorName = doctorName;
		  this.doctorPhoneNumber = doctorPhoneNumber;
<<<<<<< HEAD
		  
=======
		
>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63
		  this.doctorGender = doctorGender;
		  this.doctorQualification = doctorQualification;
		  this.doctorSpeciality = doctorSpeciality;
		 
		  this.doctorExperience = doctorExperience;
		  this.doctorAddress = doctorAddress;
	  }

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

/*
	public String getLocality() {
		return locality;
	}




	public void setLocality(String locality) {
		this.locality = locality;
	}*/




	  public void setDoctorName(String doctorName) {
		  this.doctorName = doctorName;
	  }

	  public String getDoctorPhoneNumber() {
		  return doctorPhoneNumber;
	  }

	  public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		  this.doctorPhoneNumber = doctorPhoneNumber;
	  }

<<<<<<< HEAD
=======
	  
>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63

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

<<<<<<< HEAD
	 

	

=======
	  

>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63
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

	@Override
	public String toString() {
		return "Doctor [doctorEmail=" + doctorEmail + ", doctorFirstName=" + doctorFirstName + ", doctorLastName="
				+ doctorLastName + ", doctorName=" + doctorName + ", doctorPhoneNumber=" + doctorPhoneNumber
				+ ", doctorDob="  + ", doctorGender=" + doctorGender + ", doctorQualification="
				+ doctorQualification + ", doctorSpeciality=" + doctorSpeciality + ", doctorExperience="
				+ doctorExperience + ", doctorAddress=" + doctorAddress + "]";
	}
<<<<<<< HEAD
	
=======

	



>>>>>>> ecb94b942a725379021b234edae8e8c2ef4c6e63


	
	
	
	
	
	
}
