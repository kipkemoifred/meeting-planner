package com.example.meetingOfficePlanner.meetingOfficePlanner.exception;

public class EventNotFoundException extends Exception{
    private int eventId;
    public EventNotFoundException(int eventId){
        super(String.format("event not found with id '%s'",eventId));}
}
