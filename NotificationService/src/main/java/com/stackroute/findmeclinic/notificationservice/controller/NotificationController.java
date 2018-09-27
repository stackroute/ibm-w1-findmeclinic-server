package com.stackroute.findmeclinic.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.findmeclinic.notificationservice.model.Notification;
import com.stackroute.findmeclinic.notificationservice.service.Notificationservice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/notify")
@Api(value="Notification Resource")
public class NotificationController {
	/* @MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public String sendNotification(String name) throws Exception {
//	        Thread.sleep(1000); // simulated delay
		 System.out.println("name is"+ name);
		 return name;
//	        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	    }*/
	
	
	
	private Notificationservice notificationService;
	
	@Autowired
	public NotificationController(Notificationservice notificationService)
	{
		this.notificationService=notificationService;
	}
	
	@PostMapping()
	@ApiOperation("Posts the notification object from the BookingAppointmentService ")
	public ResponseEntity<?> getNotication( @RequestBody Notification notification){
		System.out.println("notification object"+ notification);
		ResponseEntity<?> responseEntity = null;
		
		if(notificationService.sendNotification(notification))
		{
		 responseEntity = new ResponseEntity<>(notification,HttpStatus.OK);
		}
		else {
			responseEntity = new ResponseEntity<>("cannot add", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	

	@ApiOperation("Fetching the patient details ")
	@GetMapping("/patient/{mail}")
<<<<<<< HEAD
=======

>>>>>>> 0eb474d0bb88f63ec6ae0969f0f835b59a3a23fc
	public ResponseEntity<?> getPatientNotication( @PathVariable String mail){
		ResponseEntity<?> responseEntity = null;
		List<Notification> patientNotification = notificationService.getPatientNotification(mail);
		if(patientNotification!=null)
		{
			 responseEntity = new ResponseEntity<>(patientNotification,HttpStatus.OK);

		}
		else
		{
			responseEntity = new ResponseEntity<>("no prescription", HttpStatus.CONFLICT);

		}
		
		return responseEntity;

	}
	
    @ApiOperation("Fetching the doctor details")
	@GetMapping("/doctor/{mail}")	
	public ResponseEntity<?> getDoctorNotication( @PathVariable String mail){
		ResponseEntity<?> responseEntity = null;
		List<Notification> patientNotification = notificationService.getDoctorNotification(mail);
		if(patientNotification!=null)
		{
			 responseEntity = new ResponseEntity<>(patientNotification,HttpStatus.OK);

		}
		else
		{
			responseEntity = new ResponseEntity<>("no prescription", HttpStatus.CONFLICT);

		}
		
		return responseEntity;

	}


}
