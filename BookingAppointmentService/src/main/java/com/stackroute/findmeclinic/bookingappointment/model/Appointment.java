package com.stackroute.findmeclinic.bookingappointment.model;

import org.springframework.data.annotation.Id;



public class Appointment {

	@Id
	private String appointmentId;
	private boolean appointmentStatus;
	private String bookedFor;
	private String bookingBy;


	
	public Appointment() {
		super();
	}



	public Appointment(String appointmentId, boolean appointmentStatus, String bookedFor, String bookingBy) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentStatus = appointmentStatus;
		this.bookedFor = bookedFor;
		this.bookingBy = bookingBy;
	}

	


	public String getAppointmentId() {
		return appointmentId;
	}



	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}



	public boolean isAppointmentStatus() {
		return appointmentStatus;
	}



	public void setAppointmentStatus(boolean appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}



	public String getBookedFor() {
		return bookedFor;
	}



	public void setBookedFor(String bookedFor) {
		this.bookedFor = bookedFor;
	}



	public String getBookingBy() {
		return bookingBy;
	}



	public void setBookingBy(String bookingBy) {
		this.bookingBy = bookingBy;
	}



	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentStatus=" + appointmentStatus
				+ ", bookedFor=" + bookedFor + ", bookingBy=" + bookingBy + "]";
	}
	
}