package org.game.gaming;

import org.game.model.Move;
import org.game.model.Winner;

import static org.game.model.Move.*;

public class Calculator {

    public static Winner calculateWinner(Move machineResponse, Move playerResponse) {
        if (machineResponse.equals(playerResponse)) {
            return Winner.TIE;
        }

        switch (machineResponse) {
            case PAPER:
                return playerResponse.equals(ROCK) ? Winner.MACHINE : Winner.HUMAN;
            case ROCK:
                return playerResponse.equals(SCISSORS) ? Winner.MACHINE : Winner.HUMAN;
            case SCISSORS:
                return playerResponse.equals(PAPER) ? Winner.MACHINE : Winner.HUMAN;
            default:
                return Winner.TIE;
        }
    }
}
