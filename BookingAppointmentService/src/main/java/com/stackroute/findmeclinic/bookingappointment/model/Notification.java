package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.Date;

public class Notification {

	private String notification_id;
	private String doctorId;
    private String patientId;
    private String content;
    private Date notifgenDate;
    public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	

    public String getNotification_id() {
        return notification_id;
    }
    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
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
