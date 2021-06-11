package com.example.meetingOfficePlanner.meetingOfficePlanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue
    int userId;
    private String userName;


    private String password;
    private String roles;
    private boolean active;
    private int NumFailedLogins;//max 4 30 mins
    private int timesUsedSamePassword;//4 change psd
    private boolean accountNonLocked;
    private Date lockTime;
    private Date LockedUntil;
    private String StakeholderPosition;
    private String email;
    private String phoneNumber;
    private String resetPasswordToken;
    public User(String userName,String resetPasswordToken, String password, String roles, boolean active, int numFailedLogins, int timesUsedSamePassword, boolean accountNonLocked, Date lockTime, Date lockedUntil, String stakeholderPosition, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
        this.NumFailedLogins = numFailedLogins;
        this.timesUsedSamePassword = timesUsedSamePassword;
        this.accountNonLocked = accountNonLocked;
        this.lockTime = lockTime;
        this.LockedUntil = lockedUntil;
        this.StakeholderPosition = stakeholderPosition;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.resetPasswordToken=resetPasswordToken;
    }



    public void setTimesUsedSamePassword(int timesUsedSamePassword) {
        this.timesUsedSamePassword = timesUsedSamePassword;
    }

    public Date getLockedUntil() {
        return LockedUntil;
    }

    public void setLockedUntil(Date lockedUntil) {
        LockedUntil = lockedUntil;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumFailedLogins() {
        return NumFailedLogins;
    }

    public void setNumFailedLogins(int numFailedLogins) {
        NumFailedLogins = numFailedLogins;
    }

    public int getTimesUsedSamePassword() {
        return timesUsedSamePassword;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public String getRoles() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(){
        super();
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

    public String getStakeholderPosition() {
        return StakeholderPosition;
    }

    public void setStakeholderPosition(String stakeholderPosition) {
        StakeholderPosition = stakeholderPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                ", NumFailedLogins=" + NumFailedLogins +
                ", timesUsedSamePassword=" + timesUsedSamePassword +
                ", LockedUntil=" + LockedUntil +
                ", StakeholderPosition='" + StakeholderPosition + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
