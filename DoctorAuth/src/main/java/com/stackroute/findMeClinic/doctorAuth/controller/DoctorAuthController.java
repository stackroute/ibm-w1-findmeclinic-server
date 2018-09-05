package com.stackroute.findMeClinic.doctorAuth.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findMeClinic.doctorAuth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findMeClinic.doctorAuth.model.Doctor;
import com.stackroute.findMeClinic.doctorAuth.service.DoctorAuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Doctor login) throws ServletException {

	    String jwtToken = "";

	    if (login.getDoctorEmail() == null || login.getDoctorPassword() == null) {
	        throw new ServletException("Please fill in username and password");
	    }

	    String email = login.getDoctorEmail();
	    String password = login.getDoctorPassword();

	    Doctor doctor = docService.findDoctorBydoctorEmail(email);

	    if (doctor == null) {
	        throw new ServletException("User email not found.");
	    }

	    String pwd = doctor.getDoctorPassword();

	    if (!password.equals(pwd)) {
	        throw new ServletException("Invalid login. Please check your name and password.");
	    }

	    jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    return jwtToken;
	}

}
