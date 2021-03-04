package com.example.mancalagamestate;

import java.io.Serializable;
import java.util.Arrays;

public class MancalaGameState implements Serializable {
    //arrays for each player will store number of marbles in the corresponding pocket
    //ex: if humanPlayer has 4 marbles in their first pocket humanPlayer[0] = 4
    private int[] humanPlayer;
    private int[] computerPlayer;

    //stores who's turn it is
    private boolean isHumansTurn;

    private boolean rowIsEmpty; //if true game is over

    //constructor for objects of class MancalaGameState
    public MancalaGameState() {
        //initializing the number of marbles in each pocket
        humanPlayer = new int[7];
        computerPlayer = new int[7];
        //every pocket has 4 marbles at the beginning except the store which has 1
        for(int i = 0; i< humanPlayer.length - 1; i++){ //humanPlayer.length and computerPlayer.length will always be the same
            humanPlayer[i] = 4;
            computerPlayer[i] = 4;
        }
        humanPlayer[humanPlayer.length - 1] = 0;
        computerPlayer[computerPlayer.length - 1] = 0;

        //initializing booleans
        isHumansTurn = true;
        rowIsEmpty = false;
    }

    //copy Constructor
    public MancalaGameState(MancalaGameState original)
    {
        for(int i = 0; i< humanPlayer.length; i++){ //humanPlayer.length and computerPlayer.length will always be the same
            humanPlayer[i] = original.humanPlayer[i];
            computerPlayer[i] = original.computerPlayer[i];
        }

        //initializing booleans
        isHumansTurn = original.isHumansTurn;
        rowIsEmpty = original.rowIsEmpty;

    }

    @Override
    public String toString(){
        return "Human Player's Pockets: " + Arrays.toString(humanPlayer) + "\nComputer Player's Pockets: "
                + Arrays.toString(computerPlayer) + "\nisHumansTurn = " + isHumansTurn + "\nrowIsEmpty = " + rowIsEmpty;
    }

}
