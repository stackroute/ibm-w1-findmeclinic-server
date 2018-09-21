package com.stackroute.findmeclinic.CalendarService.repository;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
<<<<<<< HEAD
        List<Schedule> getAllByCreatedBy(String createdBy);
        
=======
        List<Schedule> getAllcheduleByCreatedBy(String createdBy);
>>>>>>> 53563c7fec2fc9bd26030f0c1806808825f1bdff
}
