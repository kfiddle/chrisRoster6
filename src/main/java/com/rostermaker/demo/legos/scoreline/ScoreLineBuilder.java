package com.rostermaker.demo.legos.scoreline;

import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreLineBuilder {


    public List<Part> parts = new ArrayList<>();

    public Piece piece;
    public Show show;


    public ScoreLineBuilder() {
    }

    public ScoreLineBuilder part(Part part) {
        Optional<Part> partOpt = Optional.ofNullable(part);
        partOpt.ifPresent(gotten -> this.parts.add(gotten));
        return this;
    }

    public ScoreLineBuilder parts(List<Part> parts) {
        Optional<List<Part>> partsOpt = Optional.ofNullable(parts);
        partsOpt.ifPresent(gottenList -> this.parts = gottenList);
        return this;
    }

    public ScoreLineBuilder piece(Piece piece) {
        Optional<Piece> pieceOpt = Optional.ofNullable(piece);
        pieceOpt.ifPresent(gotten -> this.piece = gotten);
        return this;
    }

    public ScoreLineBuilder show(Show show) {
        Optional<Show> showOpt = Optional.ofNullable(show);
        showOpt.ifPresent(gotten -> this.show = gotten);
        return this;
    }

    public ScoreLine build() {
        return new ScoreLine(this);
    }


}
