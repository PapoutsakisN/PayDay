package model;

/**
 *
 * @author csd3035
 */
public abstract class BoardPosition {

    private String Image;
    
    public BoardPosition(String image){
        this.Image = image;
    }
    
    /**
     * transformer: Method that do the necessary changes according the boardposition
     * postcondition: Inform the game about the changes
     */
   public void toDo() {
   }

    /**
     * transformer: Set the image path of the board position
     * postcondition: Set the image path of the board position
     * @param i the path for the image
     */
    public void setImage(String i) {
        this.Image = i;
    }

    /**
     * accessor: Return the image path of the board position
     * postcondition: Return the image path of the board position
     * @return the image path of the board position (String)
     */
    public String getImage() {
        return this.Image;
    }
}
