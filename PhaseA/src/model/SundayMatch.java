package model;

/**
 *
 * @author csd3035
 */
public class SundayMatch {

    private int Prize;
    private int Bid;

    /**
     * constructor: Constructs a Sunday football match
     */
    public SundayMatch() {
        
    }

    /**
     * transformer: Set the bid of the player (1-2 1, 3-4 x, 5-6 2)
     * postcondition: Set the bid of the player
     * @param x is the bid of the player
     */
    public void SetBid(int x) {
        this.Bid = x;
    }
    /**
     * transformer: Roll the dice and if it matches with the player's bid wins , loses otherwise
     * postcondition: Set the prize money according to the result
     */
    void match(){
    
    }

    /**
     * accessor: Return the prize money if the player won
     * postcondition: Return the prize money if the player won
     * @return the prize money
     */
    public int Result() {
        return this.Prize;
    }

}
