package com.rostermaker.demo.models.piece;

import java.time.LocalDate;
import java.util.Optional;

public class PieceBuilder {

    public String prefix;
    public String libNumber;
    public String suffix;
    public String composerLast;

    public String composerFirst;
    public String arranger;
    public String title;
    public String otherName;
    public String publisher;
    public String duration;
    public String windsBrass;
    public String vocalistSoloist;
    public String percBreakdown;
    public String notes;
    public String status;
    public String sign;
    public LocalDate updated;

    public PieceBuilder() {
    }

    public PieceBuilder prefix(String prefix) {
        Optional<String> prefixOpt = Optional.ofNullable(prefix);
        prefixOpt.ifPresent(gotten -> this.prefix = gotten);
        return this;
    }

    public PieceBuilder libNumber(String libNumber) {
        Optional<String> libNumberOpt = Optional.ofNullable(libNumber);
        libNumberOpt.ifPresent(gotten -> this.libNumber = gotten);
        return this;
    }

    public PieceBuilder suffix(String suffix) {
        Optional<String> suffixOpt = Optional.ofNullable(suffix);
        suffixOpt.ifPresent(gotten -> this.suffix = gotten);
        return this;
    }

    public PieceBuilder composerLast(String composerLast) {
        Optional<String> composerLastOpt = Optional.ofNullable(composerLast);
        composerLastOpt.ifPresent(gotten -> this.composerLast = gotten);
        return this;
    }

    public PieceBuilder composerFirst(String composerFirst) {
        Optional<String> composerFirstOpt = Optional.ofNullable(composerFirst);
        composerFirstOpt.ifPresent(gotten -> this.composerFirst = gotten);
        return this;
    }


    public PieceBuilder arranger(String arranger) {
        Optional<String> arrangerOpt = Optional.ofNullable(arranger);
        arrangerOpt.ifPresent(gotten -> this.arranger = gotten);
        return this;
    }

    public PieceBuilder title(String title) {
        Optional<String> titleOpt = Optional.ofNullable(title);
        titleOpt.ifPresent(gotten -> this.title = gotten);
        return this;
    }

    public PieceBuilder otherName(String otherName) {
        Optional<String> otherNameOpt = Optional.ofNullable(otherName);
        otherNameOpt.ifPresent(gotten -> this.otherName = gotten);
        return this;
    }

    public PieceBuilder publisher(String publisher) {
        Optional<String> publisherOpt = Optional.ofNullable(publisher);
        publisherOpt.ifPresent(gotten -> this.publisher = gotten);
        return this;
    }

    public PieceBuilder duration(String duration) {
        Optional<String> durationOpt = Optional.ofNullable(duration);
        durationOpt.ifPresent(gotten -> this.duration = gotten);
        return this;
    }

    public PieceBuilder windsBrass(String windsBrass) {
        Optional<String> windsBrassOpt = Optional.ofNullable(windsBrass);
        windsBrassOpt.ifPresent(gotten -> this.windsBrass = gotten);
        return this;
    }

    public PieceBuilder vocalistSoloist(String vocalistSoloist) {
        Optional<String> vocalistSoloistOpt = Optional.ofNullable(vocalistSoloist);
        vocalistSoloistOpt.ifPresent(gotten -> this.vocalistSoloist = gotten);
        return this;
    }

    public PieceBuilder percBreakdown(String percBreakdown) {
        Optional<String> percBreakdownOpt = Optional.ofNullable(percBreakdown);
        percBreakdownOpt.ifPresent(gotten -> this.percBreakdown = gotten);
        return this;
    }

    public PieceBuilder notes(String notes) {
        Optional<String> notesOpt = Optional.ofNullable(notes);
        notesOpt.ifPresent(gotten -> this.notes = gotten);
        return this;
    }

    public PieceBuilder status(String status) {
        Optional<String> statusOpt = Optional.ofNullable(status);
        statusOpt.ifPresent(gotten -> this.status = gotten);
        return this;
    }

    public PieceBuilder sign(String sign) {
        Optional<String> signOpt = Optional.ofNullable(sign);
        signOpt.ifPresent(gotten -> this.sign = gotten);
        return this;
    }

    public PieceBuilder updated(LocalDate updated) {
        Optional<LocalDate> updatedOpt = Optional.ofNullable(updated);
        updatedOpt.ifPresent(gotten -> this.updated = gotten);
        return this;
    }

//    public PieceBuilder stringsRequired(boolean stringsRequired) {
//        Optional<Boolean> stringsRequiredOpt = Optional.of(stringsRequired);
//        stringsRequiredOpt.ifPresent(gotten -> this.stringsRequired = stringsRequired);
//        return this;
//    }


    public Piece build() {
        return new Piece(this);
    }


}
