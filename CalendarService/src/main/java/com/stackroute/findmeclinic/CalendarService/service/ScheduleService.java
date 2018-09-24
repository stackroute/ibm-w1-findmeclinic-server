package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.exception.ScheduleDoesNotExistException;
import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.model.Slot;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;

public interface ScheduleService {
   Schedule createSchedule(Schedule schedule);
    boolean deleteSchedule(String scheduleId) throws ScheduleDoesNotExistException;
    List<Schedule> getAllScheduleCreatedBy(String createdBy) throws ScheduleDoesNotExistException;

    
    public void post(Schedule schedule) ;
    
    public void listen(@Payload Schedule schedule);

    List<Schedule> getAllSchedule();
    
    List<Slot> getAllSlotsCreatedBy(String createdBy) ;
}
