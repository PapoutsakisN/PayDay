package model;

/**
 *
 * @author csd3035
 */
public class RadioContest extends BoardPosition {

    private int Prize;

    /**
     * constructor: Constructs a Radio contest board position postcondition:
     * Initialize prize money
     * @param i the image path
     */
    public RadioContest(String i) {
        super(i);
        this.Prize = 1000;
    }

    /**
     * transformer: Each player roll the dice and the greater roll gets the
     * prize, if they roll same number , they roll again postcondition: Winner
     * add the prize money to his money
     *
     * @param p1 is the player that stepped on Radio contest board position
     * @param p2 is the other player
     * @return 1 if p1 won or 2 if p2 won (int)
     */
    public int toDo(Player p1, Player p2) {
        boolean b = false;
        int x = 0;
        while (b) {
            p1.getDice().RollDice();
            p2.getDice().RollDice();
            if (p1.getDice().getDiceNum() > p2.getDice().getDiceNum()) {
                p1.setMoney(this.Prize);
                b = true;
                x=1;
            } else if (p1.getDice().getDiceNum() < p2.getDice().getDiceNum()) {
                p2.setMoney(this.Prize);
                b = true;
                x=2;
            }
        }
        return x;
    }
}
