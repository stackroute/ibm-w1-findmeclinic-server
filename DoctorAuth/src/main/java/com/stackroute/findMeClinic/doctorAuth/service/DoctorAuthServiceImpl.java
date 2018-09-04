package com.stackroute.findMeClinic.doctorAuth.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findMeClinic.doctorAuth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findMeClinic.doctorAuth.model.Doctor;
import com.stackroute.findMeClinic.doctorAuth.repository.DoctorAuthRepository;

@Service
public class DoctorAuthServiceImpl implements DoctorAuthService {

	private DoctorAuthRepository doctorAuth;

	@Autowired
	public DoctorAuthServiceImpl(DoctorAuthRepository doctorAuth) {
		this.doctorAuth = doctorAuth;
	}

	@Override
	public boolean registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption {
		boolean flag = false;
		String info = doctor.getEmail();

		try {
			if (!doctorAuth.existsById(info) && (findDoctorByphoneNumber(doctor.getPhoneNumber()) == null)) {
				doctorAuth.save(doctor);
				flag = true;
			} else {
				throw new DoctorAlreadyExistsEcxeption("Doctor Informatio already present");
			}
			if (flag == true) {
				return flag;
			} else {
				return false;
			}
		} catch (NoSuchElementException exception) {
			throw new DoctorAlreadyExistsEcxeption("Doctor Informatio already present");
		}
	}

	public Doctor findDoctorByphoneNumber(String phoneNumber) {
		Doctor info = doctorAuth.findDoctorByphoneNumber(phoneNumber);
		if (info != null) {
			return info;
		} else {
			return null;
		}
	}
}
