package com.stackroute.findmeclinic.recordservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.recordservice.exception.PrescriptionNotAddedException;
import com.stackroute.findmeclinic.recordservice.service.RecordConsumerService;

@RestController
@RequestMapping("/api/v1/record")
@CrossOrigin("*")
public class RecordController {

	private RecordConsumerService recordService;

	public RecordController(RecordConsumerService recordService) {
		this.recordService = recordService;
	}

	@GetMapping("/patient/{patientEmail}")
	public ResponseEntity<?> getPatientPrescriptions(@PathVariable String patientEmail) {
		ResponseEntity<?> response = null;
		try {
			if (recordService.getPatientPrescription(patientEmail) != null) {
				response = new ResponseEntity<>(recordService.getPatientPrescription(patientEmail), HttpStatus.OK);
			}
		} catch (PrescriptionNotAddedException exception) {
			response = new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
		}
		return response;
	}

}
