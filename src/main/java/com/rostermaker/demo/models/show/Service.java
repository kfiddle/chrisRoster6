package com.rostermaker.demo.models.show;


import com.rostermaker.demo.enums.Event;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
public class Service {

    Event event;

    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;

    String location;


}
