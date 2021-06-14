package com.example.meetingOfficePlanner.meetingOfficePlanner.service;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.Event;
import com.example.meetingOfficePlanner.meetingOfficePlanner.exception.EventNotFoundException;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public EventService() {
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();

    }
    public Event getEvent(int eventId) throws EventNotFoundException {
        return eventRepository.findById(eventId).orElseThrow(()->new EventNotFoundException(eventId));

    }
    public Event addEvent(Event event){
        return eventRepository.save(event);
    }
    public Event updateEvent(int eventId,Event eventDetails) throws EventNotFoundException {
        Event event=eventRepository.findById(eventId).orElseThrow(()-> new EventNotFoundException(eventId));
        event.setCapacity(eventDetails.getCapacity());
        event.setEventId(eventDetails.getEventId());
        event.setDescription(eventDetails.getDescription());
        event.setRepetitive(eventDetails.getRepetitive());
        event.setTopic(eventDetails.getTopic());
        event.setMeetingEndDate(eventDetails.getMeetingEndDate());
        event.setMeetingStartDate(eventDetails.getMeetingStartDate());
        Event updatedEvent=eventRepository.save(event);
        return updatedEvent;
    }
}
