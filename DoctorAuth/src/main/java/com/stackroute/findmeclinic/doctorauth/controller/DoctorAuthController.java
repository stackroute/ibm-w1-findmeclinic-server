package com.stackroute.findmeclinic.doctorauth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.doctorauth.config.SecurityTokenGenerator;
import com.stackroute.findmeclinic.doctorauth.exception.DoctorEmailIdAndPasswordMismatchException;
import com.stackroute.findmeclinic.doctorauth.exception.DoctorNotFoundException;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.service.DoctorAuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/doctor/auth")
@CrossOrigin("*")
@Api(value="DoctorAuth Resource")
public class DoctorAuthController {

	private DoctorAuthService docService;

	public DoctorAuthController(DoctorAuthService docService) {
		this.docService = docService;
	}

	@PostMapping
	@ApiOperation("To Register as a Doctor")
	public ResponseEntity<?> registerDoctor(@RequestBody Doctor doctor) {
		ResponseEntity<?> responseEntity = null;

		try {
			if (docService.registerDoctor(doctor) != null) {
				responseEntity = new ResponseEntity<>(doctor, HttpStatus.OK);
			}
		} catch (Exception exception) {
			responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
		}

		return responseEntity;
	}

	@PostMapping("/login")
	@ApiOperation("To login as a Doctor")
	public ResponseEntity<?> loginDoctor(@RequestBody Doctor loginDetails) {
		try {
			String userId = loginDetails.getDoctorEmail();
			String password = loginDetails.getDoctorPassword();
			if (userId == null || password == null) {
				throw new DoctorNotFoundException("userid and Password cannot be empty");
			}
			Doctor doctor = docService.findDoctorByDoctorEmailAndDoctorPassword(userId, password);
			if (doctor == null) {
				throw new DoctorNotFoundException("Doctor with given Id does not exists");
			}
			String fetchedPassword = doctor.getDoctorPassword();
			if (!password.equals(fetchedPassword)) {
				throw new DoctorEmailIdAndPasswordMismatchException(
						"Invalid login credential, Please check email and password ");
			}
			// generating token
			SecurityTokenGenerator securityTokenGenrator = (Doctor doctorDetails) -> {
				String jwtToken = "";
				jwtToken = Jwts.builder().setSubject(doctor.getDoctorEmail()).setIssuedAt(new Date())
						.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
				Map<String, String> map1 = new HashMap<>();
				map1.put("token", jwtToken);
				
				return map1;
			};
			Map<String, String> map = securityTokenGenrator.generateToken(doctor);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (DoctorNotFoundException | DoctorEmailIdAndPasswordMismatchException exception) {
			return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}

}
