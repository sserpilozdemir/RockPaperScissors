package org.game.gaming;

import org.game.model.Move;
import org.game.model.Winner;
import org.game.players.HumanPlayer;
import org.game.players.MachinePlayer;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;



public class Game {

    MachinePlayer machinePlayer = new MachinePlayer();

    HumanPlayer humanPlayer = new HumanPlayer();


    /**initialize the game*/
    public void runTheGame() {
        welcomeHumanPlayer();
        int roundNum = selectNumberOfRounds();
        playGame(roundNum);
    }


    /**
     * welcome | receive useful data from human player
     */
    public void welcomeHumanPlayer() {
        String name = JOptionPane.showInputDialog("Please Enter Your Nick");

        //check input covers a-z and A-Z
        while (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Please Enter Name Not Number or Symbol");
            name = JOptionPane.showInputDialog("Please Enter Your Nick");
        }

        JOptionPane.showMessageDialog(null, "Welcome to Paper - Rock - Scissors Game" + " " + name);

        //checking String or not
    }

    /**
     * human player can manage that how many times to play
     */
    public Integer selectNumberOfRounds() {
        String input = JOptionPane.showInputDialog("How many rounds you want to play? Please enter.");

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(input + "is not an integer.");
        }
    }

    /**
     * return round number as an integer, it will be useful for unit test | but not necessary
     */
    public int playGame(int n) {
        Map<Winner, Integer> whoIsTotalWinner = new HashMap<>();

        int roundCount = 0;

        //for loop | n times | n : player round number input
        for (int i = 0; i < n; i++) {
            roundCount++;

            Move machineResponse = machinePlayer.getMove();
            Move humanResponse = humanPlayer.getMove();

            //calc
            Winner winner = Calculator.calculateWinner(machineResponse, humanResponse);
            Integer current = whoIsTotalWinner.get(winner);

            if (winner.equals(Winner.MACHINE)) {
                int updatedWins = current == null ? 1 : current + 1;
                whoIsTotalWinner.put(winner, updatedWins);
                JOptionPane.showMessageDialog(null, "The winner is " + "\n" + "M a c h i n e");
            } else if (winner.equals(Winner.HUMAN)) {
                int updatedWins = current == null ? 1 : current + 1;
                whoIsTotalWinner.put(winner, updatedWins);
                JOptionPane.showMessageDialog(null, "The winner is " + " \n" + "Y O U");
            } else {
                JOptionPane.showMessageDialog(null, "Tied Game!");
            }

        }

        /**
         * extra feature | calculating whole game winner | comparing win amount between players
         */
        Winner finalWinner = whoIsTotalWinner.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Winner.TIE);

        String endGameMessage = "";
        if (finalWinner.equals(Winner.TIE)) {
            endGameMessage = "THE" + " " + n + " ROUND FINISH!" + "\n" + "The Game is a Tie.";
        } else {
            endGameMessage = "THE" + " " + n + " ROUND FINISH!" + "\n" + "The Total Rounds Winner is " + " " + finalWinner;
        }

        JOptionPane.showMessageDialog(null, endGameMessage);
        return roundCount;

    }


}
