package com.example.meetingOfficePlanner.meetingOfficePlanner.model;

public class Password {
    private String passwordName;
    private String token;
    private String email;



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Password{" +
                "passwordName='" + passwordName + '\'' +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
