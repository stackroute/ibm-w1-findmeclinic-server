package com.stackroute.findMeClinic.patientAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.findMeClinic.patientAuth.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
