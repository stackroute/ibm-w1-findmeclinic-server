/*package com.stackroute.findmeclinic.patientauth.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.model.Patient;
import com.stackroute.findmeclinic.patientauth.repository.PatientRepository;
import com.stackroute.findmeclinic.patientauth.service.PatientServiceImpl;

public class PatientServiceImplTest {

	@Mock
	private PatientRepository patientRepository;
	
	Patient patient, patient1;
	
	@InjectMocks
	private PatientServiceImpl patientServiceImpl;
	

	 @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        patient = new Patient();
	        patient1 = new Patient();
	 }
	 
	 
	 
	 @Test
	 public void registerPatientSuccess() throws PatientAlreadyExistsException{
		 when(patientRepository.save((Patient) any())).thenReturn(patient);
		 Patient registerPatient  = patientServiceImpl.registerPatient(patient);
		 assertEquals(patient, registerPatient);
		 
	 }
	 
	 
	 
	 @Test
	 public void registerPatientFailure() throws PatientAlreadyExistsException{
		 when(patientRepository.save((Patient) any())).thenReturn(patient);
		 Patient registerPatient  = patientServiceImpl.registerPatient(patient);
		 assertNotEquals(patient1, registerPatient);
		 
	 }
	
}
*/