package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.List;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;

public interface BookingAppointmentService {
	
  public boolean createBookingAppointment(Appointment appointment);
  
  public List<Appointment> getAllAppointment();
	
  public void post(Appointment appointment) ;
}
