package com.stackroute.findmeclinic.doctorauth.service;

import javax.servlet.ServletException;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;

public interface DoctorAuthService {

	
<<<<<<< HEAD
	public Doctor registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
	
=======
	public boolean registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
>>>>>>> 842d0124078804c57292696bcccd6ce5af5b8450
	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);
	public String loginToken(Doctor login) throws ServletException;
	
}
