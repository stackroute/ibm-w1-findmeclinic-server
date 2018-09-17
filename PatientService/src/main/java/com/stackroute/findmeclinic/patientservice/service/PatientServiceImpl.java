package com.stackroute.findmeclinic.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.patientservice.model.Patient;
import com.stackroute.findmeclinic.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	
	@Autowired
	PatientRepository patientRepository ;

	@Override
	public String addPatient(Patient patient) {
		patientRepository.save(patient);
		return null;
		
		
	}

}
