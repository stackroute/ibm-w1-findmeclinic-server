package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.model.Slot;
import com.stackroute.findmeclinic.CalendarService.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /*
     *Method to add to slot
     */
    List<Slot> slots;


    public List<Slot> addSlots(LocalDateTime startDate, LocalDateTime endDate, Duration time_per_patient) {
        long timePeriod = Duration.between(startDate, endDate).toMinutes();
        long timeInPatient = time_per_patient.toMinutes();
        long slotCount = timePeriod / timeInPatient;
        slots = new ArrayList<>();
        long i = 0;
        while (i != slotCount) {
            Slot slot = new Slot();
            slot.setStartDate(startDate);
            slot.setTime(time_per_patient);
            slots.add(slot);
            startDate = startDate.plusMinutes(timeInPatient);
            i++;
        }
        return slots;
    }


    /*
     *Method to create a Schedule
     */
    @Override
    public Schedule createSchedule(Schedule schedule) {
        schedule.setScheduleCreationDate(new Date());
        schedule.setStatus("unblocked");
        schedule.setSlots(addSlots(schedule.getStartDate(), schedule.getEndDate(), schedule.getTime_per_patient()));
        Schedule scheduleNew = scheduleRepository.insert(schedule);
        return scheduleNew;
    }

    /*
     *Method to delete a Schedule
     */
    @Override
    public boolean deleteSchedule(String scheduleId) {
        boolean flag = false;
        try {
            Schedule schedule = scheduleRepository.findById(scheduleId).get();
            if (schedule == null) {
                flag = false;
            } else {
                scheduleRepository.delete(schedule);
                flag = true;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public List<Schedule> getAllScheduleCreatedBy(String createdBy) {
        List<Schedule> schedules = scheduleRepository.getAllByCreatedBy(createdBy);
        return schedules;
    }


}
