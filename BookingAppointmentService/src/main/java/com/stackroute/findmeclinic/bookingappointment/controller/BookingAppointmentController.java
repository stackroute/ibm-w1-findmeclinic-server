package com.stackroute.findmeclinic.bookingappointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/appointment")
public class BookingAppointmentController {

	

	private BookingAppointmentService bookingService;

	@Autowired
	public BookingAppointmentController(BookingAppointmentService bookingService) {
		this.bookingService = bookingService;
	}


	@PostMapping("/publish")
	public ResponseEntity<?>  produceToTopic(@RequestBody Appointment appointment) {

		ResponseEntity<?> responseEntity = null;
		
		bookingService.post(appointment);
		
		responseEntity= new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);

		return responseEntity;

	}
	

	@PostMapping("/add")
	public ResponseEntity<?> createBooking(@RequestBody Appointment appointment) {
		ResponseEntity<?> responseEntity = null;
		
		try {
			if(bookingService.createBookingAppointment(appointment))	
			 responseEntity= new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
			else
				responseEntity= new ResponseEntity<Appointment>(HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			responseEntity= new ResponseEntity<Appointment>(HttpStatus.CONFLICT);
		}
		
		return responseEntity;

	}

	@GetMapping("/appointments")
	public ResponseEntity<?> getAllAppointments() {
		ResponseEntity<?> responseEntity = null;
		
		List<Appointment> list=bookingService.getAllAppointment();
		if(bookingService.getAllAppointment()!=null)

			responseEntity= new ResponseEntity<>(list,HttpStatus.OK);
		
		return responseEntity;
	}

}



