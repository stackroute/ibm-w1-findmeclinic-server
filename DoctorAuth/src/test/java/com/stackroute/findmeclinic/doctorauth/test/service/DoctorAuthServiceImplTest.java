package com.stackroute.findmeclinic.doctorauth.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsException;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.repository.DoctorAuthRepository;
import com.stackroute.findmeclinic.doctorauth.service.DoctorAuthServiceImpl;

public class DoctorAuthServiceImplTest {

	@Mock
	DoctorAuthRepository doctorAuth;

	Doctor doctor, doctor1;

	@InjectMocks
	DoctorAuthServiceImpl doctorImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		doctor = new Doctor();
		doctor1 = new Doctor();
	}

	@Test
	public void registerDoctorSuccess() throws DoctorAlreadyExistsException {
		when(doctorAuth.save((Doctor) any())).thenReturn(doctor);
		Doctor regDoctor = doctorImpl.registerDoctor(doctor);
		assertEquals(doctor, regDoctor);
	}

	@Test
	public void registerDoctorFailure() throws DoctorAlreadyExistsException {
		when(doctorAuth.save((Doctor) any())).thenReturn(doctor);
		Doctor regDoctor = doctorImpl.registerDoctor(doctor);
		assertNotEquals(doctor1, regDoctor);

	}

}
