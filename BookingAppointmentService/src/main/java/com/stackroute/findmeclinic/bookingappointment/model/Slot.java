package com.stackroute.findmeclinic.bookingappointment.model;

import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime startDate;
    private long time;
    private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}