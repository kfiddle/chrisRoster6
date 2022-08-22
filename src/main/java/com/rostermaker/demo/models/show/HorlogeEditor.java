package com.rostermaker.demo.models.show;

import com.rostermaker.demo.enums.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class HorlogeEditor {

    Horloge storedHorloge;

    public HorlogeEditor(Horloge storedHorloge) {
        this.storedHorloge = storedHorloge;
    }

    public void editFrom(Horloge incoming) {
        Optional<Event> eventOpt = Optional.ofNullable(incoming.getEvent());
        Optional<LocalDate> dateOpt = Optional.ofNullable(incoming.getDate());
        Optional<LocalTime> startTimeOpt = Optional.ofNullable(incoming.getStartTime());
        Optional<LocalTime> endTimeOpt = Optional.ofNullable(incoming.getEndTime());

        eventOpt.ifPresent(gotten -> storedHorloge.setEvent(gotten));
        dateOpt.ifPresent(gotten -> storedHorloge.setDate(gotten));
        startTimeOpt.ifPresent(gotten -> storedHorloge.setStartTime(gotten));
        endTimeOpt.ifPresent(gotten -> storedHorloge.setEndTime(gotten));
    }
}
