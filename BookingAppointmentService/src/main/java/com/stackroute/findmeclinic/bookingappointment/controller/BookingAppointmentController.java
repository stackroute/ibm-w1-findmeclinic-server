package com.stackroute.findmeclinic.bookingappointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Doctor;
import com.stackroute.findmeclinic.bookingappointment.service.BookingAppointmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/appointment")
@Api(value="BookingAppointment Resource")
public class BookingAppointmentController {

	

	private BookingAppointmentService bookingService;

	@Autowired
	public BookingAppointmentController(BookingAppointmentService bookingService) {
		this.bookingService = bookingService;
	}

	

	@PostMapping("/add")
	@ApiOperation("Saving the Appointment for particular slot")
	public ResponseEntity<?> createBooking(@RequestBody Appointment appointment) {
		ResponseEntity<?> responseEntity = null;
		
		try {
			if(bookingService.createBookingAppointment(appointment))	
			 responseEntity= new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
			else
				responseEntity= new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
		System.out.println(e);
			responseEntity= new ResponseEntity<Appointment>(HttpStatus.CONFLICT);
		}
		
		return responseEntity;

	}

	@GetMapping("/doctor/{id}")
	@ApiOperation("To get all the Appointments of the Doctor")
	public ResponseEntity<?> getAllAppointmentsByDoctorId(@PathVariable String id) {
		ResponseEntity<?> responseEntity = null;
		List<Appointment> list = bookingService.getAllAppointmentByDoctorId(id);
		if(bookingService.getAllAppointmentByDoctorId(id)!=null)
		{
			responseEntity= new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			responseEntity= new ResponseEntity<>("No Appointments Available",HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/patient/{id}")
	@ApiOperation("To get the Past Appointments of the Patient")
	public ResponseEntity<?> getAllAppointmentsByPatientId(@PathVariable String id) {
		ResponseEntity<?> responseEntity = null;
		List<Appointment> list = bookingService.getAllAppointmentByPatientId(id);
		if(bookingService.getAllAppointmentByPatientId(id)!=null)
		{
			responseEntity= new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			responseEntity= new ResponseEntity<>("No Appointments yet",HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}


}



