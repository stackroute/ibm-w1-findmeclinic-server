package com.stackroute.findmeclinic.doctorservices.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.doctorservices.exception.DoctorAlreadyExistException;
import com.stackroute.findmeclinic.doctorservices.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorservices.model.Doctor;
import com.stackroute.findmeclinic.doctorservices.model.DoctorAddress;
import com.stackroute.findmeclinic.doctorservices.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	private KafkaTemplate<String, List<Doctor>> kafkaTemplate;

	@Override
	public void sendDoctor(Doctor doctor) {

		// kafkaTemplate.send("DoctorService",doctor);

	}

	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository, KafkaTemplate<String, List<Doctor>> kafkaTemplate) {
		this.doctorRepository = doctorRepository;
		this.kafkaTemplate = kafkaTemplate;

	}

	@Override
	public Doctor createDoctorDetails(Doctor doctor) throws DoctorAlreadyExistException {
		if (doctorRepository.existsById(doctor.getDoctorEmail())) {
			throw new DoctorAlreadyExistException("Doctor already exist");
		} else {
			String name = doctor.getDoctorFirstName() + doctor.getDoctorLastName();
			doctor.setDoctorName(name);

			doctorRepository.insert(doctor);
		}
		return doctor;
	}

	public boolean addDoctorDetails(String doctorEmail, DoctorAddress doctorAddress) {

		Doctor doctorUser = new Doctor();
		List<DoctorAddress> doctorAdd = new ArrayList<>();
		int count = 1;
		boolean flag = false;
		if (doctorRepository.existsById(doctorEmail)) {
			doctorUser = doctorRepository.findById(doctorEmail).get();
			flag = true;

			if (doctorUser.getDoctorAddress() == null) {

				doctorAddress.setAddressNo(count);
				doctorAdd.add(doctorAddress);
				doctorUser.setDoctorAddress(doctorAdd);
				doctorRepository.save(doctorUser);

			} else {
				doctorAdd = doctorUser.getDoctorAddress();

				Iterator<DoctorAddress> iterator = doctorAdd.iterator();

				while (iterator.hasNext()) {
					count = iterator.next().getAddressNo();
				}
				doctorAddress.setAddressNo(count + 1);
				doctorUser.setDoctorAddress(doctorAdd);
				doctorAdd.add(doctorAddress);
				doctorUser.setDoctorAddress(doctorAdd);
				doctorRepository.save(doctorUser);

			}
		}

		return flag;
	}

	@Override
	public Doctor updateDoctorDetails(Doctor doctor) throws DoctorNotFoundException {
		if (doctorRepository.findById(doctor.getDoctorEmail()) != null) {
			doctorRepository.save(doctor);
		} else {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
		return doctor;
	}

	@Override
	public Doctor getDoctorDetail(String doctorEmail) throws DoctorNotFoundException {
		Doctor doctorFetch;
		if (doctorRepository.existsById(doctorEmail)) {
			doctorFetch = doctorRepository.findById(doctorEmail).get();
		} else {
			throw new DoctorNotFoundException("Doctor Not Found");

		}
		return doctorFetch;
	}

	@Override
	public String getBadge(String doctorEmail) {
		Doctor doctorFetch = new Doctor();
		doctorFetch = doctorRepository.findById(doctorEmail).get();
		String firstName = doctorFetch.getDoctorFirstName();
		String lastName = doctorFetch.getDoctorLastName();
		String badge = firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase();
		return badge;
	}

	@Override
	public List<Doctor> getDoctorByDoctorFirstName(String doctorFirstName) {
		List<Doctor> doctorFName = doctorRepository.findDoctorByDoctorFirstName(doctorFirstName);
		return doctorFName;
	}

	@Override
	public List<Doctor> getDoctorByDoctorLastName(String doctorLastName) {
		List<Doctor> doctorLName = doctorRepository.findDoctorByDoctorLastName(doctorLastName);
		return doctorLName;
	}

	@Override
	public List<Doctor> getDoctorByDoctorName(String doctorName) {
		List<Doctor> doctorNames = doctorRepository.findDoctorByDoctorName(doctorName);
		return doctorNames;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> allDoctor = doctorRepository.findAll();
//	kafkaTemplate.send("DoctorService", allDoctor);
		kafkaTemplate.send("DoctorService", "data", allDoctor);
		return allDoctor;

	}

}
