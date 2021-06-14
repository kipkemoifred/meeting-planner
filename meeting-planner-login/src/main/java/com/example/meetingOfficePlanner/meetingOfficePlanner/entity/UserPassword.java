package com.example.meetingOfficePlanner.meetingOfficePlanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserPassword {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private String password;

    public UserPassword(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    UserPassword(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "id=" + id +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                '}';
    }
}
