package com.stackroute.findmeclinic.doctorservices.repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.doctorservices.model.Doctor;


@Repository
public interface  DoctorRepository  extends MongoRepository<Doctor,String> {
}
