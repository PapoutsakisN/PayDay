package model;

/**
 *
 * @author csd3035
 */
public class PayDay extends BoardPosition {

    /**
     * constructor: Constructs the payday board position
     *
     */
    public PayDay() {
    }

    /**
     * transformer: Give player that stepped on, money and the opportunity to pay bills and loan , 
     * makes him pay loan taxes and stop him if its his final month
     * postcondition: Give player that stepped on, money and the opportunity to pay bills and loan , 
     * makes him pay loan taxes and stop him if its his final month 
     * @param p is the player stepped on payday board position
     */
    public void PayDay(Player p){
    
    }

    /**
     * transformer: Let the player pay some bills from his billdept
     * postcondition: Update player's money and bill dept
     * @param p is the player playing
     */
    public void PayBill(Player p) {
    }

    /**
     * transformer: Player pays 10% of his loan
     * postcondition: Update player's money
     * @param p is the player playing
     */
    public void payLoanTaxes(Player p) {
    }

    /**
     * transformer: Let the player to pay a part or all of his loan
     * postcondition: Update player's money and loan
     * @param p is the player playing
     */
    public void PayLoan(Player p) {
    }

    /**
     * accessor: Return true if player finished the game , false otherwise
     * postcondition: Return true if player finished the game, false otherwise
     * @param p is the player playing
     * @return true if player finished the game , false otherwise (boolean)
     */
    public boolean finish(Player p) {
        
    }

    /**
     * transformer: Set Player's position back to start
     * postcondition: Set Player's position back to start
     * @param p is the player playing
     */
    public void goToStart(Player p){
    
    }
}
