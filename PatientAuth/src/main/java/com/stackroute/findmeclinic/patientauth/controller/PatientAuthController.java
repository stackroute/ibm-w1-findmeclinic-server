package com.stackroute.findmeclinic.patientauth.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.patientauth.config.SecurityTokenGenerator;
import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.exception.PatientEmailIdAndPasswordMismatchException;
import com.stackroute.findmeclinic.patientauth.exception.PatientNotFoundException;
import com.stackroute.findmeclinic.patientauth.model.Patient;
import com.stackroute.findmeclinic.patientauth.service.PatientService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/patientauth")
@CrossOrigin("*")
public class PatientAuthController {

	private PatientService patientService;

	@Autowired
	public PatientAuthController(PatientService patientService) {
		this.patientService = patientService;
	}

	@PostMapping
	public ResponseEntity<?> registerPatientUser(@RequestBody Patient patient) {

		ResponseEntity<?> responseEntity = null;
		try {
			if (patientService.registerPatient(patient) != null) {
				responseEntity = new ResponseEntity<>(patient, HttpStatus.CREATED);
			}
		} catch (PatientAlreadyExistsException exception) {
			responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginPatient(@RequestBody Patient loginDetails) {
		try {
			String userId = loginDetails.getPatientEmail();
			String password = loginDetails.getPatientPassword();
			// String userPhone= loginDetails.getPatientPhoneNumber();
			if (userId == null || password == null) {
				throw new PatientNotFoundException("userid and Password cannot be empty");
			}
			Patient patient = patientService.findPatientByPatientEmailAndPatientPassword(userId, password);
			// Patient patient1 =
			// patientService.findPatientBypatientEmailAndpatientPassword(userPhone,
			// password);
			if (patient == null) {
				throw new PatientNotFoundException("Patient with given Id does not exists");
			}
			String fetchedPassword = patient.getPatientPassword();
			if (!password.equals(fetchedPassword)) {
				throw new PatientEmailIdAndPasswordMismatchException(
						"Invalid login credential, Please check email and password ");
			}
			// generating token
			SecurityTokenGenerator securityTokenGenrator = (Patient patientDetails) -> {
				String jwtToken = "";
				jwtToken = Jwts.builder().setSubject(patient.getPatientEmail()).setIssuedAt(new Date())
						.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
				Map<String, String> map1 = new HashMap<>();
				map1.put("token", jwtToken);
				map1.put("userId", patient.getPatientEmail());
				map1.put("message", "User successfully logged in");
				return map1;
			};
			Map<String, String> map = securityTokenGenrator.generateToken(patient);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (PatientNotFoundException | PatientEmailIdAndPasswordMismatchException exception) {
			return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}

}
