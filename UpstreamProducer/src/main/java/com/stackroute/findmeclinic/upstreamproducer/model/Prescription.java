package com.stackroute.findmeclinic.upstreamproducer.model;

public class Prescription {
	
	private Patient patient;
	private Doctor doctor;
	private Appointment appointment;
	private String findings;
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prescription(Patient patient, Doctor doctor, Appointment appointment, String findings) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.appointment = appointment;
		this.findings = findings;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public String getFindings() {
		return findings;
	}
	public void setFindings(String findings) {
		this.findings = findings;
	}
	@Override
	public String toString() {
		return "Prescription [patient=" + patient + ", doctor=" + doctor + ", appointment=" + appointment
				+ ", findings=" + findings + "]";
	}
	
	

}
