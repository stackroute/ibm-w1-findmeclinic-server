package com.stackroute.findMeClinic.patientAuth.exception;

public class PatientAlreadyExistsException extends Exception{

public static final long serialVersionID=1;
	
	public PatientAlreadyExistsException(String message) {
		super(message);
	}
	
}
