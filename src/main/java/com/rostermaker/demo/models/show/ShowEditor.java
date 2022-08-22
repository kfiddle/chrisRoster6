package com.rostermaker.demo.models.show;

import java.util.Optional;

public class ShowEditor {

    Show storedShow;

    public ShowEditor(Show storedShow) {
        this.storedShow = storedShow;
    }

    public void editFrom(Show incoming) {
        Optional<String> titleOpt = Optional.ofNullable(incoming.getTitle());
        int services = incoming.getNumberOfServices();
        Optional<String> notesOpt = Optional.ofNullable(incoming.getNotes());

        titleOpt.ifPresent(gotten -> storedShow.setTitle(gotten));
        if (services > 0) {
            storedShow.setNumberOfServices(services);
        }
        notesOpt.ifPresent(gotten -> storedShow.setNotes(gotten));
    }
}
