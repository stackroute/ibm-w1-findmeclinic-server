package com.stackroute.findmeclinic.upstreamproducer.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Prescription {
	
	private Patient patient;
	private Doctor doctor;
	private String findings;
	private String medicine;
	
	public Prescription() {
		super();
	}

	public Prescription(Patient patient, Doctor doctor, String findings, String medicine) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.findings = findings;
		this.medicine = medicine;
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

	public String getFindings() {
		return findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	@Override
	public String toString() {
		return "Prescription [patient=" + patient + ", doctor=" + doctor + ", findings=" + findings + ", medicine="
				+ medicine + "]";
	}
	
	
}
