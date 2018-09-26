package com.stackroute.findmeclinic.searchservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.findmeclinic.searchservice.model.Doctor;
import com.stackroute.findmeclinic.searchservice.services.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/search")
@Api(value="Search Resource")
public class SearchController {

	private SearchService searchService;

	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

	@MessageMapping("/doc-name")
	@ApiOperation(" ")
	public String greeting(String name) throws Exception {
		System.out.println("name" + name);
		searchService.getDoctorByName(name);
		return name;
	}

	@GetMapping("/{name}")
	@ApiOperation(" ")
	public ResponseEntity getAllDoctor(@PathVariable() String name) {
		ResponseEntity responseEntity = null;
		System.out.println(11);

		 searchService.getDoctorByName(name);

		responseEntity = new ResponseEntity<>( HttpStatus.OK);
		searchService.getDoctorByName(name);

		responseEntity = new ResponseEntity<>(HttpStatus.OK);

		return responseEntity;

	}
	
//	@GetMapping("/place/{locality}")
//	public ResponseEntity<?> getDocLocation(@PathVariable String locality){
//		ResponseEntity<?> responseEntity=null;
//		List<Doctor> d=searchService.getDoctorByLocality(locality);
//		if(d!=null) {
//			responseEntity=new ResponseEntity<>(d,HttpStatus.OK);
//		}
//		else {
//			responseEntity=new ResponseEntity<>("Doctor not found",HttpStatus.BAD_REQUEST);
//		}
//		return responseEntity;
//		
//	}
//	

}
