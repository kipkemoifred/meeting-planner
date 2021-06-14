package com.example.meetingOfficePlanner.meetingOfficePlanner.model;

public class PasswordSet {
    private String password;
    private String email;

    public PasswordSet(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PasswordSet{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
