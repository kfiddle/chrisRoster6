package com.rostermaker.demo.models.player;

import java.util.Comparator;

public class PlayerCompare implements Comparator<Player> {

    public PlayerCompare() {
    }

    @Override
    public int compare(Player player1, Player player2) {
        if (player1.getPrimaryInstrument().compareTo(player2.getPrimaryInstrument()) != 0) {
            return player1.getPrimaryInstrument().compareTo(player2.getPrimaryInstrument());
        } else if (player1.getRank() < player2.getRank()) {
            return -1;
        } else {
            return 1;
        }
    }
}

//else {
//        return player1.getType().compare(player2.getType());
//        }
