package com.rostermaker.demo.models.instrument;

import com.rostermaker.demo.repos.InstrumentRepo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Orch {

    InstrumentRepo ir;

    private final List<Instrument> fluteDbs = new ArrayList<>();


    private final List<Instrument> oboeDbs = new ArrayList<>();
    private final List<Instrument> clarinetDbs = new ArrayList<>();
    private final List<Instrument> bassoonDbs = new ArrayList<>();
    private final List<Instrument> hornDbs = new ArrayList<>();
    private final List<Instrument> trumpetDbs = new ArrayList<>();
    private final List<Instrument> tromboneDbs = new ArrayList<>();
    private final List<Instrument> tubaDbs = new ArrayList<>();

    public Instrument name(String name) {
        return ir.findByName(name);
    }

    public void addAll(List<Instrument> list, String... names) {
        for (String n : names) {
            list.add(name(n));
        }
    }

    public Orch(InstrumentRepo ir) {
        this.ir = ir;

        addAll(fluteDbs, "PICCOLO", "ALTO FLUTE", "BASS FLUTE", "FLUTE D'AMORE");
        addAll(oboeDbs, "ENGLISH HORN", "OBOE D'AMORE", "BASS OBOE");
        addAll(clarinetDbs, "BASS CLARINET", "SAX");
        addAll(bassoonDbs, "CONTRA");
        addAll(hornDbs, "WAGNER TUBA");
        addAll(trumpetDbs, "CORNET", "FLUGELHORN", "PICC TRUMPET");
        addAll(tromboneDbs, "BASS TROMBONE");
        addAll(tubaDbs, "EUPHONIUM");

    }

    public List<Instrument> getFluteDbs() {
        return fluteDbs;
    }

    public List<Instrument> getOboeDbs() {
        return oboeDbs;
    }

    public List<Instrument> getClarinetDbs() {
        return clarinetDbs;
    }

    public List<Instrument> getBassoonDbs() {
        return bassoonDbs;
    }

    public List<Instrument> getHornDbs() {
        return hornDbs;
    }

    public List<Instrument> getTrumpetDbs() {
        return trumpetDbs;
    }

    public List<Instrument> getTromboneDbs() {
        return tromboneDbs;
    }

    public List<Instrument> getTubaDbs() {
        return tubaDbs;
    }
}
