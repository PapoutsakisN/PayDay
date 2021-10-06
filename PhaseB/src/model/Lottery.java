package model;

/**
 *
 * @author csd3035
 */
public class Lottery extends BoardPosition {

    private int Prize;

    /**
     * constructor: Constructs a lottery board position postcondition:
     * Initialize prize money
     * @param i the image path
     */
    public Lottery(String i) {
        super(i);
        this.Prize = 1000;
    }

    /**
     * transformer: Each player choose a number between 1-6 and roll the dice
     * until one of them roll the number he choose postcondition: Winner get the
     * prize money
     *
     * @param p1 is the player that stepped on the lottery board position
     * @param p2 is the other player
     * @param x1 p1 choice
     * @param x2 p2 choice
     * @return which player won, 1 for p1 & 2 for p2 (int)
     */
    public int toDo(Player p1, Player p2, int x1, int x2) {
        boolean b = true;
        int x = 0;
        while (b) {
            p1.getDice().RollDice();
            if (p1.getDice().getDiceNum() == x1) {
                p1.setMoney(this.Prize);
                b = false;
                x=1;
            }
            if (p1.getDice().getDiceNum() == x2) {
                p2.setMoney(this.Prize);
                b = false;
                x=2;
            }
        }
        return x;
    }
}
