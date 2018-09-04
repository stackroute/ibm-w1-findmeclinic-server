package com.stackroute.findMeClinic.patientAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findMeClinic.patientAuth.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	public Patient findPatientBypatientPhoneNumber(String patientPhoneNumber);
}
