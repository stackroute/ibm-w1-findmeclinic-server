package com.stackroute.findMeClinic.doctorAuth.controller;

import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findMeClinic.doctorAuth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findMeClinic.doctorAuth.model.Doctor;
import com.stackroute.findMeClinic.doctorAuth.service.DoctorAuthService;


@RestController
@RequestMapping("/Doctor/Auth")
@CrossOrigin("*")
public class DoctorAuthController {

	private DoctorAuthService docService;

	public DoctorAuthController(DoctorAuthService docService) {
		this.docService = docService;
	}

	@PostMapping

	public ResponseEntity<?> registerDoctor(@RequestBody Doctor doctor) {
		ResponseEntity<?> responseEntity = null;

		try {
			if (docService.registerDoctor(doctor)) {
				responseEntity = new ResponseEntity<>(doctor, HttpStatus.OK);
			}
		} catch (DoctorAlreadyExistsEcxeption exception) {
			responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
		}

		return responseEntity;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginToken(@RequestBody Doctor login) throws ServletException {
		ResponseEntity<?> responseEntity = null;
		String jwtToken="";
		try {
			jwtToken=docService.loginToken(login);
			responseEntity = new ResponseEntity<>(jwtToken, HttpStatus.OK);
		}
		catch(Exception e) {
			responseEntity=new ResponseEntity<>("user or password not found",HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}	
   

}
