package com.rostermaker.demo.legos.scoreline;

import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ScoreLine implements Comparable<ScoreLine> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece piece;

    @ManyToOne
    private Show show;

    @ElementCollection
    private List<Part> parts = new ArrayList<>();

    @Embedded
    private Part primaryPart;

    public ScoreLine() {
    }

    public ScoreLine(ScoreLineBuilder scoreLineBuilder) {
        this.parts = scoreLineBuilder.parts;
        this.piece = scoreLineBuilder.piece;
        this.show = scoreLineBuilder.show;
        primaryPart = parts.get(0);
    }

    public ScoreLine(Part part) {
        parts.add(part);
    }

    public ScoreLine(Part part, Piece piece) {
        this.parts.add(part);
        this.piece = piece;
    }

    public ScoreLine(Part part, Show show) {
        this.parts.add(part);
        this.show = show;
    }

    public ScoreLine(List<Part> parts, Piece piece) {
        this.parts = parts;
        this.piece = piece;
    }

    public ScoreLine(List<Part> parts, Show show) {
        this.parts = parts;
        this.show = show;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public Long getId() {
        return id;
    }

    public List<Part> getParts() {
        return parts;
    }

    public Piece getPiece() {
        return piece;
    }

    public Show getShow() {
        return show;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    @Override
    public int compareTo(ScoreLine next) {
        return parts.get(0).compareTo(next.getParts().get(0));
    }
}
