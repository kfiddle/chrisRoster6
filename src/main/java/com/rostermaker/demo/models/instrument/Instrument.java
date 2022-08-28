package com.rostermaker.demo.models.instrument;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Instrument implements Comparable<Instrument> {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String abbreviation;

    private int scoreOrder;

    public Instrument() {
    }

    public Instrument(String name) {
        this.name = name;
    }

    public Instrument(String name, int scoreOrder) {
        this.name = name;
        this.scoreOrder = scoreOrder;
    }

    public Instrument(String name, String abbreviation, int scoreOrder) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.scoreOrder = scoreOrder;
    }

    public Instrument(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScoreOrder(int scoreOrder) {
        this.scoreOrder = scoreOrder;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getScoreOrder() {
        return scoreOrder;
    }

    @Override
    public int compareTo(Instrument next) {
        if (this.scoreOrder != next.getScoreOrder()) {
            return Integer.compare(this.scoreOrder, next.getScoreOrder());
        } else {
            return 0;
        }
    }

//        new Instrument("VIOLA", 360),
//                new Instrument("PICCOLO", "PIC", 1),
//                new Instrument("BASS", 380),
//                new Instrument("CELLO", 370),
//                new Instrument("KAZU", "KZU"),
//                new Instrument("FLUTE", 10)
}
