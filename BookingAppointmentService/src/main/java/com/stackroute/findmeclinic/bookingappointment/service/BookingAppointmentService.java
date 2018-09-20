package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.List;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;

public interface BookingAppointmentService {
	
  boolean createBookingAppointment(Appointment appointment);
  
  List<Appointment> getAllAppointment();
	

}
