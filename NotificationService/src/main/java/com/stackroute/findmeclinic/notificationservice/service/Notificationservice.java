package com.stackroute.findmeclinic.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;

public class Notificationservice {
	RestTemplate restTemplate;

	SimpMessagingTemplate messageTemplate;
	@Autowired
	public Notificationservice(RestTemplate restTemplate,SimpMessagingTemplate messageTemplate) {
		this.messageTemplate=messageTemplate;
		this.restTemplate=restTemplate;
	}
	HttpHeaders headers = new HttpHeaders();
	 String result = restTemplate.getForObject("http://localhost/api/v1/appointment", String.class);
	
	
}