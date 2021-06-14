package com.example.meetingOfficePlanner.meetingOfficePlanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;
@Entity
public class Event {
    @Id
    @GeneratedValue
    int eventId;
    Date MeetingStartDate;
    Date MeetingEndDate;
    int capacity;
    boolean repetitive;// true--specific dates
    //repetitive array
    //@NotBlank
    String topic;//Mandatory
    String description;//optional
    LocalTime meetingTime;
    Event(){}
    public Event(Date meetingStartDate, Date meetingEndDate,LocalTime meetingTime, int capacity, boolean repetitive, String topic, String description) {
        MeetingStartDate = meetingStartDate;
        MeetingEndDate = meetingEndDate;
        this.capacity = capacity;
        this.repetitive = repetitive;
        this.topic = topic;
        this.description = description;
        this.meetingTime=meetingTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Date getMeetingStartDate() {
        return MeetingStartDate;
    }

    public void setMeetingStartDate(Date meetingStartDate) {
        MeetingStartDate = meetingStartDate;
    }

    public Date getMeetingEndDate() {
        return MeetingEndDate;
    }

    public void setMeetingEndDate(Date meetingEndDate) {
        MeetingEndDate = meetingEndDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isRepetitive() {
        return repetitive;
    }

    public void setRepetitive(boolean repetitive) {
        this.repetitive = repetitive;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(LocalTime meetingTime) {
        this.meetingTime = meetingTime;
    }
    public boolean getRepetitive() {
        return repetitive;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", MeetingStartDate=" + MeetingStartDate +
                ", MeetingEndDate=" + MeetingEndDate +
                ", capacity=" + capacity +
                ", repetitive=" + repetitive +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", meetingTime=" + meetingTime +
                '}';
    }


}


