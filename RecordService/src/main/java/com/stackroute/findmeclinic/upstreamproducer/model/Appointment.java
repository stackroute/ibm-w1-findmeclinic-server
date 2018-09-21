package com.stackroute.findmeclinic.upstreamproducer.model;

public class Appointment {

	private String appointmentId;
    private boolean appointmentStatus;
    private Doctor doctor;
    private BookingAppointment booking;
	public Appointment() {
		super();
	}
	public Appointment(String appointmentId, boolean appointmentStatus, Doctor doctor, BookingAppointment booking) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentStatus = appointmentStatus;
		this.doctor = doctor;
		this.booking = booking;
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public BookingAppointment getBooking() {
		return booking;
	}
	public void setBooking(BookingAppointment booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentStatus=" + appointmentStatus + ", doctor="
				+ doctor + ", booking=" + booking + "]";
	}
    
	
}
