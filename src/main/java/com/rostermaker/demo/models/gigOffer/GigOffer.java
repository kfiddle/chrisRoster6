package com.rostermaker.demo.models.gigOffer;

import com.rostermaker.demo.enums.Reply;
import com.rostermaker.demo.models.player.Player;
import com.rostermaker.demo.models.show.Show;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class GigOffer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Player player;

    private LocalDate dateOffered;

    private Reply reply;

    private LocalDate responseDate;

    public GigOffer() {
    }

    public GigOffer(Show show) {
        this.show = show;
    }

    public GigOffer(Show show, Player player) {
        this.show = show;
        this.player = player;
    }

    public GigOffer(Show show, LocalDate dateOffered) {
        this.show = show;
        this.dateOffered = dateOffered;
    }

    public GigOffer(Show show, Player player, LocalDate dateOffered) {
        this.show = show;
        this.player = player;
        this.dateOffered = dateOffered;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDateOffered(LocalDate dateOffered) {
        this.dateOffered = dateOffered;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public Long getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Player getPlayer() {
        return player;
    }

    public LocalDate getDateOffered() {
        return dateOffered;
    }

    public Reply getReply() {
        return reply;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }


}
