package model;

/**
 *
 * @author csd3035
 */
public class Dealcards implements Card {

    private int BuyPrice;

    private int SellPrice;

    private String image;
    
    private String info;
    
    private String choice;
    
    private String choice1;
    
    /**
     * constructor: Constructs a deal card
     * postcondition: A deal card with the buy and sell values given
     * @param inf card's information
     * @param buy is the Buy value of the card
     * @param sell is the sell value of the card
     * @param i card's image path
     * @param ch card's choice text
     * @param ch1 card's second choice text
     */
    public Dealcards(String inf,int buy, int sell,String i,String ch,String ch1) {
        this.info = inf;
        this.BuyPrice = buy;
        this.SellPrice = sell;
        this.image = i;
        this.choice = ch;
        this.choice1 = ch1;
    }

    /**
     * accessor: Get the information text
     * @return the card's information text (String)
     */
    public String getMessage(){
         return this.info;
     }

    /**
     * accessor: Get the image path
     * @return the card's image path (String)
     */
    public String getImage(){
         return this.image;
     }

    /**
     * accessor: Get the choice text
     * @return the card's choice text (String)
     */
    public String getChoice(){
         return this.choice;
     }

    /**
     * accessor: Get the other choice text
     * @return the card's other choice text (String)
     */
    public String getChoice1(){
         return this.choice1;
     }
    /**
     * accessor: Return the buy value of the deal card
     * postcondition: Return the buy value of the deal card
     * @return the buy value of the card (int)
     */
    public int getBuyPrice() {
        return this.BuyPrice;
    }

    /**
     * accessor: Return the sell value of the deal card
     * postcondition: Return the sell value of the deal card
     * @return the sell value of the card (int)
     */
    public int getSellPrice() {
        return this.SellPrice;
    }

}
