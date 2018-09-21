package com.stackroute.findmeclinic.recordservice.model;

import java.time.LocalDateTime;

public class Slot {

	private LocalDateTime startDate;
	private long time;
	public Slot() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Slot(LocalDateTime startDate, long time) {
		super();
		this.startDate = startDate;
		this.time = time;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Slot [startDate=" + startDate + ", time=" + time + "]";
	}
	
	

	
}
