package model;

/**
 *
 * @author csd3035
 */
public class Advertisment extends MessageCard {


    /**
     * constructor: Constructs a new Advertisment message card
     * @param info the card's information 
     * @param value the card's value
     * @param img the card's image
     * @param ch the card's choice text
     */
    public Advertisment(String info ,int value, String img,String ch) {
        super(info , value , img,ch);
    }

}
