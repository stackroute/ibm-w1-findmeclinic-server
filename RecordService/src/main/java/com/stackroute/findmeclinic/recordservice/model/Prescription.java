package com.stackroute.findmeclinic.recordservice.model;

import java.util.List;

public class Prescription {
	
	private Patient patient;
	private Doctor doctor;
	private Appointment appointment;
	private String findings;
	private List<Medicine> medicines;
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Prescription(Patient patient, Doctor doctor, Appointment appointment, String findings,
			List<Medicine> medicines) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.appointment = appointment;
		this.findings = findings;
		this.medicines = medicines;
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

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "Prescription [patient=" + patient + ", doctor=" + doctor + ", appointment=" + appointment
				+ ", findings=" + findings + ", medicines=" + medicines + "]";
	}


	
	


}
