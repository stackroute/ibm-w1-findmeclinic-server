package com.stackroute.findmeclinic.doctorauth.service;


import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;

public interface DoctorAuthService {

	

	public Doctor registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
	

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);
	public Doctor findDoctorByDoctorEmailAndDoctorPassword(String doctorEmail,String doctorPassword);
	
}
