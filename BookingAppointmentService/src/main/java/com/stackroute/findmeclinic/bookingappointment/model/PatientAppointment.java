package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PatientAppointment {
	@Id
	private String patientEmail;
	private List<Appointment> appointments;
	
	
	public PatientAppointment() {
		super();
	}
	public PatientAppointment(String patientEmail, List<Appointment> appointments) {
		super();
		this.patientEmail = patientEmail;
		this.appointments = appointments;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		return "PatientAppointment [patientEmail=" + patientEmail + ", appointments=" + appointments + "]";
	}
	
	

}
