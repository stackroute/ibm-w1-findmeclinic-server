package com.stackroute.findmeclinic.bookingappointment.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


public class Schedule {

	private String scheduleId;
    private String description;
    private String workPlace;
    private LocalDate scheduleDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private long timePerPatient;
    private String createdBy;
    private Date scheduleCreationDate;
    private List<Slot> slots;

    public Schedule(){}
    public Schedule(String scheduleId, String description, String workPlace, LocalDate scheduleDate, LocalTime startTime, LocalTime endTime, long timePerPatient, String createdBy) {
        this.scheduleId = scheduleId;
        this.description = description;
        this.workPlace = workPlace;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timePerPatient = timePerPatient;
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public long getTimePerPatient() {
        return timePerPatient;
    }

    public void setTimePerPatient(long timePerPatient) {
        this.timePerPatient = timePerPatient;
    }


    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public Date getScheduleCreationDate() {
        return scheduleCreationDate;
    }

    public void setScheduleCreationDate(Date scheduleCreationDate) {
        this.scheduleCreationDate = scheduleCreationDate;
    }
}