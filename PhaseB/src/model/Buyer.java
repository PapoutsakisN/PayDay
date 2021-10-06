package model;

import java.util.Vector;

/**
 *
 * @author csd3035
 */
public class Buyer extends BoardPosition {

    /**
     * constructor: Constructs a buyer board position
     */
    public Buyer(String i) {
        super(i);
    }

    /**
     * transformer: Player gives a deal card and get the value , then loses the
     * card postcondition: Value of the deal card is added in player's money and
     * deal card is moved from player to rejected stack
     *
     * @param p is the player that stepped on buyer board position
     * @param i the card to sell
     * @return
     */
    public Card toDo(Player p, int i) {
        Vector<Card> d = p.GetDealCards();
        if (d.isEmpty()) {
            return null;
        }
        Dealcards c = (Dealcards) d.remove(i);
        p.setMoney(c.getSellPrice());
        return c;
    }
}
