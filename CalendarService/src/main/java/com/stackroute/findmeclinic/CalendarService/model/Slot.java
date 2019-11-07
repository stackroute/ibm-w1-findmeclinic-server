package com.stackroute.findmeclinic.CalendarService.model;
import java.time.LocalTime;

public class Slot {
    public Slot() {
    }

    private long slotId;
    private LocalTime slotStart;
    private long timePerPatient;
    private String status;
    private String timing;

    public Slot(long slotId, LocalTime slotStart, long timePerPatient, String status,String timing) {
        this.slotId = slotId;
        this.slotStart = slotStart;
        this.timePerPatient = timePerPatient;
        this.status = status;
        this.timing =timing;
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


	public String getTiming() {
		return timing;
	}


	public void setTiming(String timing) {
		this.timing = timing;
	}
    
}

