package com.stackroute.findmeclinic.patientservice.controller;

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

import com.stackroute.findmeclinic.patientservice.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientservice.model.Patient;
import com.stackroute.findmeclinic.patientservice.service.PatientService;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin("*")
public class PatientController {

	
	private PatientService patientService;

	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	@PostMapping
	public ResponseEntity<?> registerPatientUser(@RequestBody Patient patient) {

		ResponseEntity<?> responseEntity = null;
		try {
			if (patientService.addPatient(patient) != null) {
				responseEntity = new ResponseEntity<>(patient, HttpStatus.CREATED);
			}
		} catch (PatientAlreadyExistsException exception) {
			responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@GetMapping("/{mailId}")
	public ResponseEntity<?> getPatientByEmailId(@PathVariable String mailId)
	{
		ResponseEntity<?> responseEntity = null;

		Patient patient=patientService.getPatientByEmail(mailId);
		responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/badge/{mailId}")
	
		public ResponseEntity<String> getPatientBadgeName(@PathVariable String mailId)
		{
			ResponseEntity<String> responseEntity = null;

			String badgeName=patientService.getPatientBadgeName(mailId);
			responseEntity = new ResponseEntity<String>(badgeName, HttpStatus.OK);
			return responseEntity;
		}
	
	@PutMapping("/{mailId}")
	public ResponseEntity<?> updatePatientDetail(@PathVariable String mailId,@RequestBody Patient patient)
	{
		ResponseEntity<?> responseEntity = null;

		Patient updatedPatient = patientService.updatePatient(patient);
		responseEntity = new ResponseEntity<>(updatedPatient, HttpStatus.OK);
		return responseEntity;
	
	}
		
	}

