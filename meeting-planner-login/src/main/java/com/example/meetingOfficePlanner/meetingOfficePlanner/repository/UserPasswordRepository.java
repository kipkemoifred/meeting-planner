package com.example.meetingOfficePlanner.meetingOfficePlanner.repository;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPasswordRepository extends JpaRepository<UserPassword,Integer> {
}
