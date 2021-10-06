package model;

/**
 *
 * @author csd3035
 */
public class JackPot {

    private int Prize;

    /**
     * constructor: Constructs jackpot and set prize money to 0
     */
    public JackPot() {
        this.Prize = 0;
    }

    /**
     * transformer: Add money to the prize
     * postcondition: Inform prize with the money added
     * @param x is the money to be added to the prize
     */
    public void AddPrize(int x) {
        
    }

    /**
     * accessor: Return prize money
     * postcondition: Return prize money
     * @return prize money
     */
    public int GetPrize() {
        return this.Prize;
    }

    /**
     * transformer: If a player roll 6 earns the prize money
     * postcondition: Return the prize money to the player and turn prize money to 0 again
     * @return the prize money
     */
    public int winPrize(){
        int x = this.Prize;
        this.Prize = 0;
        return x;
    }
}
