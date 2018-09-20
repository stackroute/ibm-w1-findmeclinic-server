package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
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
	public boolean createBookingAppointment(Appointment appointment) {
		boolean flag=false;
		
		if(bookingRepository.insert(appointment)!=null)
			flag=true;
		return flag;
		
	}

	
	@Override
	public List<Appointment> getAllAppointment() {
	
			List<Appointment> list=null;
			
			  list=bookingRepository.findAll();
			
			return list;
	}

	
}
