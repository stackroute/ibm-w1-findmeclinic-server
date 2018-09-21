package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;

import java.util.List;

public interface ScheduleService {
   Schedule createSchedule(Schedule schedule);
    boolean deleteSchedule(String scheduleId);
    List<Schedule> getAllScheduleCreatedBy(String createdBy);
    List<Schedule> getAllSchedule();
}
