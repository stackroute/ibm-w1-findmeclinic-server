package com.stackroute.findmeclinic.CalendarService.exception;

public class ScheduleDoesNotExistException extends Exception {
    private static final long serialVersionUID = 1L;

    public ScheduleDoesNotExistException(String message){
        super(message);
    }
}
