package com.rostermaker.demo.models.piece;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Piece {

    @Id
    @GeneratedValue
    private Long id;

    private String prefix;
    private String libNumber;
    private String suffix;
    private String composerLast;
    private String composerFirst;
    private String arranger;
    private String title;
    private String otherName;
    private String publisher;
    private String duration;
    private String windsBrass;
    private String vocalistSoloist;
    private String percBreakdown;
    private String notes;
    private String status;
    private String sign;

    private LocalDate updated;

    private boolean stringsRequired;

    public Piece() {
    }

    public Piece(PieceBuilder pieceBuilder) {
        prefix = pieceBuilder.prefix;
        libNumber = pieceBuilder.libNumber;
        suffix = pieceBuilder.suffix;
        composerLast = pieceBuilder.composerLast;
        composerFirst = pieceBuilder.composerFirst;
        arranger = pieceBuilder.arranger;
        title = pieceBuilder.title;
        otherName = pieceBuilder.otherName;
        publisher = pieceBuilder.publisher;
        duration = pieceBuilder.duration;
        windsBrass = pieceBuilder.windsBrass;
        vocalistSoloist = pieceBuilder.vocalistSoloist;
        percBreakdown = pieceBuilder.percBreakdown;
        notes = pieceBuilder.notes;
        status = pieceBuilder.status;
        sign = pieceBuilder.sign;
        updated = pieceBuilder.updated;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setLibNumber(String libNumber) {
        this.libNumber = libNumber;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setComposerLast(String composerLast) {
        this.composerLast = composerLast;
    }

    public void setComposerFirst(String composerFirst) {
        this.composerFirst = composerFirst;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setWindsBrass(String windsBrass) {
        this.windsBrass = windsBrass;
    }

    public void setVocalistSoloist(String vocalistSoloist) {
        this.vocalistSoloist = vocalistSoloist;
    }

    public void setPercBreakdown(String percBreakdown) {
        this.percBreakdown = percBreakdown;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public void setStringsRequired(boolean stringsRequired) {
        this.stringsRequired = stringsRequired;
    }

    public Long getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getComposerLast() {
        return composerLast;
    }

    public String getComposerFirst() {
        return composerFirst;
    }

    public String getArranger() {
        return arranger;
    }

    public String getTitle() {
        return title;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDuration() {
        return duration;
    }

    public String getWindsBrass() {
        return windsBrass;
    }

    public String getVocalistSoloist() {
        return vocalistSoloist;
    }

    public String getPercBreakdown() {
        return percBreakdown;
    }

    public String getNotes() {
        return notes;
    }

    public String getStatus() {
        return status;
    }

    public String getSign() {
        return sign;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public boolean isStringsRequired() {
        return stringsRequired;
    }

}
