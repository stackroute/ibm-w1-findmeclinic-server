package com.stackroute.findmeclinic.doctorauth.service;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsException;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;

public interface DoctorAuthService {

	public Doctor registerDoctor(Doctor doctor) throws  DoctorAlreadyExistsException;

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);

	public Doctor findDoctorByDoctorEmailAndDoctorPassword(String doctorEmail, String doctorPassword);

}
