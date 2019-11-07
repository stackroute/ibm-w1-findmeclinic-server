package com.stackroute.findmeclinic.bookingappointment.model;

import java.time.LocalTime;

public class Slot {
	public Slot() {
    }

    private long slotId;
    private LocalTime slotStart;
    private long timePerPatient;
    private String status;

    public Slot(long slotId, LocalTime slotStart, long timePerPatient, String status) {
        this.slotId = slotId;
        this.slotStart = slotStart;
        this.timePerPatient = timePerPatient;
        this.status = status;
    }


    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public LocalTime getSlotStart() {
        return slotStart;
    }

    public void setSlotStart(LocalTime slotStart) {
        this.slotStart = slotStart;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimePerPatient() {
        return timePerPatient;
    }

    public void setTimePerPatient(long timePerPatient) {
        this.timePerPatient = timePerPatient;
    }


	@Override
	public String toString() {
		return "Slot [slotId=" + slotId + ", slotStart=" + slotStart + ", timePerPatient=" + timePerPatient
				+ ", status=" + status + "]";
	}
    
    
    
}

