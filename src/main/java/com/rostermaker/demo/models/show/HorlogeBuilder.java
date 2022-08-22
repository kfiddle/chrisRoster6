package com.rostermaker.demo.models.show;

import com.rostermaker.demo.enums.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class HorlogeBuilder {


    public Show show;

    public Event event;

    public LocalDate date;
    public LocalTime startTime;
    public LocalTime endTime;

    public String location;

    public HorlogeBuilder() {
    }

    public HorlogeBuilder show(Show show) {
        Optional<Show> showCheck = Optional.ofNullable(show);
        showCheck.ifPresent(gotten -> this.show = gotten);
        return this;
    }

    public HorlogeBuilder event(Event event) {
        Optional<Event> eventCheck = Optional.ofNullable(event);
        eventCheck.ifPresent(gotten -> this.event = gotten);
        return this;
    }

    public HorlogeBuilder date(LocalDate date) {
        Optional<LocalDate> dateCheck = Optional.ofNullable(date);
        dateCheck.ifPresent(gotten -> this.date = gotten);
        return this;
    }

    public HorlogeBuilder startTime(LocalTime startTime) {
        Optional<LocalTime> startTimeCheck = Optional.ofNullable(startTime);
        startTimeCheck.ifPresent(gotten -> this.startTime = gotten);
        return this;
    }

    public HorlogeBuilder endTime(LocalTime endTime) {
        Optional<LocalTime> endTimeCheck = Optional.ofNullable(endTime);
        endTimeCheck.ifPresent(gotten -> this.endTime = gotten);
        return this;
    }

    public HorlogeBuilder location(String location) {
        Optional<String> locationCheck = Optional.ofNullable(location);
        locationCheck.ifPresent(gotten -> this.location = gotten);
        return this;
    }

    public Horloge build() {
        return new Horloge(this);
    }

}
