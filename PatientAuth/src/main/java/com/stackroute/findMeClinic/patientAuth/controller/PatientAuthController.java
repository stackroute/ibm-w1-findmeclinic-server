package com.stackroute.findMeClinic.patientAuth.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findMeClinic.patientAuth.exception.PatientAlreadyExistsException;
import com.stackroute.findMeClinic.patientAuth.model.Patient;
import com.stackroute.findMeClinic.patientAuth.service.PatientService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin("*")
public class PatientAuthController {
	
	
	private PatientService patientService;
	
	
	@Autowired
	public PatientAuthController(PatientService patientService) {
		this.patientService=patientService;
	}
	
	@PostMapping
	public ResponseEntity<?> registerPatientUser(@RequestBody Patient patient){
		
		ResponseEntity<?> responseEntity= null;
		try {
			patientService.registerPatient(patient);
			responseEntity = new ResponseEntity<>(patient,HttpStatus.CREATED);
		}
		catch(PatientAlreadyExistsException exception) {
			responseEntity = new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	@PostMapping(value = "/login")
	public String loginPatient(@RequestBody Patient newPatient) throws ServletException {

	    String jwtToken = "";

	    if (newPatient.getPatientEmail() == null || newPatient.getPatientPassword() == null) {
	        throw new ServletException("Please fill in username and password");
	    }

	    String email = newPatient.getPatientEmail();
	    String password = newPatient.getPatientPassword();

	    Patient fetchedPatient  = patientService.getPatientByEmail(email);

	    if (fetchedPatient == null) {
	        throw new ServletException("User email not found.");
	    }

	    String pwd = fetchedPatient.getPatientPassword();

	    if (!password.equals(pwd)) {
	        throw new ServletException("Invalid login. Please check your name and password.");
	    }

	    jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    return jwtToken;
	}

}
