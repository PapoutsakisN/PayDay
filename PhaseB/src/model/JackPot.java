package model;

/**
 *
 * @author csd3035
 */
public class JackPot {

    private int Prize;
    private String Image;
    /**
     * constructor: Constructs jackpot and set prize money to 0
     * @param i the image path
     */
    public JackPot(String i) {
        this.Image = i;
        this.Prize = 0;
    }

    /**
     * accessor: Get the image's path
     * @return the image's path (String)
     */
    public String getImage(){
        return this.Image;
    }
    /**
     * transformer: Add money to the prize
     * postcondition: Inform prize with the money added
     * @param x is the money to be added to the prize
     */
    public void AddPrize(int x) {
        this.Prize = this.Prize + x;
    }

    /**
     * accessor: Return prize money
     * postcondition: Return prize money
     * @return prize money
     */
    public int GetPrize() {
        return this.Prize;
    }

    /**
     * transformer: If a player roll 6 earns the prize money
     * postcondition: Return the prize money to the player and turn prize money to 0 again
     * @return the prize money
     */
    public int winPrize(){
        int x = this.Prize;
        this.Prize = 0;
        return x;
    }
}
