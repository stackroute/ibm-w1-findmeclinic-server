package com.stackroute.findmeclinic.doctorservice.service.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.stackroute.findmeclinic.doctorservices.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorservices.model.Doctor;
import com.stackroute.findmeclinic.doctorservices.model.DoctorAddress;
import com.stackroute.findmeclinic.doctorservices.repository.DoctorRepository;
import com.stackroute.findmeclinic.doctorservices.service.DoctorServiceImpl;

public class DoctorServiceImplTest {

	@MockBean
	private Doctor doctor;
	
	@MockBean
	private List<DoctorAddress> doctorAddress;
	@Mock
	private DoctorRepository doctorRepository;
	@InjectMocks
	private DoctorServiceImpl doctorServiceImpl;
	
	List<Doctor> doctorList = null;
	Optional<Doctor> options;
	
	@Before
    public void setUp() throws Exception {
		
		   MockitoAnnotations.initMocks(this);
		   doctor = new Doctor();
		   doctor.setDoctorEmail("vadhana@gmail.com");
		   doctor.setDoctorFirstName("vadhana");
		   doctor.setDoctorLastName("swetha");
		   doctor.setDoctorName("vadhanaSwetha");
		   doctor.setDoctorExperience(1);
		   doctor.setDoctorGender("female");
		   doctor.setDoctorPhoneNumber("9840377829");
		   doctor.setDoctorQualification("M.B.B.S");
		   doctor.setDoctorSpeciality("ortho");   
		   
		   doctorList = new ArrayList<>();
		   doctorList.add(doctor);
		   
		   options = Optional.of(doctor);
	}
	
	@Test
	public void createDoctorDetailsSuccess() {
		when(doctorRepository.insert((Doctor) any())).thenReturn(doctor);
		Doctor doctorSaved = doctorServiceImpl.createDoctorDetails(doctor);
		assertEquals(doctor, doctorSaved);
		
	}
	
	@Test 
	public void createDoctorDetailsFailure() {
		when(doctorRepository.insert((Doctor) any())).thenReturn(null);
		Doctor doctorSaved = doctorServiceImpl.createDoctorDetails(doctor);
		assertEquals(doctor, doctorSaved);
	}
	
	@Test
	public void updateUser()  throws DoctorNotFoundException  {
		when(doctorRepository.findById(doctor.getDoctorEmail())).thenReturn(options);
		doctor.setDoctorFirstName("vadhana");
		Doctor fetchDoctor = doctorServiceImpl.updateDoctorDetails(doctor);
		assertEquals(doctor, fetchDoctor);
	}
	
/*	@Test
	public void getDoctorById() throws DoctorNotFoundException{
		when(doctorRepository.findById(doctor.getDoctorEmail())).thenReturn(options);
		doctor.setDoctorEmail("vadhana@gmail.com");
		Doctor fetchDoctor = doctorServiceImpl.getDoctorDetail(doctor.getDoctorEmail());
		assertEquals(doctor,fetchDoctor);
	}*/

}
