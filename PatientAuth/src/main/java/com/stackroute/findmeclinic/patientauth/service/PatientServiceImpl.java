package com.stackroute.findmeclinic.patientauth.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.patientauth.Repository.PatientRepository;
import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public boolean registerPatient(Patient patient) throws PatientAlreadyExistsException {
		boolean flag = false;
		try {
			if (!patientRepository.existsById(patient.getPatientEmail())
					&& findPatientBypatientPhoneNumber(patient.getPatientPhoneNumber()) == null) {
				patientRepository.save(patient);
				flag = true;
			} else {
				throw new PatientAlreadyExistsException("patient already exist");
			}
			
				return flag;
			
		} catch (NoSuchElementException exception) {
			throw new PatientAlreadyExistsException("Patient already exist");
		}
	}

	public Patient findPatientBypatientPhoneNumber(String patientPhoneNumber) {
		Patient patientInfo = patientRepository.findPatientBypatientPhoneNumber(patientPhoneNumber);
		if (patientInfo != null) {
			return patientInfo;
		} else {
			return null;
		}
	}

}
