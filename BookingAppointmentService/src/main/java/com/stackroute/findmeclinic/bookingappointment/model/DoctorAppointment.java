package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DoctorAppointment {
	@Id
	private String doctorEmail;
	private List<Appointment> appointments;
	
	
	public DoctorAppointment() {
		super();
	}
	public DoctorAppointment(String doctorEmail, List<Appointment> appointments) {
		super();
		this.doctorEmail = doctorEmail;
		this.appointments = appointments;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		return "DoctorAppointment [doctorEmail=" + doctorEmail + ", appointments=" + appointments + "]";
	}
	
	

}