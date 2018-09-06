package com.stackroute.findmeclinic.patientauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.patientauth.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	public Patient findPatientBypatientPhoneNumber(String patientPhoneNumber);
	public Patient findPatientByPatientEmail(String patientEmail);
	public boolean existsBypatientPhoneNumber(String patientPhoneNumber);
}
