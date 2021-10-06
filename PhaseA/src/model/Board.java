package model;

/**
 *
 * @author csd3035
 */
public class Board implements Table {

    private BoardPosition[] days;
    private int PlayingMonths;
    private int month;
    private int Messagethesis = 8; //8 Message card places on board  
    private int Dealthesis = 5; //5 Deal card places on board
    private int Sweepthesis = 2; //2 Sweepstakes places on board
    private int Lotterythesis = 3; //3 Lottery places on board
    private int Radiothesis = 2; //2 Radio places on board
    private int Buyerthesis = 6; //6 Buyer places on board
    private int Kazinothesis = 2; //2 kazino places on board
    private int Yardthesis = 2; //2 Yard sales places on board

    /**
     * constructor: Constructs the board with the positions postcondition: Board
     * with the positions(days) and initialize the month as the first to be
     * played
     */
    public Board() {
        this.days = new BoardPosition[32];
        this.month = 1;
    }

    /**
     * accessor: Return true if it is Sunday , false otherwise postcondition:
     * Return true if it is Sunday , false otherwise
     *
     * @param x is the position(day) player stepped on
     * @return true if it is Sunday , false otherwise
     */
    public boolean Sunday(int x) {
        return x == 7 || x == 14 || x == 21 || x == 28;
    }

    /**
     * transformer: Initialize board and set every position(day) with random
     * thesis(lottery , kazino etc) postcondition: Board with alla positions
     * filled
     */
    public void InitializeBoard() {
    }

    /**
     * accessor: Return playing month postcondition: Return playing month
     *
     * @return playing month (int)
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * transformer: Set the playing month postcondition: Set the playing month
     *
     * @param m is the month playing
     */
    public void setMonth(int m) {
    }

    /**
     * transformer: Set the desired playing months (1-3) postcondition: Set the
     * desired playing months
     *
     * @param m is the months to be played
     */
    public void setPlayingMonths(int m) {
        this.PlayingMonths = m;
    }

    /**
     * accessor: Return the playing months postcondition: Return the playing
     * months
     *
     * @return the playing months
     */
    public int getplayingMonths() {
        return this.PlayingMonths;
    }

}
