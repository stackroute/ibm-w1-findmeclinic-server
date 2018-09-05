package com.stackroute.findMeClinic.patientAuth.service;

import com.stackroute.findMeClinic.patientAuth.exception.PatientAlreadyExistsException;
import com.stackroute.findMeClinic.patientAuth.model.Patient;

public interface PatientService {

	
	public boolean registerPatient(Patient patient) throws PatientAlreadyExistsException;
	public Patient getPatientByEmail(String patientEmail);
	 
}
