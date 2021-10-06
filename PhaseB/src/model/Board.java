package model;

import java.util.Random;

/**
 *
 * @author csd3035
 */
public class Board implements Table {

    private BoardPosition[] days;
    private int PlayingMonths;
    private int month;
    private final int Messagethesis = 8; //8 Message card places on board  
    private final int Dealthesis = 5; //5 Deal card places on board
    private final int Sweepthesis = 2; //2 Sweepstakes places on board
    private final int Lotterythesis = 3; //3 Lottery places on board
    private final int Radiothesis = 2; //2 Radio places on board
    private final int Buyerthesis = 6; //6 Buyer places on board
    private final int Kazinothesis = 2; //2 kazino places on board
    private final int Yardthesis = 2; //2 Yard sales places on board
    private BoardPosition[] shufflearray;
    
    /**
     * constructor: Constructs the board with the positions postcondition: Board
     * with the positions(days) and initialize the month as the first to be
     * played
     */
    public Board() {
        this.days = new BoardPosition[32];
        this.shufflearray = new BoardPosition[29];
        this.InitializeBoard();
        this.month = 1;
    }

    /**
     * accessor: Get the array with the board positions (days)
     * @return the array days (BoardPosition)
     */
    public BoardPosition[] getDays(){
        return this.days;
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
        int i;
        int j = 0;

        for (i = 0; i < Buyerthesis-1; i++) {
            this.shufflearray[j] = new Buyer("Images/buyer.png");
            j++;
        }
        for (i = 0; i < Dealthesis; i++) {
            this.shufflearray[j] = new DealPos("Images/deal.png");
            j++;
        }
        for (i = 0; i < Kazinothesis; i++) {
            this.shufflearray[j] = new FamilyKazino("Images/casino.png");
            j++;
        }
        for (i = 0; i < Lotterythesis; i++) {
            this.shufflearray[j] = new Lottery("Images/lottery.png");
            j++;
        }
        for (i = 0; i < Messagethesis / 2; i++) {
            this.shufflearray[j] = new MessagePos("Images/mc1.png",false);
            j++;
        }
        for (i = 0; i < Messagethesis / 2; i++) {
            this.shufflearray[j] = new MessagePos("Images/mc2.png",true);
            j++;
        }
        for (i = 0; i < Radiothesis; i++) {
            this.shufflearray[j] = new RadioContest("Images/radio.png");
            j++;
        }
        for (i = 0; i < Sweepthesis; i++) {
            this.shufflearray[j] = new Sweepstakes("Images/sweep.png");
            j++;
        }
        for (i = 0; i < Yardthesis; i++) {
            this.shufflearray[j] = new YardSale("Images/yard.png");
            j++;
        }

        int index; 
        BoardPosition temp;
        Random random = new Random();
        for (i = this.shufflearray.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = this.shufflearray[index];
            this.shufflearray[index] = this.shufflearray[i];
            this.shufflearray[i] = temp;
        }
        
        this.days[0] = new StartPosition("Images/start.png");
        for(i=1;i<30;i++){
            this.days[i] = this.shufflearray[i-1];
        }
        this.days[30] = new Buyer("Images/buyer.png");
        this.days[31] = new PayDay("Images/pay.png");

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
        this.month = m;        
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
