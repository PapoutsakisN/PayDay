package model;

/**
 *
 * @author csd3035
 */
public class SundayMatch {

    private int Prize;
    private int Bid;

    /**
     * constructor: Constructs a Sunday football match
     */
    public SundayMatch() {
        this.Prize = 500;
    }

    /**
     * transformer: Set the bid of the player (1 = 1, 2 = x, 3 = 2)
     * postcondition: Set the bid of the player
     *
     * @param x is the bid of the player
     */
    public void SetBid(int x) {
        this.Bid = x;
    }

    /**
     * transformer: Roll the dice and if it matches with the player's bid(1&2 =
     * 1 , 3&4 = 2, 5&6 = 3) wins , loses otherwise postcondition: Set the prize
     * money according to the result
     *
     * @param p the Player stepped on Sunday position
     * @return true if player won , false otherwise
     */
    public boolean match(Player p) {
        int b;
        p.getDice().RollDice();
        switch (p.getDice().getDiceNum()) {
            case 1:
            case 2:
                b = 1;
                break;
            case 3:
            case 4:
                b = 2;
                break;
            default:
                b = 3;
                break;
        }
        if (this.Bid == b) {
            p.setMoney(2 * this.Prize);
            return true;
        } else {
            p.setMoney(-this.Prize);
            return false;
        }
    }


}
