package com.stackroute.findmeclinic.doctorservices.service;





import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.doctorservices.exception.DoctorAlreadyExistException;
import com.stackroute.findmeclinic.doctorservices.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorservices.model.Doctor;
import com.stackroute.findmeclinic.doctorservices.model.DoctorAddress;
import com.stackroute.findmeclinic.doctorservices.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;
	

	
	@Autowired
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository=doctorRepository;
	}
	
	@Override
	public Doctor createDoctorDetails(Doctor doctor) throws DoctorAlreadyExistException {
		if(doctorRepository.existsById(doctor.getDoctorEmail())) {
			throw new DoctorAlreadyExistException("Doctor already exist");
		}
		else {
			String name=doctor.getDoctorFirstName()+" "+doctor.getDoctorLastName();
			doctor.setDoctorName(name);
			
			doctorRepository.insert(doctor);
		}
		return doctor;
	}



	public boolean addDoctorDetails(String doctorEmail,DoctorAddress doctorAddress){
		
		Doctor doctorUser = new Doctor();
		List<DoctorAddress>  doctorAdd =new ArrayList<>();
		int count=1;
		
		if(doctorRepository.existsById(doctorEmail)) {
			doctorUser = doctorRepository.findById(doctorEmail).get();
			doctorAdd = doctorUser.getDoctorAddress();
			Iterator<DoctorAddress> doctorIterator = doctorAdd.iterator();
			while(doctorIterator.hasNext()) {
				count = doctorIterator.next().getAddressNo();
			}
		    doctorAddress.setAddressNo(count+1);
		    doctorUser.setDoctorAddress(doctorAdd);
		    doctorAdd.add(doctorAddress);
		    Doctor addressOfDoctor = doctorRepository.save(doctorUser);
		   
		    if(addressOfDoctor == null) {
		    	return false;
		    }
		    else {
		    	return true;
		    }
		    
		}
		else {
			doctorUser.setDoctorEmail(doctorEmail);
			doctorAddress.setAddressNo(count);
			doctorAdd.add(doctorAddress);
			doctorUser.setDoctorAddress(doctorAdd);
			Doctor addressOfDoctor = doctorRepository.insert(doctorUser);
			 
			if(addressOfDoctor == null) {
				return false;
			}
			return true;
		}
		
		
	}

	@Override
	public Doctor updateDoctorDetails(Doctor doctor) throws DoctorNotFoundException {
		if(doctorRepository.findById(doctor.getDoctorEmail()) != null) {
			doctorRepository.save(doctor);
		}
		else {
			throw new DoctorNotFoundException("Doctor Not Found");
		}
		return doctor;
	}

	@Override
	public Doctor getDoctorDetail(String doctorEmail) throws DoctorNotFoundException {
	 Doctor doctorFetch;
	 if(doctorRepository.existsById(doctorEmail)) {
		 doctorFetch = doctorRepository.findById(doctorEmail).get();
	 }
	 else {
			throw new DoctorNotFoundException("Doctor Not Found");

	 }
		return doctorFetch;
	}

	@Override
	public List<Doctor> getAllDoctorsByDoctorName(String doctorName) {
		List<Doctor> list=doctorRepository.findAllByDoctorName(doctorName);
		return list;
	}


	@Override
	public String getBadge(String doctorEmail) {
		Doctor doctorFetch = new Doctor();
		doctorFetch = doctorRepository.findById(doctorEmail).get();
		String firstName = doctorFetch.getDoctorFirstName();
		String lastName = doctorFetch.getDoctorLastName();
		String badge = firstName.substring(0,1).toUpperCase()+lastName.substring(0,1).toUpperCase();
		return badge;
	}

	@Override
     public String getDocIdByDocName(String doctorName) {
		
		Doctor doctor=doctorRepository.findDoctorByDoctorName(doctorName);
		String doctorEmail=doctor.getDoctorEmail();
		return doctorEmail;
    	 
     }

}
