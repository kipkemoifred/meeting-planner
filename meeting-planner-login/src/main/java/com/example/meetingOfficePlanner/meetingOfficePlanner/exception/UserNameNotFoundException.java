package com.example.meetingOfficePlanner.meetingOfficePlanner.exception;


public class UserNameNotFoundException extends Exception {
    private String userName;
    public UserNameNotFoundException(String userName){
        super(String.format("userName not found "+userName));
    }
}

