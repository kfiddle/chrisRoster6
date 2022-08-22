package com.rostermaker.demo.legos.playerInChair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HornPICSorter {

    Collection<PIC> picsToSort;

    public HornPICSorter(Collection<PIC> picsToSort) {
        this.picsToSort = picsToSort;
    }

    public List<PIC> sort() {
        ArrayList<PIC> pics = new ArrayList<PIC>(picsToSort);

        int assistantIndex = 0;
        int principalIndex = 0;
        boolean assistantExists = false;
        for (PIC pic : pics) {
            if (pic.getPrimaryPart().isPrincipalHorn()) {
                principalIndex = pics.indexOf(pic);
            }
            if (pic.getPrimaryPart().hasAssDesignate()) {
                assistantIndex = pics.indexOf(pic);
                assistantExists = true;
            }
        }

        if (assistantExists) {
            Collections.swap(pics, principalIndex, assistantIndex);
        }
        return pics;
    }


}
