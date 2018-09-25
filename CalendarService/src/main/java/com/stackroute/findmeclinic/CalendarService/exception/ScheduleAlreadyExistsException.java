package com.stackroute.findmeclinic.CalendarService.exception;

public class ScheduleAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;

    public ScheduleAlreadyExistsException(String message){
        super(message);
    }
}
