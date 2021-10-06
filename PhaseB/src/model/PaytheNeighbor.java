package model;

/**
 *
 * @author csd3035
 */
public class PaytheNeighbor extends MessageCard {
    
    /**
     *constructor: Constructs a new PaytheNeighbor message card
          * @param info the card's information 
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public PaytheNeighbor(String info ,int value, String img,String ch) {
        super(info , value , img,ch);
    }
    

    /**
     * transformer: It takes money from player 1 that drew the card and gives them to player 2
     * postcondition : It informs both players money
     * @param p player that draw the card
     */
    public void Action(Player p) {
       super.Action(p, p.GetOpponent(), super.getAmount());
    }
}
