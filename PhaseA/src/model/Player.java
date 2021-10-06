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

    /**
     * constructor: Constructs new player postcondition: Creates a player and
     * initialize some variables (such us his money , his loan , his deal cards
     * , his position on board etc)
     */
    public Player() {
        this.count++;
        this.Money = 2500;
        this.Loan = 0;
        this.Month = 1;
        this.billDept = 0;
        this.dealStack = new Vector<Card>();
        this.playerNo = this.count;
        this.position = 0;
        this.finished = false;
        this.myDice = new Dice();
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
     * transformer: Put a new deal card in player's deal cards postcondition:
     * Inform player's deal cards
     *
     * @param d the card to be placed in player's deal cards
     */
    public void SetDealCards(Card d) {
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
        this.Month = x;
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
        return "Player" + this.playerNo;
    }

    /**
     * transformer: Set true if it's player's turn , false otherwise
     * postcondition: Set true if it's player's turn , false otherwise
     */
    public void setTurn(boolean b) {
    }

    /**
     * accessor: Return true if is player's turn , false otherwise
     * postcondition: Return true if is player's turn, false otherwise
     *
     * @return true if is player's turn, false otherwise (boolean)
     */
    public boolean getTurn() {
    }

    /**
     * transformer: Set true if player finished the game , false otherwise
     * postcondition: Set true if player finished the game , false otherwise
     */
    public void setfinished(boolean b) {
    }

    /**
     * accessor: Return true if the player finished the game , false otherwise
     * postcondition: Return true if the player finished the game, false
     * otherwise
     *
     * @return true if the player finished the game , false otherwise (boolean)
     */
    public boolean finished() {

    }

}
