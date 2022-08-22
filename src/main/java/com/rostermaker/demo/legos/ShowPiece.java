package com.rostermaker.demo.legos;

import com.rostermaker.demo.models.piece.Piece;
import com.rostermaker.demo.models.show.Show;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ShowPiece implements Comparable<ShowPiece> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece piece;

    @ManyToOne
    private Show show;

    private int orderNum;

    public ShowPiece() {
    }

    public ShowPiece(Piece piece, Show show) {
        this.piece = piece;
        this.show = show;
    }

    public ShowPiece(Piece piece, Show show, int orderNum) {
        this.piece = piece;
        this.show = show;
        this.orderNum = orderNum;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Long getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public Show getShow() {
        return show;
    }

    public int getOrderNum() {
        return orderNum;
    }


    @Override
    public int compareTo(ShowPiece other) {
        if (orderNum > other.getOrderNum()) {
            return 1;
        }
        return -1;
    }


}
