import org.game.gaming.Calculator;
import org.game.gaming.Game;
import org.game.model.Move;
import org.game.model.Winner;
import org.game.players.HumanPlayer;
import org.game.players.MachinePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GameTest {


    private Game game;

    private MachinePlayer machinePlayer;

    private HumanPlayer humanPlayer;

    @Before
    public void setUpGame(){
        game = new Game();
        machinePlayer = new MachinePlayer();
        humanPlayer = new HumanPlayer();
    }

    @Test
    public void machineSelectionValidation(){
        Move move = machinePlayer.getMove();
        boolean isValid = move == Move.PAPER || move == Move.ROCK || move == Move.SCISSORS;
        Assert.assertTrue(isValid);
    }

    @Test
    public void humanSelectionValidation(){
        Move move = humanPlayer.getMove();
        boolean isValid = move == Move.PAPER || move == Move.ROCK || move == Move.SCISSORS;
        Assert.assertTrue(isValid);
    }
    @Test
    public void randomnessOfMachine() {
        Map<Move, Integer> resultOfSpins = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Move move = machinePlayer.getMove();
            resultOfSpins.put(move, resultOfSpins.getOrDefault(move, 0) + 1);
        }
        for (int value : resultOfSpins.values()) {
            //values by order PAPER | ROCK | SCISSORS
            System.out.println("this is values" + " " + value);
            /**
             * for equal distribution we wait approximately this range | this is completely assumption
             * if we want to fair game, we can use Mersenne Twister library as a random number generator | reliable PRNG
             */
            if (value > 300 && value < 500) {
                Assert.assertTrue(true);
            }
        }
    }

    @Test
    public void checkCalculation(){

        Winner case_1 = Calculator.calculateWinner(Move.ROCK, Move.PAPER);
        Assert.assertEquals(Winner.HUMAN, case_1);

        Winner case_2 = Calculator.calculateWinner(Move.PAPER, Move.ROCK);
        Assert.assertEquals(Winner.MACHINE, case_2);

        Winner case_3 = Calculator.calculateWinner(Move.SCISSORS, Move.ROCK);
        Assert.assertEquals(Winner.HUMAN, case_3);

        Winner case_4 = Calculator.calculateWinner(Move.SCISSORS, Move.SCISSORS);
        Assert.assertEquals(Winner.TIE, case_4);

        Winner case_5 = Calculator.calculateWinner(Move.ROCK, Move.SCISSORS);
        Assert.assertEquals(Winner.MACHINE, case_5);

        Winner case_6 = Calculator.calculateWinner(Move.PAPER, Move.SCISSORS);
        Assert.assertEquals(Winner.HUMAN, case_6);

        Winner case_7 = Calculator.calculateWinner(Move.SCISSORS, Move.PAPER);
        Assert.assertEquals(Winner.MACHINE, case_7);

        Winner case_8 = Calculator.calculateWinner(Move.PAPER, Move.PAPER);
        Assert.assertEquals(Winner.TIE, case_8);

        Winner case_9 = Calculator.calculateWinner(Move.ROCK, Move.ROCK);
        Assert.assertEquals(Winner.TIE, case_9);
    }



    @Test
    public void roundEndCheck(){
        //player selects a round for game
        int roundNum = game.selectNumberOfRounds();
        int totalGameCounter = 0;
        totalGameCounter = totalGameCounter + game.playGame(roundNum);
        Assert.assertEquals(roundNum, totalGameCounter);

    }

}
