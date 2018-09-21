package com.stackroute.findmeclinic.bookingappointment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.findmeclinic.bookingappointment.model.DoctorAppointment;

public interface DoctorAppointmentRepository extends MongoRepository<DoctorAppointment,String> {

}
