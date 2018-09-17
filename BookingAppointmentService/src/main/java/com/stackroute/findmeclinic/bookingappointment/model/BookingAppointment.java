package com.stackroute.findmeclinic.bookingappointment.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class BookingAppointment {
	@Id
	private String bookingId;
    private Date bookingDate;
	private String bookingStatus;
    private Doctor bookedFor;
	private Patient BookedBy;
	private Calender bookedAt;
	
	
	
	public BookingAppointment() {
		super();
	}
	public BookingAppointment(String bookingId, Date bookingDate, String bookingStatus, Doctor bookedFor,
			Patient bookedBy, Calender bookedAt) {
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
	public Calender getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(Calender bookedAt) {
		this.bookedAt = bookedAt;
	}
	@Override
	public String toString() {
		return "BookingAppointment [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingStatus="
				+ bookingStatus + ", bookedFor=" + bookedFor + ", BookedBy=" + BookedBy + ", bookedAt=" + bookedAt
				+ "]";
	}
	
	
	

}
