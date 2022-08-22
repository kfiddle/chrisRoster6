package com.rostermaker.demo.models.show;

import java.util.Optional;

public class ShowBuilder {

    public String title;

    public int numberOfServices;

    public String notes;

    public ShowBuilder() {
    }

    public ShowBuilder title(String title) {
        Optional<String> titleCheck = Optional.ofNullable(title);
        titleCheck.ifPresent(gottenTitle -> this.title = gottenTitle);
        return this;
    }

    public ShowBuilder numberOfServices(int numberOfServices) {
        if (numberOfServices > 0) {
            this.numberOfServices = numberOfServices;
        }
        return this;
    }

    public ShowBuilder notes(String notes) {
        Optional<String> notesOpt = Optional.ofNullable(notes);
        notesOpt.ifPresent(gotten -> this.notes = gotten);
        return this;
    }


    public Show build() {
        return new Show(this);
    }
}
