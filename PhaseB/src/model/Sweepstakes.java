package model;

/**
 *
 * @author csd3035
 */
public class Sweepstakes extends BoardPosition {

    private int Prize;

    /**
     * constructor: Constructs a sweepstakes board position
     * postcondition: Initialize prize money
     * @param i image path
     */
    public Sweepstakes(String i) {
        super(i);
        this.Prize = 1000;
    }

    /**
     * transformer: Player roll the dice and the prize is multiplied by the number he rolled
     * postcondition: Add prize money to player's money
     * @param p is the player stepped on sweepstakes board position
     */
    public void toDo(Player p){
        int x = p.getDice().getDiceNum();
        p.setMoney(this.Prize * x);
    }
}
