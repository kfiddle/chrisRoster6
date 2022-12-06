package com.rostermaker.demo.legos.playerInChair;

import com.rostermaker.demo.legos.ShowPiece;
import com.rostermaker.demo.models.part.Part;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.show.Show;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class PIC implements Comparable<PIC> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private ShowPiece showPiece;

    @ManyToOne
    private Show show;

    @ElementCollection
    private List<Part> parts = new ArrayList<>();

    @Embedded
    private Part primaryPart;

    public PIC() {
    }

    public PIC(PICBuilder picBuilder) {
        this.showPiece = picBuilder.showPiece;
        this.show = picBuilder.show;
        this.parts = picBuilder.parts;
        this.player = picBuilder.player;
        this.primaryPart = picBuilder.primaryPart;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setShowPiece(ShowPiece showPiece) {
        this.showPiece = showPiece;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
        this.primaryPart = parts.get(0);
    }

    public void setPrimaryPart(Part primaryPart) {
        this.primaryPart = primaryPart;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public ShowPiece getShowPiece() {
        return showPiece;
    }

    public Show getShow() {
        return show;
    }

    public List<Part> getParts() {
        return parts;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    public boolean hasThisPlayer(Player incomingPlayer) {
        return player != null && player.equals(incomingPlayer);
    }

    public boolean couldSitHere(Player player) {
        for (Part part : parts) {
            if (!player.getInstruments().contains(part.getInstrument())) {
                return false;
            }
        }
        return true;
    }

    public boolean partsEquals(PIC pic) {
        for (int j = 0; j < pic.getParts().size(); j++) {
            if (!pic.getParts().get(j).equals(parts.get(j))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(PIC next) {
        return parts.get(0).compareTo(next.getParts().get(0));
    }
}



