package com.stackroute.findmeclinic.searchservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.searchservice.model.Doctor;
import com.stackroute.findmeclinic.searchservice.model.SearchDoctor;

@Repository
public interface SearchRepository extends CrudRepository<Doctor, String> {

	public List<Doctor> findAllByDoctorFirstName(String name);
}
