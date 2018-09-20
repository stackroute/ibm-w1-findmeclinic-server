package com.stackroute.findmeclinic.recordservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.recordservice.model.Prescription;

@Repository
public interface RecordRepository extends MongoRepository<Prescription, String>{

}
