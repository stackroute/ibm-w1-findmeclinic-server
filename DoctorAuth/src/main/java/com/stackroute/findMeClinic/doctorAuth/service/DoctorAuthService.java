package com.stackroute.findMeClinic.doctorAuth.service;

import com.stackroute.findMeClinic.doctorAuth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findMeClinic.doctorAuth.model.Doctor;

public interface DoctorAuthService {

	
	public boolean registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
	
}
