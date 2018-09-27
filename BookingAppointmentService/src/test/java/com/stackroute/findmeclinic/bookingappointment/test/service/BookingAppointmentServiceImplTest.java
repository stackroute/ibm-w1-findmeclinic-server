package com.stackroute.findmeclinic.bookingappointment.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
import com.stackroute.findmeclinic.bookingappointment.model.DoctorAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.PatientAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Slot;
import com.stackroute.findmeclinic.bookingappointment.repository.DoctorAppointmentRepository;
import com.stackroute.findmeclinic.bookingappointment.repository.PatientAppointmentRepository;
import com.stackroute.findmeclinic.bookingappointment.service.BookingAppointmentServiceImpl;

import junit.framework.Assert;


public class BookingAppointmentServiceImplTest {
	
	@MockBean
	private Appointment appointment;
	@MockBean
	private DoctorAppointment docApp;
	@MockBean
	private PatientAppointment patApp;
	@MockBean
	 private Slot slot;
	
	@Mock
	DoctorAppointmentRepository doctorAppointment;
	PatientAppointmentRepository patientAppointment;

	@InjectMocks
	BookingAppointmentServiceImpl bookImpl;
	private List<Appointment> list =null;
	Optional<DoctorAppointment> options1;
	Optional<PatientAppointment> options2;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		//SLOT
		slot= new Slot();
		slot.setSlotId(4);
		//slot.setSlotStart(10:30:30);
		slot.setTimePerPatient(9);
		slot.setStatus("active");
		
		//APPOINTMENT
		appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setAppointmentStatus(true);
		appointment.setBookedFor("raina@gmail.com");
		appointment.setBookingBy("gracia@gmail.com");
		appointment.setSlot(slot);
		List<Appointment> appList = new ArrayList<>();
		appList.add(appointment);
		
		
		//DOCTOR-APPOINTMENT
		docApp=new DoctorAppointment();
		docApp.setDoctorEmail("raina@gmail.com");
		docApp.setAppointments(appList);
		
		options1 =Optional.of(docApp);
		
		//PATIENT-APPOINTMENT
		patApp= new PatientAppointment();
		patApp.setPatientEmail("gracia@gmail.com");
		patApp.setAppointments(appList);
		
		options2= Optional.of(patApp);
		
	
	}

	@Test
	public void getAllAppointmentByDoctorId() {
		// when(doctorAppointment.insert((DoctorAppointment) any())).thenReturn(docApp);
		when(doctorAppointment.findById(appointment.getBookedFor())).thenReturn(options1);
		System.out.println(options1);
		List<Appointment> apps = bookImpl.getAllAppointmentByDoctorId(docApp.getDoctorEmail());
		System.out.println(apps);
		Assert.assertEquals(apps,options1);
		}

	@Test
	public void getAllAppointmentByPatientId() {
		when(patientAppointment.findById(appointment.getBookingBy())).thenReturn(options2);
		System.out.println(options2);
		List<Appointment> apps = bookImpl.getAllAppointmentByDoctorId(patApp.getPatientEmail());
		Assert.assertEquals(patApp,options2);
		
	}


}
