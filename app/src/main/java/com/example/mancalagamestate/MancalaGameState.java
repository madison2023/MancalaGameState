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
        humanPlayer = new int[7];
        computerPlayer = new int[7];
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

    public boolean selectPit(int row, int col) { //columns labeled 0-6, where 0 is the first pocket and 6 is the store
        if(isHumansTurn) {
            if(row == 1 && humanPlayer[col] != 0 && humanPlayer[col] != 6) { //cant make a move from an empty pit, one that isn't yours, or your store
                //set selected pit to zero
                int numMarbles = humanPlayer[col];
                humanPlayer[col] = 0;
                //add one marble to each pit while there are still marbles going into other array if necessary
                addMarblesToHuman(numMarbles,col);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (row == 1 && computerPlayer[col] != 0 && computerPlayer[col] != 6) { //cant make a move from an empty pit, one that isn't yours, or your store
                //set selected pit to zero
                int numMarbles = computerPlayer[col];
                computerPlayer[col] = 0;
                //add one marble to each pit while there are still marbles going into other array if necessary
                addMarblesToComputer(numMarbles, col);
                return true;
            } else {
                return false;
            }
        }
    }

    public void addMarblesToHuman(int numMarbles, int col){
        while(numMarbles > 0) {
            if(col != humanPlayer.length) {
                humanPlayer[col++] += 1;
            }
            else {
                addMarblesToComputer(numMarbles, 0); //would start at the beginning of the marbles array
            }
            numMarbles--;
        }
    }

    public void addMarblesToComputer(int numMarbles, int col) {
        while(numMarbles > 0) {
            if(col != computerPlayer.length) {
                computerPlayer[col++] += 1;
            }
            else {
                addMarblesToHuman(numMarbles, 0); //would start at the beginning of the human array
            }
            numMarbles--;
        }
    }

}
