package model;

import java.util.Random;

/**
 *
 * @author csd3035
 */
public class Dice {

    private int diceNumber;
    private boolean thrown = false;

    /**
     * constructor: Constructs a new dice
     */
    public Dice() {

    }

    /**
     * transformer: Take a random number between 1-6 and turns thrown to true 
     * postcondition: Take a random number between 1-6 and turns thrown to true
     */
    public void RollDice() {
        Random random = new Random();
        this.diceNumber = random.nextInt(6) + 1;
        this.thrown = true;
    }

    /**
     * accessor: Return the dice number after it rolled
     * postcondition: Return the dice number after it rolled
     * @return the dice number after it rolled
     */
    public int getDiceNum() {
        return this.diceNumber;
    }

    /**
     * transformer: Set dice thrown t false after player's turn is finished
     * postcondition: Set dice thrown t false after player's turn is finished
     */
    public void setThrown(){
        this.thrown = false;
    }

    /**
     * accessor: Return if the dice is rolled
     * postcondition: Return if the dice is rolled
     * @return if the dice is rolled (boolean)
     */
    public boolean getThrown(){
        return this.thrown;
    }
}
