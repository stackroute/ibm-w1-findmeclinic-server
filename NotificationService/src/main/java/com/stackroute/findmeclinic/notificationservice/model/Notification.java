package com.stackroute.findmeclinic.notificationservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Notification {
	@Id
	private String notification_id;
	private String doctor;
	private String patient;
	private String content;
	private Date notifgenDate;

	
	

	
}
