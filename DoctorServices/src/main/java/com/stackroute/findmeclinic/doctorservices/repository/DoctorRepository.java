package com.stackroute.findmeclinic.doctorservices.repository;




import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.doctorservices.model.Doctor;


@Repository
public interface  DoctorRepository  extends MongoRepository<Doctor,String> {
	List<Doctor> findAllByDoctorName(String doctorName);
	
	Doctor findDoctorByDoctorName(String doctorName);

}
