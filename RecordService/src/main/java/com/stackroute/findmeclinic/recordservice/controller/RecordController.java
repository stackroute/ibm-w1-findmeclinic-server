package com.stackroute.findmeclinic.recordservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.stackroute.findmeclinic.recordservice.exception.PrescriptionNotAddedException;
import com.stackroute.findmeclinic.recordservice.service.RecordConsumerService;
import com.stackroute.findmeclinic.recordservice.storage.StorageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/record")
@CrossOrigin("*")
@Api(value="Record Resource")

public class RecordController {
	
	@Autowired
	StorageService storageService;

	private RecordConsumerService recordService;

	public RecordController(RecordConsumerService recordService) {
		this.recordService = recordService;
	}

	@GetMapping("/patient/{patientEmail}")
	@ApiOperation("Fetches the list of prescription for particular emailId")
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

	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	@ApiOperation(" ")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.store(file);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("/getallfiles")
	@ApiOperation(" ")
	public ResponseEntity<List<String>> getListFiles(Model model) {
		List<String> fileNames = files
				.stream().map(fileName -> MvcUriComponentsBuilder
						.fromMethodName(RecordController.class, "getFile", fileName).build().toString())
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	@ApiOperation(" ")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}



