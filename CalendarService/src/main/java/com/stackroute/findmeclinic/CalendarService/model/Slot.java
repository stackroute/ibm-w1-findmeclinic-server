package com.stackroute.findmeclinic.CalendarService.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Slot {
    private LocalDateTime startDate;
    private Duration time;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Duration getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startDate=" + startDate +
                ", time=" + time +
                '}';
    }

    public void setTime(Duration time) {
        this.time = time;
    }
}
