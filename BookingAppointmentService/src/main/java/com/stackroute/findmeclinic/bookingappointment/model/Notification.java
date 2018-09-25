package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.Date;

public class Notification {

	private String notification_id;
    private String doctor;
    private String patient;
    private String content;
    private Date notifgenDate;

    public String getNotification_id() {
        return notification_id;
    }
    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
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
		return "Notification [notification_id=" + notification_id + ", doctor=" + doctor + ", patient=" + patient
				+ ", content=" + content + ", notifgenDate=" + notifgenDate + "]";
	}
    
}
