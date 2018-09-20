package com.stackroute.findmeclinic.recordservice.model;

public class Medicine {

	
	private String medicineName;
	private String timing;
	private String findings;
	
	public Medicine()
	{
		
	}
	
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getPatientLastName() {
		return findings;
	}

	public void setPatientLastName(String patientLastName) {
		this.findings = patientLastName;
	}
}
	
	