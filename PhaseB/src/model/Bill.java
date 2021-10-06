package model;

/**
 *
 * @author csd3035
 */
public class Bill extends MessageCard {

    /**
     * constructor: Constructs a bill message card
     * @param info the card's information 
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public Bill(String info ,int value, String img,String ch) {
        super(info , value , img,ch);
    }

    /**
     * transformer: It adds the bill money to players billDept
     * postcondition: Informed billDept of player
     * @param p is the player who drew the bill card
     */
    public void Action(Player p) {
    }
}
