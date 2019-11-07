package com.stackroute.findmeclinic.patientservice.service;

import com.stackroute.findmeclinic.patientservice.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientservice.model.Patient;

public interface PatientService {
	
	
	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException;
	public Patient getPatientByEmail(String emailId);
	public String getPatientBadgeName(String emailId);
	public Patient updatePatient(Patient patient);


}
