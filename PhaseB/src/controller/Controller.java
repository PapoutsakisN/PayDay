package controller;

import java.util.Random;
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
    private JackPot myJackpot;
    private SundayMatch sm;

    /**
     * constructor: Constructs the controller of the game
     */
    public Controller() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.player1.SetOpponent(player2);
        this.player2.SetOpponent(player1);
        this.board = new Board();
        this.Dealcards = new CardStack("DealCards");
        this.MessageCards = new CardStack("MailCards");
        this.myJackpot = new JackPot("Images/jackpot.png");
        this.sm = new SundayMatch();
    }

    /**
     * accessor: Get the first player
     * postcondition : Return the first player
     * @return player1
     */
    public Player getP1() {
        return this.player1;
    }

    /**
     * accessor: Get the second player
     * postcondition : Return the second player
     * @return player2
     */
    public Player getP2() {
        return this.player2;
    }

    /**
     * accessor: Get the board of the game
     * postcondition : Return the board of the game
     * @return board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * accessor: Get the Message card's stack
     * postcondition : Return the Message card's stack
     * @return
     */
    public CardStack getMstack() {
        return this.MessageCards;
    }

    /**
     * accessor: Get the Deal card's stack
     * postcondition : Return the Deal card's stack
     * @return
     */
    public CardStack getDstack() {
        return this.Dealcards;
    }

    /**
     *accessor: Get the JackPot 
     * postcondition: Return the JackPot
     * @return JackPot
     */
    public JackPot getJack() {
        return this.myJackpot;
    }

    /**
     * accessor: Check player's bid and if he wins returns true, false otherwise
     * postcondition: Return true if player bid right, false otherwise
     * @param p for the player
     * @param b for player's bid
     * @return true if player won , false otherwise
     */
    public boolean SMatch(Player p, int b) {
        sm.SetBid(b);
        return sm.match(p);
    }

    /**
     * transformer: Set the desired playing months (1-3) postcondition: Set the
     * desired playing months
     * 
     * @param m is the months to be played
     */
    public void setPlayingMonths(int m) {
        player1.setMonth(m);
        player2.setMonth(m);
    }

    /**
     * transformer: Check player's turn and pay the money to get the card, if player don't have enough money he takes loan
     * @param c the deal card drawn
     * @param am the deal card's buy price
     */
    public void BuyDeal(Card c, int am) {
        if (!this.player1.getTurn()) {
            int x = this.player1.getMoney();
            if (x - am < 0) {
                this.player1.setLoan((am - x) + 1000);
                this.player1.setMoney((am - x) + 1000);
                this.player1.setMoney(-am);
                this.player1.setGL(true);
            } else {
                this.player1.setMoney(-am);
            }
            this.player1.SetDealCards(c);
        } else {
            int x = this.player2.getMoney();
            if (x - am < 0) {
                this.player2.setLoan((am - x) + 1000);
                this.player2.setMoney((am - x) + 1000);
                this.player2.setMoney(-am);
                this.player2.setGL(true);
            } else {
                this.player2.setMoney(-am);
            }
            this.player2.SetDealCards(c);
        }
    }

    /**
     * transformer: Check whose player is the turn and gives him the money from the card and throw the card to rejected 
     * @param c the deal card to sell
     * @param i the position of the deal card in the stack 
     */
    public void SellDeal(Card c, int i) {
        Dealcards d = (Dealcards) c;
        if (!this.player1.getTurn()) {
            player1.setMoney(d.getSellPrice());
            this.Dealcards.ThrowCard(player1.GetDealCards().remove(i));
        } else {
            player2.setMoney(d.getSellPrice());
            this.Dealcards.ThrowCard(player2.GetDealCards().remove(i));
        }
    }

    /**
     * accessor: Return randomly which player will start first postcondition:
     * Return randomly which player will start first
     *
     * @return the player that start first
     */
    public String FirstPlayer() {
        Random random = new Random();
        int x = random.nextInt(2) + 1;
        if (x == 1) {
            player1.setTurn(true);
            player2.setTurn(false);
            return "Player 1";
        } else {
            player2.setTurn(true);
            player1.setTurn(false);
            return "Player 2";
        }
    }

    /**
     * accessor: Return true if the game is completed, false otherwise
     * postcondition: Return true if the game is completed, false otherwise
     *
     * @return true if the game is completed , false otherwise
     */
    public boolean GameFinished() {
        return player1.finished() && player2.finished();
    }

    /**
     * accessor: Check each player's budget and returns the one with the highest
     * @return the winner, the player with the biggest budget 
     */
    public Player Winner() {
        if (GameFinished()) {
            int x1 = player1.getMoney() - player1.GetLoan() - player1.getbillDept();
            int x2 = player2.getMoney() - player2.GetLoan() - player2.getbillDept();
            if (x1 - x2 > 0) {
                return player1;
            } else if (x1 - x2 < 0) {
                return player2;
            }
        }
        return null;

    }

    /**
     * transformer: Initialize the game (Set players money to 2500) 
     * postcondition: Initialize the game
     */
    public void InitializeGame() {
        player1.setMoney(2500);
        player2.setMoney(2500);

    }

    /**
     * transformer: Set the players turn according to who is starting first  
     * 
     */
    public void PlayGame() {
        if (this.FirstPlayer().equals(player1.getName())) {
            player1.setTurn(true);
            player2.setTurn(false);
        } else {
            player1.setTurn(false);
            player2.setTurn(true);
        }
    }
}
