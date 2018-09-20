package com.stackroute.findmeclinic.patientservice.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.patientservice.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientservice.model.Patient;
import com.stackroute.findmeclinic.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	
	@Autowired
	PatientRepository patientRepository ;

	@Override
	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException {

		try {
			if (!patientRepository.existsById(patient.getPatientEmail()))
		 {
				char[] firstNameArray = patient.getPatientFirstName().toCharArray();
				firstNameArray[0] = Character.toUpperCase(firstNameArray[0]);
				char[] lastNameArray = patient.getPatientLastName().toCharArray();
				lastNameArray[0] = Character.toUpperCase(lastNameArray[0]);
				patient.setPatientFirstName(String.valueOf(firstNameArray));
				patient.setPatientLastName(String.valueOf(lastNameArray));
				
				patientRepository.insert(patient);

				return patient;

			} else {
				throw new PatientAlreadyExistsException("patient already exist");
			}

		} catch (NoSuchElementException exception) {
			throw new PatientAlreadyExistsException("Patient already exist");
		}

	}

	@Override
	public Patient getPatientByEmail(String emailId) {
		Patient fetchedPatient = new Patient();
		
		if(patientRepository.existsById(emailId))
		{
			fetchedPatient=patientRepository.findById(emailId).get();
		}
		return fetchedPatient;
			}

	@Override
	public String getPatientBadgeName(String emailId) {
		Patient fetchedPatient = new Patient();
		fetchedPatient=getPatientByEmail(emailId);
		String firstName = fetchedPatient.getPatientFirstName();
		String lastName = fetchedPatient.getPatientLastName();
		String badgeName = firstName.substring(0,1).toUpperCase()+lastName.substring(0,1).toUpperCase();


		return badgeName;
	}

	@Override
	public Patient updatePatient(Patient patient) {
		 int currentYear= Calendar.getInstance().get(Calendar.YEAR);
		int birthYear = patient.getPatientDobYear();
		int age = currentYear-birthYear;
		patient.setPatientAge(age);
		patientRepository.save(patient);
		return patient;
	}

	

}
