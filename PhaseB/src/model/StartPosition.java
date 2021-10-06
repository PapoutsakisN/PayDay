
package model;

/**
 *
 * @author csd3035
 */
public class StartPosition extends BoardPosition{

    /**
     * constructor: Constructs the start position
     * @param i image path
     */
    public StartPosition(String i){
        super(i);
        
    }

    /**
     * accessors: Return position 0 as the start position
     * postcondition: Return position 0 as the start position
     * @return position 0 as the start position
     */
    public int getSpos(){
        return 0;
    }
}
