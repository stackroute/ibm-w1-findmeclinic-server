package com.stackroute.findmeclinic.bookingappointment.model;

public class DoctorCalender {

	private Doctor doctor;
	private Calender calender;
	
	
	public DoctorCalender() {
		super();
	}
	
	public DoctorCalender(Doctor doctor, Calender calender) {
		super();
		this.doctor = doctor;
		this.calender = calender;
	}
	
	
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Calender getCalender() {
		return calender;
	}
	public void setCalender(Calender calender) {
		this.calender = calender;
	}
	
	@Override
	public String toString() {
		return "DoctorCalender [doctor=" + doctor + ", calender=" + calender + "]";
	}
	
}
