package com.example.meetingOfficePlanner.meetingOfficePlanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Email {
    @Id
    @GeneratedValue
    private int emailId ;
    private String email;
    Email(){}

    public Email(String email) {
        this.email = email;
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", email='" + email + '\'' +
                '}';
    }
}
