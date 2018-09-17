package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.Date;

import org.springframework.data.annotation.Id;


public class Calender {
	@Id
	private String calenderId;
	private Date startTime;
	private Date endTime;
	private String location;
	private int timePerPatient;
	private int numberOfPatient;
	private Doctor createdBy;
	private Date createAt;
	
	
	public Calender() {
		super();
	}
	public Calender(String calenderId, Date startTime, Date endTime, String location, int timePerPatient,
			int numberOfPatient, Doctor createdBy, Date createAt) {
		super();
		this.calenderId = calenderId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.timePerPatient = timePerPatient;
		this.numberOfPatient = numberOfPatient;
		this.createdBy = createdBy;
		this.createAt = createAt;
	}
	public String getCalenderId() {
		return calenderId;
	}
	public void setCalenderId(String calenderId) {
		this.calenderId = calenderId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTimePerPatient() {
		return timePerPatient;
	}
	public void setTimePerPatient(int timePerPatient) {
		this.timePerPatient = timePerPatient;
	}
	public int getNumberOfPatient() {
		return numberOfPatient;
	}
	public void setNumberOfPatient(int numberOfPatient) {
		this.numberOfPatient = numberOfPatient;
	}
	public Doctor getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Doctor createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "Calender [calenderId=" + calenderId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", location=" + location + ", timePerPatient=" + timePerPatient + ", numberOfPatient="
				+ numberOfPatient + ", createdBy=" + createdBy + ", createAt=" + createAt + "]";
	}
	
	
	

}
