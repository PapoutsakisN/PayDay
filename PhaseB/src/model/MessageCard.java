package model;

/**
 *
 * @author csd3035
 */
public class MessageCard implements Card {

    private String image;
    private int amount;
    private String info;
    private String choice;

    /**
     * constructor: Constructs a message card
     *
     * @param in the card's information
     * @param img the card's image
     * @param am the card's amount
     * @param ch the card's choice text
     */
    public MessageCard(String in, int am, String img, String ch) {
        this.info = in;
        this.amount = am;
        this.image = img;
        this.choice = ch;
    }

    /**
     * accessor: Get the choice text
     * @return the card's choice text (String)
     */
    public String getChoice() {
        return this.choice;
    }

    /**
     * accessor: Get the information text
     * @return the card's information text (String)
     */
    public String getMessage() {
        return this.info;
    }

    /**
     * accessor: Get the image path
     * @return the card's image path (String)
     */
    public String getImage() {
        return this.image;
    }

    /**
     * accessor: Get the amount
     * @return the card's amount (int)
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Classes that extend MessageCard will use it
     * transformer: According the parameters , will make the necessary actions
     * @param p1 player 1 (Draw card)
     * @param p2 player 2 (Opponent)
     * @param am amount
     */
    public void Action(Player p1, Player p2, int am) {

        if (p2 == null) {
            p1.setbillDept(am);
        } else {
            p2.setMoney(am);
            if (p1.getMoney() - am < 0) {
                p1.setLoan((am - p1.getMoney()) + 1000);
                p1.setMoney((am - p1.getMoney()) + 1000);
                p1.setMoney(-am);
            } else {
                p1.setMoney(-am);
            }
        }
    }

    /**
     * transformer: Change player's position to the nearest Deal or Buyer position
     * @param p1 player draw message card
     * @param b the array of the positions
     */
    public void MoveAction(Player p1, BoardPosition[] b) {
        int i = p1.getPosition();
        while (!(b[i] instanceof DealPos) || !(b[i] instanceof Buyer)) {
            i++;
        }
        p1.setPosition(i);
    }

    /**
     * transformer: Take the money from the player and add them to jackpot
     * @param p1 the player draw the card
     * @param p the jackpot
     * @param am the amount from the card
     */
    public void CharityAction(Player p1, JackPot p, int am) {
        int x = p1.getMoney();
        p.AddPrize(am);
        if (x - am < 0) {
            p1.setLoan((am - x) + 1000);
            p1.setMoney((am - x) + 1000);
            p1.setMoney(-am);
        } else {
            p1.setMoney(-am);
        }

    }
}
