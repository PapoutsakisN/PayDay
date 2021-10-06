package controller;

import model.*;

/**
 *
 * @author csd3035
 */
public class Controller {

    private Player player1, player2;
    private Board board;
    private CardStack Dealcards;
    private CardStack MessageCards;
    private int Month;
    private JackPot myJackpot;

    /**
     * constructor: Constructs the controller of the game
     */
    public Controller() {

    }

    /**
     * transformer: Set the desired playing months (1-3)
     * postcondition: Set the desired playing months
     * @param m is the months to be played
     */
    public void setPlayingMonths(int m) {

    }

    /**
     * accessor: Return randomly which player will start first
     * postcondition: Return randomly which player will start first
     * @return the player that start first
     */
    public Player FirstPlayer() {

    }

    /**
     * accessor: Return true if the game is completed, false otherwise
     * postcondition: Return true if the game is completed, false otherwise
     * @return true if the game is completed , false otherwise
     */
    public boolean GameFinished() {

    }

    /**
     * transformer: Initialize the game (Board, players,cards)
     * postcondition: Initialize the game
     */
    public void InitializeGame() {

    }

    /**
     * transformer: Run the game 
     * postcondition: Run the game
     * @param p1 is the player 1
     * @param p2 is the player 2
     */
    public void PlayGame(Player p1, Player p2) {

    }

}
