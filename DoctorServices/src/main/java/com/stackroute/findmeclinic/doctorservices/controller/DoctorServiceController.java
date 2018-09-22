package com.stackroute.findmeclinic.doctorservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.doctorservices.exception.DoctorAlreadyExistException;
import com.stackroute.findmeclinic.doctorservices.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorservices.model.Doctor;
import com.stackroute.findmeclinic.doctorservices.model.DoctorAddress;
import com.stackroute.findmeclinic.doctorservices.service.DoctorService;

@RestController
@RequestMapping("/api/v2/doctor")
@CrossOrigin("*")
public class DoctorServiceController {

	private DoctorService doctorService;

	@Autowired
	public DoctorServiceController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@PostMapping
	public ResponseEntity<?> addDoctorInfo(@RequestBody Doctor doctor) {
		ResponseEntity<?> responseEntity;
		try {
			doctorService.createDoctorDetails(doctor);
			responseEntity = new ResponseEntity<>(doctor, HttpStatus.CREATED);

		} catch (DoctorAlreadyExistException exception) {
			responseEntity = new ResponseEntity<>("Doctor Already exist ", HttpStatus.CONFLICT);

		}

		return responseEntity;

	}

	@PostMapping("/{id}")
	public ResponseEntity<?> addDoctorBasicDetails(@RequestBody DoctorAddress doctorAddress, @PathVariable String id) {

		ResponseEntity<?> responseEntity;

		try {
			doctorService.addDoctorDetails(id, doctorAddress);
			responseEntity = new ResponseEntity<>(doctorAddress, HttpStatus.OK);

		}

		catch (Exception e) {
			responseEntity = new ResponseEntity<>("Doctor Already exist ", HttpStatus.CONFLICT);

		}
		return responseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctorDetails(@PathVariable String id, @RequestBody Doctor doctor) {
		ResponseEntity<?> responseEntity;
		try {
			doctorService.updateDoctorDetails(doctor);
			responseEntity = new ResponseEntity<>(doctor, HttpStatus.CREATED);
		} catch (Exception ex) {
			responseEntity = new ResponseEntity<>("Doctor Already exist ", HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDoctorBasicDetails(@PathVariable String id) {
		ResponseEntity<?> responseEntity;
		try {
			if (doctorService.getDoctorDetail(id) != null) {
				responseEntity = new ResponseEntity<>(doctorService.getDoctorDetail(id), HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>("Doctor Already exist ", HttpStatus.NOT_FOUND);

			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("Doctor Already exist ", HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}

	@GetMapping("/get/{doctorName}")
	public ResponseEntity<?> getAllDoctors(@PathVariable("doctorName") String doctorName){
		ResponseEntity<?> responseEntity = null;
		if(doctorService.getAllDoctorsByDoctorName(doctorName)!=null) {
			responseEntity=new ResponseEntity<>(doctorService.getAllDoctorsByDoctorName(doctorName),HttpStatus.OK);
			
		}
		else {
			responseEntity = new ResponseEntity<>("Not Found!", HttpStatus.NOT_FOUND);

		}
		return responseEntity;

	}
	
	@GetMapping("/badge/{id}")
	public ResponseEntity<String> getBadge(@PathVariable String id){
		ResponseEntity<String> responseEntity;
		
		String badge = doctorService.getBadge(id);
		responseEntity = new ResponseEntity<String>(badge, HttpStatus.OK);
		return responseEntity;
	}

	
	
	@GetMapping("/email/{doctorName}")
	public ResponseEntity<String> getDocEmailByName(@PathVariable String doctorName){
		ResponseEntity<String> responseEntity;
		
		String doctorEmail=doctorService.getDocIdByDocName(doctorName);
		responseEntity = new ResponseEntity<String>(doctorEmail, HttpStatus.OK);
		return responseEntity;
	}
	

}
