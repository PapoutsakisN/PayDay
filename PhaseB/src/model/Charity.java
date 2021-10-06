package model;

/**
 *
 * @author csd3035
 */
public class Charity extends MessageCard {

    private int JackMoney;

    /**
     * constructor: Constructs a Charity message card
     *
     * @param info the card's information
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public Charity(String info, int value, String img, String ch) {
        super(info, value, img, ch);
    }

    /**
     * accessor: Get the money from the jackpot
     * @return jackpot's money
     */
    public int getJack() {
        return this.JackMoney;
    }

    /**
     * transformer: Takes money from player and gives them to Jackpot
     * postcondition: Informs players money and Jackpot money
     *
     * @param p is the player who drew the card
     */
    public void Action(Player p) {
        int x = p.getMoney();
        int a = super.getAmount();
        if (x - a < 0) {
            p.setLoan((a - x) + 1000);
            p.setMoney((a - x) + 1000);
            p.setMoney(-a);
        } else {
            p.setMoney(-a);
        }
        this.JackMoney = a;
    }
}
