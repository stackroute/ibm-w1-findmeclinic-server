package com.stackroute.findmeclinic.doctorservices.service;




import java.util.List;

import com.stackroute.findmeclinic.doctorservices.exception.DoctorAlreadyExistException;
import com.stackroute.findmeclinic.doctorservices.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorservices.model.Doctor;
import com.stackroute.findmeclinic.doctorservices.model.DoctorAddress;

public interface DoctorService {

	public void sendDoctor(Doctor doctor);
	public Doctor createDoctorDetails(Doctor doctor) throws DoctorAlreadyExistException ;
	
	public boolean addDoctorDetails(String doctorEmail,DoctorAddress doctorAddress);
	
	public Doctor updateDoctorDetails(Doctor doctor) throws DoctorNotFoundException;
	
	public Doctor getDoctorDetail(String doctorEmail) throws DoctorNotFoundException;
	 

	public String getBadge(String doctorEmail);
	
	public List<Doctor> getDoctorByDoctorFirstName(String doctorFirstName);
	
	
	public List<Doctor> getDoctorByDoctorLastName(String doctorLastName);
	
	
	
	public List<Doctor> getAllDoctor();
	
	public String getDocIdByDocName(String doctorName);
}
