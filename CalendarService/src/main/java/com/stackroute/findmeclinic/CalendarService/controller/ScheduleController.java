package com.stackroute.findmeclinic.CalendarService.controller;

import com.stackroute.findmeclinic.CalendarService.model.Schedule;
import com.stackroute.findmeclinic.CalendarService.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping("/api/calendar/add")
    ResponseEntity<?> addSchedule(@RequestBody Schedule schedule) {
        ResponseEntity<?> responseEntity=null;
        Schedule newSchedule = scheduleService.createSchedule(schedule);
        if(newSchedule!=null){
            responseEntity= new ResponseEntity<>(newSchedule, HttpStatus.CREATED);
        }
        else{
            responseEntity= new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("/api/calendar/delete/{scheduleId}")
    ResponseEntity<?> deleteSchedule(@PathVariable String scheduleId){
        ResponseEntity<?> responseEntity = null;
        if(scheduleService.deleteSchedule(scheduleId)){
            responseEntity = new ResponseEntity<>("Deleted", HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/api/calendar/get")
    ResponseEntity<?> getSchedule(){
        ResponseEntity<?> responseEntity = null;
        List<Schedule> schedules = scheduleService.getAllSchedule();
        responseEntity=new ResponseEntity<>(schedules, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/api/calendar/get/{docId}")
    ResponseEntity<?> getScheduleByDoc(@PathVariable  String docId){
        ResponseEntity<?> responseEntity = null;
        List<Schedule> schedulesDoc = scheduleService.getAllScheduleCreatedBy(docId);
        responseEntity = new ResponseEntity<>(schedulesDoc, HttpStatus.OK);
        return responseEntity;
    }



}

