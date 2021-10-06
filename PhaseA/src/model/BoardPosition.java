package model;

/**
 *
 * @author csd3035
 */
public abstract class BoardPosition {

    private String dayName;
    
    /**
     * transformer: Method that do the necessary changes according the boardposition
     * postcondition: Inform the game about the changes
     */
    public void toDo() {
    }

    /**
     * transformer: Set the name of the board position
     * postcondition: Set the name of the board position
     * @param n is the name to be set
     */
    public void setName(String n) {
    }

    /**
     * accessor: Return the name of the board position
     * postcondition: Return the name of the board position
     * @return the name of the board position (String)
     */
    public String getName() {
        return this.dayName;
    }
}
