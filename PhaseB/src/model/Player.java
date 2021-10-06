package model;

import java.util.Vector;

/**
 *
 * @author csd3035
 */
public class Player implements Table {

    private int Money;
    private int Loan;
    private int billDept;
    private Vector<Card> dealStack;
    private int Month;
    private int playerNo;
    private static int count = 0;
    private boolean Turn;
    private int position;
    private boolean finished;
    private Dice myDice;
    private Player adversary;
    private boolean gotL;

    /**
     * constructor: Constructs new player postcondition: Creates a player and
     * initialize some variables (such us his money , his loan , his deal cards
     * , his position on board etc)
     */
    public Player() {
        this.count++;
        this.Money = 0;
        this.Loan = 0;
        this.Month = 0;
        this.billDept = 0;
        this.dealStack = new Vector<Card>();
        this.playerNo = this.count;
        this.position = 0;
        this.finished = false;
        this.myDice = new Dice();
        this.gotL = false;
    }

    /**
     * accessor: Return the loan of the player postcondition: Return the loan of
     * the player
     *
     * @return the loan of the player
     */
    public int GetLoan() {
        return this.Loan;
    }

    /**
     * accessor: Get player's opponent
     * @return the other player (Player)
     */
    public Player GetOpponent() {
        return this.adversary;
    }

    /**
     * accessor: Get if player got Loan
     * @return true if player got loan , false otherwise
     */
    public boolean getGL() {
        return this.gotL;
    }

    /**
     * transformer: Set if player got loan
     * @param b true if he got , false otherwise
     */
    public void setGL(boolean b) {
        this.gotL = b;
    }

    /**
     * transformer : Set the player's opponent
     * @param p the adversary
     */
    public void SetOpponent(Player p) {
        this.adversary = p;
    }

    /**
     * transformer: Put a new deal card in player's deal cards postcondition:
     * Inform player's deal cards
     *
     * @param d the card to be placed in player's deal cards
     */
    public void SetDealCards(Card d) {
        this.dealStack.add(d);

    }

    /**
     * accessor: Return all of the player's deal cards postcondition: Return all
     * of the player's deal cards
     *
     * @return all of the player's deal cards
     */
    public Vector<Card> GetDealCards() {
        return this.dealStack;
    }

    /**
     * accessor: Return the month the player is postcondition: Return the month
     * the player is
     *
     * @return the month the player is
     */
    public int getMonth() {
        return this.Month;
    }

    /**
     * transformer: Set the month the player is postcondition: Set the month the
     * player is
     *
     * @param x the month the player is
     */
    public void setMonth(int x) {
        Month = Month + x;
    }

    /**
     * transformer: Add new loan to the player's loan postcondition: Set the
     * player's loan
     *
     * @param l the new loan
     */
    public void setLoan(int l) {
        this.Loan = this.Loan + l;
    }

    /**
     * transformer: Add new money to the player's money postcondition: Set the
     * player's money
     *
     * @param m the new money
     */
    public void setMoney(int m) {
        this.Money = this.Money + m;
    }

    /**
     * accessor: Return player's money postcondition: Return player's money
     *
     * @return player's money
     */
    public int getMoney() {
        return this.Money;
    }

    /**
     * transformer: Set player's position on board postcondition: Set player's
     * position
     *
     * @param p is player's position on board
     */
    public void setPosition(int p) {
        if (p > 31) {
            p = 31;
        }
        this.position = p;
    }

    /**
     * accessor: Return Player's position on board postcondition: Return
     * player's position on board
     *
     * @return player's position on board
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * transformer: Set the new bill to player's bill dept postcondition: Set
     * the new bill to player's bill dept
     *
     * @param x is the new bill
     */
    public void setbillDept(int x) {
        this.billDept = this.billDept + x;
    }

    /**
     * accessor: Return player's bill dept postcondition: Return player's bill
     * dept
     *
     * @return player's bill dept
     */
    public int getbillDept() {
        return this.billDept;
    }

    /**
     * accessor: Return player's name postcondition: Return player's name
     *
     * @return player's name (String)
     */
    public String getName() {
        return "Player " + this.playerNo;
    }

    /**
     * transformer: Set true if it's player's turn , false otherwise
     * postcondition: Set true if it's player's turn , false otherwise
     * @param b
     */
    public void setTurn(boolean b) {
        this.Turn = b;
        if (b) {
            this.myDice.setThrown();
        }
    }

    /**
     * accessor: Return true if is player's turn , false otherwise
     * postcondition: Return true if is player's turn, false otherwise
     *
     * @return true if is player's turn, false otherwise (boolean)
     */
    public boolean getTurn() {
        return this.Turn;
    }

    /**
     * accessor: Get player's dice
     * @return player's dice (Dice)
     */
    public Dice getDice() {
        return this.myDice;
    }

    /**
     * transformer: Set true if player finished the game , false otherwise
     * postcondition: Set true if player finished the game , false otherwise
     * @param b
     */
    public void setfinished(boolean b) {
        this.finished = b;
    }

    /**
     * accessor: Return true if the player finished the game , false otherwise
     * postcondition: Return true if the player finished the game, false
     * otherwise
     *
     * @return true if the player finished the game , false otherwise (boolean)
     */
    public boolean finished() {
  
        return this.finished;
    }

}
