package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;

public interface ScheduleService {
   Schedule createSchedule(Schedule schedule);
    boolean deleteSchedule(String scheduleId);
    List<Schedule> getAllScheduleCreatedBy(String createdBy);
<<<<<<< HEAD
    
    public void post(Schedule schedule) ;
    
    public void listen(@Payload Schedule schedule);
=======
    List<Schedule> getAllSchedule();
>>>>>>> 53563c7fec2fc9bd26030f0c1806808825f1bdff
}
