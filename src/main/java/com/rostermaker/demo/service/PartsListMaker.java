package com.rostermaker.demo.service;


import com.rostermaker.demo.models.instrument.Instrument;
import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartsListMaker {


    private final InstrumentRepo instrumentRepo;

    @Autowired
    public PartsListMaker(final InstrumentRepo instrumentRepo) {
        this.instrumentRepo = instrumentRepo;
    }

    public List<Part> makeList(List<Part> incomingParts) {
        List<Part> partsToSet = new ArrayList<>();

        for (Part part : incomingParts) {
//            Instrument inst;
//            if (part.getInstrument().getName() != null) {
//                inst = instrumentRepo.findByName(part.getInstrument().getName());
//            } else {
//                inst = instrumentRepo.findByAbbreviation(part.getInstrument().getAbbreviation());
//            }
            Instrument inst = instrumentRepo.findById(part.getInstrument().getId()).get();

            Part partToAdd = new Part(inst);
            if (part.getRank() > 0) {
                partToAdd.setRank(part.getRank());
            } else if (part.getSpecialDesignate() != null) {
                partToAdd.setSpecialDesignate(part.getSpecialDesignate());
            }

            partsToSet.add(partToAdd);
        }
        return partsToSet;
    }
}
