package model;

/**
 *
 * @author csd3035
 */
public class RadioContest extends BoardPosition {

    private int Prize;

    /**
     * constructor: Constructs a Radio contest board position
     * postcondition: Initialize prize money
     */
    public RadioContest() {
        this.Prize = 1000;
    }

    /**
     * transformer: Each player roll the dice and the greater roll gets the prize, if they roll same number , they roll again
     * postcondition: Winner add the prize money to his money
     * @param p1 is the player that stepped on Radio contest board position
     * @param p2 is the other player
     */
    public void toDo(Player p1 , Player p2){}
}
