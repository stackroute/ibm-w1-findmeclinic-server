package com.stackroute.findmeclinic.doctorservices.exception;

public class DoctorAlreadyExistException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	public DoctorAlreadyExistException (String message)
	{
		super(message);
	}

}
