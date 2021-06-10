package com.example.meetingOfficePlanner.meetingOfficePlanner.repository;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
