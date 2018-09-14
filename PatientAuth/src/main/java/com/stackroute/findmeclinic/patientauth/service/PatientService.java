package com.stackroute.findmeclinic.patientauth.service;

import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.model.Patient;

public interface PatientService {

	public Patient registerPatient(Patient patient) throws PatientAlreadyExistsException;

	public Patient findPatientByPatientEmailAndPatientPassword(String patientEmail, String patientPassword);
}
