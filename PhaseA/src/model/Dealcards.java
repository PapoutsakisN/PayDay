package model;

/**
 *
 * @author csd3035
 */
public class Dealcards implements Card {

    private int BuyPrice;

    private int SellPrice;

    /**
     * constructor: Constructs a deal card
     * postcondition: A deal card with the buy and sell values given
     * @param buy is the Buy value of the card
     * @param sell is the sell value of the card
     */
    public Dealcards(int buy, int sell) {
        this.BuyPrice = buy;
        this.SellPrice = sell;
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
