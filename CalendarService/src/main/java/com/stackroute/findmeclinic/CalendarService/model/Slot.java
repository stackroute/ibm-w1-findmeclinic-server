package com.stackroute.findmeclinic.CalendarService.model;
import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime startDate;
    private long time;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startDate=" + startDate +
                ", time=" + time +
                '}';
    }

    public void setTime(long time) {
        this.time = time;
    }
}
