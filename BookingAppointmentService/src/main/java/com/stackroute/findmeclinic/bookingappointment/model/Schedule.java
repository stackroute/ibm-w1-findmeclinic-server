package com.stackroute.findmeclinic.bookingappointment.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Schedule {

	 private String scheduleId;
	    private String description;
	    private String workPlace;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
	    private String createdBy;
	    private Date scheduleCreationDate;
	    private long time_Per_patient;
	    private String status;
	    private List<Slot> slots;

	    public Schedule(String scheduleId, String description, String status, String workPlace, LocalDateTime startDate, LocalDateTime endDate, long time_per_patient, String createdBy, Date scheduleCreationDate) {
	        this.scheduleId = scheduleId;
	        this.description = description;
	        this.status = status;
	        this.workPlace = workPlace;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.time_Per_patient=time_per_patient;
	        this.createdBy=createdBy;
	        this.scheduleCreationDate = scheduleCreationDate;
	    }



	    public Schedule(){}



	    public LocalDateTime getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(LocalDateTime endDate) {
	        this.endDate = endDate;
	    }

	    public LocalDateTime getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(LocalDateTime startDate) {
	        this.startDate = startDate;
	    }

	    public String getWorkPlace() {
	        return workPlace;
	    }

	    public void setWorkPlace(String workPlace) {
	        this.workPlace = workPlace;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getScheduleId() {
	        return scheduleId;
	    }

	    public void setScheduleId(String scheduleId) {
	        this.scheduleId = scheduleId;
	    }




	    public Date getScheduleCreationDate() {
	        return scheduleCreationDate;
	    }

	    public void setScheduleCreationDate(Date scheduleCreationDate) {
	        this.scheduleCreationDate = scheduleCreationDate;
	    }

	    public long getTime_per_patient() {
	        return time_Per_patient;
	    }

	    public void setTime_per_patient(long time_per_patient) {
	        this.time_Per_patient = time_per_patient;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public List<Slot> getSlots() {
	        return slots;
	    }

	    public void setSlots(List<Slot> slots) {
	        this.slots = slots;
	    }

	    public String getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(String createdBy) {
	        this.createdBy = createdBy;
	    }
	}
