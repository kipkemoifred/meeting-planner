package com.example.meetingOfficePlanner.meetingOfficePlanner.model;

public class Password {
    private String passwordName;
    private String token;

    @Override
    public String toString() {
        return "Password{" +
                "passwordName='" + passwordName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Password(String passwordName, String token) {
        this.passwordName = passwordName;
        this.token = token;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

}
