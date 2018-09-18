package com.stackroute.findmeclinic.bookingappointment.service;

import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;

public interface BookingAppointmentService {
	
  BookingAppointment createBookingAppointment(BookingAppointment bookingDetails);
  BookingAppointment getAllAppointment();
	

}
