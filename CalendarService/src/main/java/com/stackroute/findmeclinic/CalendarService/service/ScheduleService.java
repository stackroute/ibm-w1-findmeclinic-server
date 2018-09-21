package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);
    boolean deleteSchedule(String scheduleId);
    List<Schedule> getAllScheduleCreatedBy(String createdBy);
    
    public void post(Schedule schedule) ;
    
    public void listen(@Payload Schedule schedule);
}
