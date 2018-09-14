package com.stackroute.findmeclinic.doctorauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.doctorauth.model.Doctor;

@Repository
public interface DoctorAuthRepository extends JpaRepository<Doctor, String> {

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);

	public Doctor findDoctorBydoctorEmail(String doctorEmail);

	public Doctor findDoctorByDoctorEmailAndDoctorPassword(String doctorEmail, String doctorPassword);

}
