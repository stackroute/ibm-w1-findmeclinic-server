package com.stackroute.findmeclinic.doctorauth.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.repository.DoctorAuthRepository;

@Service
public class DoctorAuthServiceImpl implements DoctorAuthService {

	private DoctorAuthRepository doctorAuth;

	@Autowired
	public DoctorAuthServiceImpl(DoctorAuthRepository doctorAuth) {
		this.doctorAuth = doctorAuth;

	}

	@Override
	public Doctor registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption {
		// boolean flag = false;
		String info = doctor.getDoctorEmail();

		try {
			if (!doctorAuth.existsById(info)
					&& (findDoctorBydoctorPhoneNumber(doctor.getDoctorPhoneNumber()) == null)) {
				doctorAuth.save(doctor);
				return doctor;
				// flag = true;
			} else {
				throw new DoctorAlreadyExistsEcxeption("Doctor Information already present");
			}

		} catch (NoSuchElementException exception) {
			throw new DoctorAlreadyExistsEcxeption("Doctor Information already present");
		}
	}

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber) {
		Doctor info = doctorAuth.findDoctorBydoctorPhoneNumber(doctorPhoneNumber);
		if (info != null) {
			return info;
		} else {
			return null;
		}
	}

	@Override
	public Doctor findDoctorByDoctorEmailAndDoctorPassword(String doctorEmail, String doctorPassword) {
		Doctor fetchedDoctor = doctorAuth.findDoctorByDoctorEmailAndDoctorPassword(doctorEmail, doctorPassword);
		return fetchedDoctor;
	}

}
