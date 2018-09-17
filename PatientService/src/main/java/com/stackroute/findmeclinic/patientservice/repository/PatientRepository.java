package com.stackroute.findmeclinic.patientservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.findmeclinic.patientservice.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient,String>{

}
