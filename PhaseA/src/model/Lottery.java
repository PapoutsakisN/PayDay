package model;

/**
 *
 * @author csd3035
 */
public class Lottery extends BoardPosition {

    private int Prize;

    /**
     * constructor: Constructs a lottery board position postcondition:
     * Initialize prize money
     */
    public Lottery() {
        this.Prize = 1000;
    }

    /**
     * transformer: Each player choose a number between 1-6 and roll the dice
     * until one of them roll the number he choose postcondition: Winner get the
     * prize money
     *
     * @param p1 is the player that stepped on the lottery board position
     * @param p2 is the other player
     */
    public void toDo(Player p1, Player p2) {
    }
}
