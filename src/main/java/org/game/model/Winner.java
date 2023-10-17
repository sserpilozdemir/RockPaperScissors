package org.game.model;

public enum Winner {

    TIE(-1),

    MACHINE(0),

    HUMAN(1);

    private final int index;

    Winner(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
