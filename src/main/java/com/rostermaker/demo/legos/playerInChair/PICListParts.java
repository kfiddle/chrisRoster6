package com.rostermaker.demo.legos.playerInChair;

import com.rostermaker.demo.models.part.Part;

import java.util.Collection;
import java.util.List;

public class PICListParts {

    Collection<PIC> picsToCheck;

    public PICListParts(Collection<PIC> picsToCheck) {
        this.picsToCheck = picsToCheck;
    }


    public boolean containsParts(PIC pic) {
        for (PIC listedPic : picsToCheck) {
            if (listedPic.getParts().size() != pic.getParts().size()) {
                return false;
            }
            if (!listedPic.partsEquals(pic)) {
                return false;
            }
        }
        return true;
    }
}
