package com.stackroute.findmeclinic.notificationservice.model;

import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Notification {
	
	@Id
	private int notifyId;
	private String doctor;
	private String patient;
	private String content;
	private Date notifgenDate;
	
	public int getNotifyId() {
		return notifyId;
	}
	public void setNotifyId(int notifyId) {
		this.notifyId = notifyId;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNotifgenDate() {
		return notifgenDate;
	}
	public void setNotifgenDate(Date notifgenDate) {
		this.notifgenDate = notifgenDate;
	}
	@Override
	public String toString() {
		return "Notification [notifyId=" + notifyId + ", doctor=" + doctor + ", patient=" + patient + ", content="
				+ content + ", notifgenDate=" + notifgenDate + "]";
	}


	
	

	
}
