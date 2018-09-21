package com.stackroute.findmeclinic.CalendarService.repository;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
        List<Schedule> getAllcheduleByCreatedBy(String createdBy);
}
