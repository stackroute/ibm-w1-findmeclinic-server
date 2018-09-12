package com.stackroute.findmeclinic.patientauth.service;

import java.util.Date;

import java.util.NoSuchElementException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.model.Patient;
import com.stackroute.findmeclinic.patientauth.repository.PatientRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient registerPatient(Patient patient)  throws PatientAlreadyExistsException{
		
		try {
			if (!patientRepository.existsById(patient.getPatientEmail())
					&& getPatientBypatientPhoneNumber(patient.getPatientPhoneNumber()) == null) {
				patientRepository.save(patient);
				
				return patient;
			
			} else {
				throw new PatientAlreadyExistsException("patient already exist");
			}
			
	
		} catch (NoSuchElementException exception) {
			throw new PatientAlreadyExistsException("Patient already exist");
		}
	
	}

	public Patient getPatientBypatientPhoneNumber(String patientPhoneNumber) {
		Patient patientInfo = patientRepository.findPatientBypatientPhoneNumber(patientPhoneNumber);
		if (patientInfo != null) {
			return patientInfo;
		} else {
			return null;
		}
	}
	
	public Patient getPatientByEmail(String patientEmail) {
        Patient fetchedPatient = patientRepository.findPatientByPatientEmail(patientEmail);
        return fetchedPatient;
    }

	

	@Override
	public Patient findPatientByPatientEmailAndPatientPassword(String patientEmail, String patientPassword) {
		Patient fetchedPatient = patientRepository.findPatientByPatientEmailAndPatientPassword(patientEmail, patientPassword);
		return fetchedPatient;
	}

  
}
