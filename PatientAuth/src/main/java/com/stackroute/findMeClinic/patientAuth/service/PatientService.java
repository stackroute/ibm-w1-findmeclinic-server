package com.stackroute.findMeClinic.patientAuth.service;

import javax.servlet.ServletException;

import com.stackroute.findMeClinic.patientAuth.exception.PatientAlreadyExistsException;
import com.stackroute.findMeClinic.patientAuth.model.Patient;

public interface PatientService {

	
	public boolean registerPatient(Patient patient) throws PatientAlreadyExistsException;
	//public Patient getPatientByEmail(String patientEmail);
	//public Patient getPatientBypatientPhoneNumber(String patientPhoneNumber);
	public String loginPatientAuth(Patient patient) throws ServletException;

}
