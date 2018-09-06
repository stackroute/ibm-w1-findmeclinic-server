package com.stackroute.findmeclinic.doctorauth.test.repository;

/*import static org.junit.Assert.assertEquals;*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.repository.DoctorAuthRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DoctorAuthRepositoryTest {

	@Autowired
	private DoctorAuthRepository doctorAuthRepository;
	
	private Doctor doctor;
	
	
	 @Before
	    public void setUp() throws Exception {
	  
		  doctor = new Doctor();
		 doctor.setDoctorEmail("esanvi97@gmail.com");
		 doctor.setDoctorPhoneNumber("9994224303");
		 doctor.setDoctorPassword("sanju");
	 }
	 
	 @After
	 public void tearDown() throws Exception{
		 doctorAuthRepository.deleteAll();
	 }
	 
	 
	 @Test
	 
	 public void  registerDoctorTest() {
		 doctorAuthRepository.save(doctor);
		 Doctor fetchedDoctor = doctorAuthRepository.findDoctorBydoctorPhoneNumber("9994224303");
		 System.out.println(fetchedDoctor);
		 Assert.assertEquals(doctor.getDoctorEmail(), fetchedDoctor.getDoctorEmail());
	 }
}
