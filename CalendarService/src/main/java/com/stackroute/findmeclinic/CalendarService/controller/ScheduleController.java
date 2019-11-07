package com.stackroute.findmeclinic.CalendarService.controller;

import com.stackroute.findmeclinic.CalendarService.exception.ScheduleAlreadyExistsException;
import com.stackroute.findmeclinic.CalendarService.exception.ScheduleDoesNotExistException;
import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.model.Slot;
import com.stackroute.findmeclinic.CalendarService.service.ScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/calendar")
@Api(value="Calendar Resource")
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping("/add")
    @ApiOperation("Scheduling  for particular slot")
    ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {
        ResponseEntity<?> responseEntity = null;
        Schedule newSchedule;
        try {
            newSchedule = scheduleService.createSchedule(schedule);
            if (newSchedule != null) {
                responseEntity = new ResponseEntity<>(newSchedule, HttpStatus.CREATED);
            }else {
                responseEntity = new ResponseEntity<>("Empty", HttpStatus.CONFLICT);
            }
        } catch (ScheduleAlreadyExistsException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @DeleteMapping("/delete/{scheduleId}")
    @ApiOperation("To delete the  particular slot")
    ResponseEntity<?> deleteSchedule(@PathVariable String scheduleId) {
        ResponseEntity<?> responseEntity = null;
        try {
            if (scheduleService.deleteSchedule(scheduleId)) {
                responseEntity = new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
            }
        } catch (ScheduleDoesNotExistException e) {
            responseEntity = new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/get")
    @ApiOperation("To Get the schedule")
    ResponseEntity<?> getSchedule() {
        ResponseEntity<?> responseEntity = null;
        List<Schedule> schedules = scheduleService.getAllSchedule();
        responseEntity = new ResponseEntity<>(schedules, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/get/{docId}")
    @ApiOperation("To get paticular schedule of a doctor")
    ResponseEntity<?> getScheduleByDoc(@PathVariable String docId) {
        ResponseEntity<?> responseEntity = null;
        List<Schedule> schedulesDoc;
		try {
			schedulesDoc = scheduleService.getAllScheduleCreatedBy(docId);
			if(schedulesDoc!=null) {
	            responseEntity = new ResponseEntity<>(schedulesDoc, HttpStatus.OK);
	        }else{
	            responseEntity= new ResponseEntity<>("Doctor Not Found", HttpStatus.NOT_FOUND);
	        }
		} catch (ScheduleDoesNotExistException e) {
			  responseEntity= new ResponseEntity<>("Doctor Not Found", HttpStatus.NOT_FOUND);
		}

        return responseEntity;
    }

    @GetMapping("/getSlots/{docId}")
    @ApiOperation("To get the slots by the doctor name")
    ResponseEntity<?> getSlotsByDoc(@PathVariable String docId){
        ResponseEntity<?> responseEntity = null;
        List<Slot> schedulesDoc = scheduleService.getAllSlotsCreatedBy(docId);
        responseEntity = new ResponseEntity<>(schedulesDoc, HttpStatus.OK);
        return responseEntity;
    }


}

