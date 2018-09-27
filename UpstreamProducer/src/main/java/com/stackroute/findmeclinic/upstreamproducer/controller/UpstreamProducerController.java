package com.stackroute.findmeclinic.upstreamproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;
import com.stackroute.findmeclinic.upstreamproducer.service.UpStreamProducerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api/v1/send")
@CrossOrigin("*")
@Api(value="Upstream Resource")
public class UpstreamProducerController {
	
	
	private UpStreamProducerServiceImpl service;
	
	@Autowired
	public UpstreamProducerController(UpStreamProducerServiceImpl service) {
		this.service = service;
	}
	
	

	@PostMapping()

	@ApiOperation("Produce the data into the topic")


	public ResponseEntity<?> sendToTopic(@RequestBody Prescription prescription){
		System.out.println("inside controller");
		service.sendPrescription(prescription);
		ResponseEntity<?> response = new ResponseEntity<>(prescription,HttpStatus.OK);
		return response;
		
		
	}

}
