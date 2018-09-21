package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.model.Slot;
import com.stackroute.findmeclinic.CalendarService.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
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


    public List<Slot> addSlots(LocalTime startTime, LocalTime endTime, long timePerPatient) {
        long timePeriod = Duration.between(startTime, endTime).toMinutes();
        long timeInPatient = timePerPatient;
        long slotCount = timePeriod / timeInPatient;
        slots = new ArrayList<>();
        long i = 0;
        while (i != slotCount) {

            Slot slot = new Slot();
            slot.setSlotId(i+1);
            slot.setSlotStart(startTime);
            slot.setTimePerPatient(timePerPatient);
            slot.setStatus("unblocked");
            slots.add(slot);
            startTime = startTime.plusMinutes(timeInPatient);
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
        schedule.setSlots(addSlots(schedule.getStartTime(), schedule.getEndTime(), schedule.getTimePerPatient()));
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
        List<Schedule> schedules= scheduleRepository.getAllcheduleByCreatedBy(createdBy);
        return schedules;
    }


    @Override
    public List<Schedule> getAllSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules;
    }


}

