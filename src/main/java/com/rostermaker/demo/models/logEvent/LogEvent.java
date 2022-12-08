package com.rostermaker.demo.models.logEvent;

import com.rostermaker.demo.enums.LogType;
import com.rostermaker.demo.models.gigOffer.GigOffer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class LogEvent {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @Enumerated
    private LogType logType;

    @ManyToOne
    private GigOffer gigOffer;

    public LogEvent() {
    }

    public LogEvent(GigOffer gigOffer, LogType logType, LocalDate date) {
        this.gigOffer = gigOffer;
        this.logType = logType;
        this.date = date;
    }

    public LogEvent(LogType logType, LocalDate date) {
        this.logType = logType;
        this.date = date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public void setGigOffer(GigOffer gigOffer) {
        this.gigOffer = gigOffer;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LogType getLogType() {
        return logType;
    }

    public GigOffer getGigOffer() {
        return gigOffer;
    }


}
