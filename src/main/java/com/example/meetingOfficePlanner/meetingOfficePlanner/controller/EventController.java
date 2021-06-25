package com.example.meetingOfficePlanner.meetingOfficePlanner.controller;
import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Event;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.EventNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.EventRepository;
import com.example.meetingOfficePlanner.meetingOfficePlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    @PostMapping(value="/createevent")
    Event addNewEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping(value = "/event/{eventId}")
    public Event getSpecificEvent(@PathVariable("eventId") int eventId) throws EventNotFoundException {
        return eventService.getEvent(eventId);

    }

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventService.getEvents();
    }
    @PutMapping(value = "/event/{eventId}")
    public Event updateEvent(@RequestBody Event event) throws EventNotFoundException {
        return eventService.updateEvent(event.getEventId(), event);
    }
    @DeleteMapping("/deleteevent/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable(value = "eventId") int eventId) throws EventNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        eventRepository.delete(event);

        return ResponseEntity.ok().build();
    }
}

