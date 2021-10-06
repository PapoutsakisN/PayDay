package model;

/**
 *
 * @author csd3035
 */
public class FamilyKazino extends BoardPosition {
    
    private int Prize;
    /**
     * constructor: Constructs a Family kazino board position
     */
    public FamilyKazino() {
        this.Prize = 500;
    }

    /**
     * transformer: If dice rolled 1-3-5 player gets the prize else if dice rolled 2-4-6 player loses the amount of the prize from his money 
     * postcondition: Informs the player's money according the result
     * @param p is the player that stepped on the kazino board position
     */
    public void toDo(Player p){}
}
