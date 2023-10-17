package org.game.players;

import org.game.interfaces.Player;
import org.game.model.Move;

import java.util.Random;

public class MachinePlayer implements Player {

    Random random = new Random();


    public MachinePlayer() {
    }

    /**
     * machine use random number as an index | it covers 0 - 3 range | depends on enum values length
     * using this index return PAPER || ROCK || SCISSORS
     */
    @Override
    public Move getMove(){
         return Move.getMoveByIndex(random.nextInt(Move.values().length));
    }
}
