package org.game.players;

import org.game.interfaces.Player;
import org.game.model.Move;

import javax.swing.*;

public class HumanPlayer implements Player {

    public HumanPlayer() {
    }

    @Override
    public Move getMove() {

        /**
         * receiving input as a round number from human player
         * using this index return PAPER || ROCK || SCISSORS
         */
        int playerSelectionIndex =JOptionPane.showOptionDialog(
                null,
                "Please select one of these:",
                "Your turn",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Move.values(),
                Move.getMoveByIndex(0));
        return Move.getMoveByIndex(playerSelectionIndex);
    }
}
