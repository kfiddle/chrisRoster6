package com.rostermaker.demo.repos;

import com.rostermaker.demo.models.instrument.Instrument;
import org.springframework.data.repository.CrudRepository;

import java.util.Locale;

public interface InstrumentRepo extends CrudRepository<Instrument, Long> {


    boolean existsByName(String name);

    boolean existsByAbbreviation(String abbreviation);

    Instrument findByAbbreviation(String abbreviation);

    Instrument findByName(String name);
}
