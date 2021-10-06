package model;

/**
 *
 * @author csd3035
 */
public class YardSale extends BoardPosition {

    /**
     * constructor: constructs a Yardsale board position
     * @param i image path
     */
    public YardSale(String i) {
        super(i);
    }

    /**
     * transformer: Player rolls the dice and get top deal card with 100*dice discount 
     * postcondition: Put deal card in player's deal cards
     * @param p is the player stepped on yard sale board position
     */
    public void toDo(Player p){
        p.getDice().RollDice();
        p.setMoney(-(p.getDice().getDiceNum()*100));
    }
}
