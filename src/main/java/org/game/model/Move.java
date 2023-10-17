package org.game.model;

public enum Move {

    PAPER(0),
    ROCK(1),
    SCISSORS(2);


    private final int index;


    Move(int index) {
        this.index = index;
    }

    public static Move getMoveByIndex(int index){
        for(Move move : Move.values()){
            if(move.index == index){
                return move;
            }
        }
        throw new RuntimeException("Invalid index for move lookup.");
    }
}
