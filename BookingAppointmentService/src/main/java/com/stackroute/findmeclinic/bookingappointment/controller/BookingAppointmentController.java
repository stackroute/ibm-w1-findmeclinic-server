package com.stackroute.findmeclinic.bookingappointment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.service.BookingAppointmentService;

@RestController
@RequestMapping("/bookAppointment")
public class BookingAppointmentController {
	
	private BookingAppointmentService bookingService;

	public BookingAppointmentController(BookingAppointmentService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@PostMapping
	public ResponseEntity<?> createBooking(@RequestBody BookingAppointment bookappointment)
	{
	ResponseEntity<?> responseEntity= null;
	
	return responseEntity;
	

   }
	
	@GetMapping("/appointments")
	public ResponseEntity<?> getAllAppointments()
	{
		ResponseEntity<?> responseEntity= null;
		return responseEntity;
	}
	
	
	
	
	
}