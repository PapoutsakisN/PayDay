
package model;

/**
 *
 * @author csd3035
 */
public class MessagePos extends BoardPosition {
    private boolean twocards;

    /**
     * constructor: Constructs message card
     * @param i the image path
     * @param b true if is 2 cards position , false otherwise
     */
    public MessagePos(String i,boolean b){
        super(i);
        this.twocards = b;
    }

    /**
     * accessor: Get true if is 2 cards position
     * @return true if it is 2 cards position , false otherwise
     */
    public boolean getTwo(){
        return this.twocards;
    }

    
}
