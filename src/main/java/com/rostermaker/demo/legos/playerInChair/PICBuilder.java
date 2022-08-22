package com.rostermaker.demo.legos.playerInChair;


import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.legos.scoreline.ScoreLine;
import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.show.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PICBuilder {

    public ShowPiece showPiece;
    public Show show;
    public Player player;
    public Part primaryPart;

    public List<Part> parts = new ArrayList<>();

    public PICBuilder showPiece(ShowPiece showPiece) {
        Optional<ShowPiece> showPieceOpt = Optional.ofNullable(showPiece);
        showPieceOpt.ifPresent(gottenSP -> this.showPiece = gottenSP);
        return this;
    }

    public PICBuilder show(Show show) {
        Optional<Show> showOpt = Optional.ofNullable(show);
        showOpt.ifPresent(gottenS -> this.show = gottenS);
        return this;
    }

    public PICBuilder player(Player player) {
        Optional<Player> playerOpt = Optional.ofNullable(player);
        playerOpt.ifPresent(gottenp -> this.player = gottenp);
        return this;
    }

    public PICBuilder fromScoreLine(ScoreLine scoreLine) {
        Optional<ScoreLine> scoreLineOpt = Optional.ofNullable(scoreLine);
        if (scoreLineOpt.isPresent()) {
            this.parts.addAll(scoreLineOpt.get().getParts());
            this.primaryPart = parts.get(0);
        }
        return this;
    }

    public PICBuilder parts(List<Part> parts) {
        Optional<List<Part>> partsOpt = Optional.ofNullable(parts);
        partsOpt.ifPresent(gottenParts -> {
            this.parts.addAll(gottenParts);
            this.primaryPart = gottenParts.get(0);
        });
        return this;
    }

    public PIC build() {
        return new PIC(this);
    }

}
