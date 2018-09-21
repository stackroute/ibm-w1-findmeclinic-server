package com.stackroute.findmeclinic.upstreamproducer.model;

import java.util.Date;

public class BookingAppointment {
	
	private String bookingId;
	private Date bookingDate;
	private String bookingStatus;
	private Doctor bookedFor;
	private Patient BookedBy;
	private Schedule bookedAt;
	public BookingAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingAppointment(String bookingId, Date bookingDate, String bookingStatus, Doctor bookedFor,
			Patient bookedBy, Schedule bookedAt) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.bookedFor = bookedFor;
		BookedBy = bookedBy;
		this.bookedAt = bookedAt;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Doctor getBookedFor() {
		return bookedFor;
	}
	public void setBookedFor(Doctor bookedFor) {
		this.bookedFor = bookedFor;
	}
	public Patient getBookedBy() {
		return BookedBy;
	}
	public void setBookedBy(Patient bookedBy) {
		BookedBy = bookedBy;
	}
	public Schedule getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(Schedule bookedAt) {
		this.bookedAt = bookedAt;
	}

	
	
}
