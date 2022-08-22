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
        this.name = name.toUpperCase();
        this.scoreOrder = scoreOrder;
    }

    public Instrument(String name, String abbreviation, int scoreOrder) {
        this.name = name.toUpperCase();
        this.abbreviation = abbreviation.toUpperCase();
        this.scoreOrder = scoreOrder;
    }

    public Instrument(String name, String abbreviation) {
        this.name = name.toUpperCase();
        this.abbreviation = abbreviation.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setScoreOrder(int scoreOrder) {
        this.scoreOrder = scoreOrder;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation.toUpperCase();

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
        if (scoreOrder > 0) {
            return Integer.compare(this.scoreOrder, next.getScoreOrder());
        } else {
            return 1;
        }
    }

}
