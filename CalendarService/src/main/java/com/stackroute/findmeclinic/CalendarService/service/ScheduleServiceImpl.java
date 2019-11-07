package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.exception.ScheduleAlreadyExistsException;
import com.stackroute.findmeclinic.CalendarService.exception.ScheduleDoesNotExistException;
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
            slot.setSlotId(i + 1);
            slot.setSlotStart(startTime);
            slot.setTimePerPatient(timePerPatient);
            slot.setStatus("unblocked");
            if(slot.getSlotStart().isAfter(LocalTime.of(07,00,00)) && slot.getSlotStart().isBefore(LocalTime.of(12,01, 00))){
                slot.setTiming("morning");
            }else if(slot.getSlotStart().isAfter(LocalTime.of(12,00,00)) && slot.getSlotStart().isBefore(LocalTime.of(16,59,00))){
                slot.setTiming("afternoon");
            }else{
                slot.setTiming("evening");
            }
            slots.add(slot);
            startTime = startTime.plusMinutes(timeInPatient);
            i++;
        }
        return slots;
    }


    /*
     *Method to create a Schedule
     */
    Schedule scheduleNew;
    List<Schedule> existingSchedules;
    @Override
    public Schedule createSchedule(Schedule schedule) throws ScheduleAlreadyExistsException {
        schedule.setSlots(addSlots(schedule.getStartTime(), schedule.getEndTime(), schedule.getTimePerPatient()));
        schedule.setScheduleCreationDate(new Date());
        try{
            existingSchedules = getAllScheduleCreatedBy(schedule.getCreatedBy());
            if(existingSchedules.size()==0){
                scheduleNew = scheduleRepository.insert(schedule);
            }else{
                for (Schedule existingSchedule : existingSchedules) {
                    if(existingSchedule.getScheduleDate().equals(schedule.getScheduleDate()) && existingSchedule.getStartTime().equals(schedule.getStartTime()) && existingSchedule.getEndTime().equals(schedule.getEndTime())){
                        throw new ScheduleAlreadyExistsException("Schedule Already Exists with same time");
                    }else if((existingSchedule.getScheduleDate().equals(schedule.getScheduleDate())) && ((schedule.getStartTime().isAfter(existingSchedule.getStartTime()) && schedule.getStartTime().isBefore(existingSchedule.getEndTime())) || (schedule.getEndTime().isAfter(existingSchedule.getStartTime()) && schedule.getEndTime().isBefore(existingSchedule.getEndTime())) || schedule.getEndTime().equals(existingSchedule.getEndTime()) || schedule.getStartTime().equals(existingSchedule.getStartTime()))){
                        throw new ScheduleAlreadyExistsException("A Schedule Already Exists between time frames");
                    }
                    else{
                        scheduleNew=scheduleRepository.insert(schedule);
                    }
                }
            }
        }catch (ScheduleDoesNotExistException e) {
            e.getMessage();
        }
        return scheduleNew;
    }
    /*
     *Method to delete a Schedule
     */
    @Override
    public boolean deleteSchedule(String scheduleId) throws ScheduleDoesNotExistException {
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
            throw new ScheduleDoesNotExistException("Schedule soes not exist");
        }

        return flag;
    }

    @Override
    public List<Schedule> getAllScheduleCreatedBy(String createdBy) throws ScheduleDoesNotExistException {
        List<Schedule> schedules = scheduleRepository.getAllcheduleByCreatedBy(createdBy);
        if (schedules == null) {
            throw new ScheduleDoesNotExistException("No Schedules available for the Doctor");
        } else {
            return schedules;
        }
    }


    @Override
    public List<Schedule> getAllSchedule() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules;
    }


    @Override
    public List<Slot> getAllSlotsCreatedBy(String createdBy) {

        List<Schedule> schedules = scheduleRepository.getAllcheduleByCreatedBy(createdBy);
        List<Slot> allSlots = new ArrayList<Slot>();

        for (int i = 0; i < schedules.size(); i++) {

            Schedule schedule = schedules.get(i);

            List<Slot> slots = schedule.getSlots();

            for (int j = 0; j < slots.size(); j++) {

                allSlots.add(slots.get(j));
            }
        }
        return allSlots;
    }

}