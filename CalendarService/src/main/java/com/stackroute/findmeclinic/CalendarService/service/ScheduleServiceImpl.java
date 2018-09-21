package com.stackroute.findmeclinic.CalendarService.service;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.model.Slot;
import com.stackroute.findmeclinic.CalendarService.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	private KafkaTemplate<String, Schedule> kafkaTemplate;
    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    
    @Override
	public void post(Schedule schedule) {

		kafkaTemplate.send("notificationTopic", schedule);
	
	}
	
	@Override
	@KafkaListener(topics="calenderTopic")
	public void listen(@Payload Schedule schedule) {
		System.out.println("Schedule object:"+ schedule);
		
		
		
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


	@Override
	public List<Slot> getAllSlotsCreatedBy(String createdBy) {
		
		List<Schedule> schedules= scheduleRepository.getAllcheduleByCreatedBy(createdBy);
		List<Slot> allSlots = new ArrayList<Slot>();
		
		for(int i=0;i< schedules.size();i++) {
			
			Schedule schedule=schedules.get(i);
			
			List<Slot> slots=schedule.getSlots();
			
			for(int j=0;j< slots.size(); j++) {
				
				allSlots.add(slots.get(j));
			}
		}
		return allSlots;
	}


}

