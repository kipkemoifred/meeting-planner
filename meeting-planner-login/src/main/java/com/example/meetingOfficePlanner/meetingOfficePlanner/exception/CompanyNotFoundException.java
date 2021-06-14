package com.example.meetingOfficePlanner.meetingOfficePlanner.exception;

public class CompanyNotFoundException extends Exception {
    private int companyId;
    public CompanyNotFoundException(int companyId){
        super(String.format("company not found with id '%s'",companyId));
    }
}
