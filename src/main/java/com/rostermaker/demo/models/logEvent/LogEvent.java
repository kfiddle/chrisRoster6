package com.rostermaker.demo.models.logEvent;

import com.rostermaker.demo.models.gigOffer.GigOffer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class LogEvent {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private GigOffer gigOffer;

    public LogEvent() {
    }

    public LogEvent(GigOffer gigOffer, LocalDate date) {
        this.gigOffer = gigOffer;
        this.date = date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public GigOffer getGigOffer() {
        return gigOffer;
    }


}
