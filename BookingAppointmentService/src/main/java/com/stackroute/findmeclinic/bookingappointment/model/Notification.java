package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.Date;

public class Notification {
	private  String notification_id;
	private String user_id;
	private String content;
	private Date notifgenDate;
	public String getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

}
