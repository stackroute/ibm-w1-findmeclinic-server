package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
import com.stackroute.findmeclinic.bookingappointment.model.Schedule;

public interface BookingAppointmentService {
	
  public boolean createBookingAppointment(Appointment appointment);
  
 
	
//  public void post(Appointment appointment) ;
//  
//  public void listen(@Payload Schedule schedule);
//  
 public  List<Appointment> getAllAppointmentByDoctorId(String doctorEmail);
 public List<Appointment> getAllAppointmentByPatientId(String patientEmail);
	
}
