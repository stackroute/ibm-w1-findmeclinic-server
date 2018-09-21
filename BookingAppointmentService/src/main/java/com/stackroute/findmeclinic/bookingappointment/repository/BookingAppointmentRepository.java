package com.stackroute.findmeclinic.bookingappointment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;

public interface BookingAppointmentRepository extends MongoRepository<Appointment,String> {

}
