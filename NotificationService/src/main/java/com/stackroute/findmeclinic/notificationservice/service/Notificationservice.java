package com.stackroute.findmeclinic.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;

import com.stackroute.findmeclinic.notificationservice.model.Notification;

public class Notificationservice {
	RestTemplate restTemplate;

	SimpMessagingTemplate messageTemplate;
	@Autowired
	public Notificationservice(RestTemplate restTemplate,SimpMessagingTemplate messageTemplate) {
		this.messageTemplate=messageTemplate;
		this.restTemplate=restTemplate;
	}
	public void  sendNotification(Notification notifcation) {
		
	HttpHeaders headers = new HttpHeaders();
	
//	 Notification notif = restTemplate.getForObject("http://localhost/api/v1/appointment", Notification.class);
	
	 messageTemplate.convertAndSend("/topic/greetings", notifcation);
	 
	
	}
}