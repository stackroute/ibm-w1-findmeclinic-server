
package com.stackroute.findmeclinic.patientauth.test.repository;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.stackroute.findmeclinic.patientauth.model.Patient;
import com.stackroute.findmeclinic.patientauth.repository.PatientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PatientRepositoryTest {
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	 Patient patient;
	
	
	
	@Before
	 public void setUp() throws Exception {
        
         patient = new Patient();
        patient.setPatientEmail("abcd@gmail.com");
        patient.setPatientPhoneNumber("4567");
        patient.setPatientPassword("xyz");
        
        
    }
	
	
	 @After
	 public void tearDown() throws Exception{
		 patientRepository.deleteAll();
	 }
	 
	 @Test
	 @Ignore
	 public void registerPatientUserTest() {
		 
		 patientRepository.save(patient);
		 Patient  patient1 = patientRepository.findPatientBypatientPhoneNumber("4567");
		 Assert.assertEquals(patient.getPatientEmail(), patient1.getPatientEmail());
	 }
	 
	 
}
