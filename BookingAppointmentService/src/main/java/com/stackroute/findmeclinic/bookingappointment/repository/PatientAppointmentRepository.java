package com.stackroute.findmeclinic.bookingappointment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.findmeclinic.bookingappointment.model.PatientAppointment;

public interface PatientAppointmentRepository extends MongoRepository<PatientAppointment,String>{

}
