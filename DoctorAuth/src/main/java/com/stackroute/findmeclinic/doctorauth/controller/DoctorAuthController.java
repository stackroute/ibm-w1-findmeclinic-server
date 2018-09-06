package com.stackroute.findmeclinic.doctorauth.controller;

import javax.persistence.RollbackException;
//import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.service.DoctorAuthService;

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
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

}
