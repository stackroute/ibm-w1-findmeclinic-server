package com.stackroute.findmeclinic.recordservice.model;

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
	public Schedule() {
		super();
	}
	public Schedule(String scheduleId, String description, String workPlace, LocalDateTime startDate,
			LocalDateTime endDate, String createdBy, Date scheduleCreationDate, long time_Per_patient, String status,
			List<Slot> slots) {
		super();
		this.scheduleId = scheduleId;
		this.description = description;
		this.workPlace = workPlace;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.scheduleCreationDate = scheduleCreationDate;
		this.time_Per_patient = time_Per_patient;
		this.status = status;
		this.slots = slots;
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
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getScheduleCreationDate() {
		return scheduleCreationDate;
	}
	public void setScheduleCreationDate(Date scheduleCreationDate) {
		this.scheduleCreationDate = scheduleCreationDate;
	}
	public long getTime_Per_patient() {
		return time_Per_patient;
	}
	public void setTime_Per_patient(long time_Per_patient) {
		this.time_Per_patient = time_Per_patient;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Slot> getSlots() {
		return slots;
	}
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", description=" + description + ", workPlace=" + workPlace
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy=" + createdBy
				+ ", scheduleCreationDate=" + scheduleCreationDate + ", time_Per_patient=" + time_Per_patient
				+ ", status=" + status + ", slots=" + slots + "]";
	}
	
	

}
