package com.example.meetingOfficePlanner.meetingOfficePlanner.config;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private User user;
    private String userName;
    private String password;
    private String roles;
    private boolean active;
    private Date LockedUntil;
    private int NumFailedLogins;//max 4 30 mins
    private int timesUsedSamePassword;//4 change psd
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.user = user;
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.roles = user.getRoles();
        this.LockedUntil = user.getLockedUntil();
        this.NumFailedLogins = user.getNumFailedLogins();
        this.timesUsedSamePassword = user.getTimesUsedSamePassword();

        this.authorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList())
        ;
    }

    MyUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();//4 failed,locked for 30 mins for incorrect credentials
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//expires in 4 days
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public User getUser() {
        return this.user;
    }
}
