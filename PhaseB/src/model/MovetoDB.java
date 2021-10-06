package model;

/**
 *
 * @author csd3035
 */
public class MovetoDB extends MessageCard {

    /**
     * constructor: Constructs a new MovetoDealorBuyer message card
          * @param info the card's information 
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public MovetoDB(String info ,int value, String img,String ch) {
        super(info , value , img,ch);
    }
    /**
     * transformer: Change players position to the nearest Buyer position of the board
     * postcondition: New position on board for the player
     * @param p is the player that drew this card
     */
    public void Action(Player p) {
        super.Action(p, null, 0);
    }
}
