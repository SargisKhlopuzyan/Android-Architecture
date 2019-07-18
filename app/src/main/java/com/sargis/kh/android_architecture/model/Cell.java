package com.sargis.kh.android_architecture.model;

import static com.sargis.kh.android_architecture.utilities.StringUtility.isNullOrEmpty;

public class Cell {

    public Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return isNullOrEmpty(player.value);
    }

}
