package com.stackroute.findmeclinic.doctorauth.service;

import javax.servlet.ServletException;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;

public interface DoctorAuthService {

	

	public Doctor registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
	

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);
	public String loginToken(Doctor login) throws ServletException;
	
}
