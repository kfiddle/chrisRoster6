package com.rostermaker.demo.models.part;


import com.rostermaker.demo.models.instrument.Instrument;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Part implements Comparable<Part> {

    @ManyToOne
    private Instrument instrument;

    private int rank;

    private String specialDesignate;

    public Part() {
    }

    public Part(Instrument inst) {
        this.instrument = inst;
    }

    public Part(Instrument instrument, int rank) {
        this.instrument = instrument;
        this.rank = rank;
    }

    public Part(Instrument instrument, int rank, String specialDesignate) {
        this.instrument = instrument;
        this.rank = rank;
        this.specialDesignate = specialDesignate;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSpecialDesignate(String specialDesignate) {
        this.specialDesignate = specialDesignate;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public int getRank() {
        return rank;
    }

    public String getSpecialDesignate() {
        return specialDesignate;
    }

    public boolean isPrincipalHorn() {
        return instrument.getName().equals("HORN") && rank == 1;
    }

    public boolean hasAssDesignate() {
        return specialDesignate != null;
    }

    @Override
    public int compareTo(Part next) {
        if (instrument.compareTo(next.getInstrument()) != 0) {
            return instrument.compareTo(next.getInstrument());
        } else return Integer.compare(rank, next.getRank());
    }


    public boolean equals(Part next) {
        if (specialDesignate != null && next.getSpecialDesignate() != null) {
            return this.instrument.equals(next.getInstrument()) && this.getSpecialDesignate().equals(next
                    .getSpecialDesignate());
        } else if (specialDesignate != null || next.getSpecialDesignate() != null) {
            return false;
        }
        return this.instrument.equals(next.getInstrument()) && rank == next.getRank();

    }


}

