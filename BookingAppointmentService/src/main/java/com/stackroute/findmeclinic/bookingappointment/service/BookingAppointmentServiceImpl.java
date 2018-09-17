package com.stackroute.findmeclinic.bookingappointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.repository.BookingAppointmentRepository;


@Service
public class BookingAppointmentServiceImpl implements BookingAppointmentService {
	
	
	private BookingAppointmentRepository bookingRepository;
	@Autowired
	public BookingAppointmentServiceImpl(BookingAppointmentRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}
	
	
	@Override
	public BookingAppointment createBookingAppointment(BookingAppointment bookingDetails) {
	
		return null;
		
	}

	

	public BookingAppointment getAllAppointment() {
	
		return null;
	}

	
}
