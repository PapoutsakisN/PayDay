package model;

/**
 *
 * @author csd3035
 */
public class MadMoney extends MessageCard {

    /**
     * constructor: Constructs a new instance of MadMoney message card
     *
     * @param info the card's information
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public MadMoney(String info, int value, String img, String ch) {
        super(info, value, img, ch);
    }

    /**
     * transformer: It takes money from player2 and add them to player1
     * postcondition: Both Players money are informed about the changes
     *
     * @param p for p
     *
     */
    public void Action(Player p) {
        super.Action(p, p.GetOpponent(), super.getAmount());
    }
}
