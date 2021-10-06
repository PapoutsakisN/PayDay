package model;

/**
 *
 * @author csd3035
 */
public class PayDay extends BoardPosition {

    /**
     * constructor: Constructs the payday board position
     *
     * @param i the image path
     */
    public PayDay(String i) {
        super(i);
    }

    /**
     * transformer: Give player that stepped on, money and the opportunity to pay loan , 
     * makes him pay loan taxes and stop him if its his final month
     * postcondition: Give player that stepped on, money and the opportunity to pay loan , 
     * makes him pay loan taxes and stop him if its his final month 
     * @param p is the player stepped on payday board position
     */
    public void PayDay(Player p){
        p.setMoney(2500);
    }

    /**
     * transformer: Let the player pay some bills from his billdept
     * postcondition: Update player's money and bill dept
     * @param p is the player playing
     * @param m the amount selected by the player
     */
    public void PayBill(Player p, int m) {
        p.setMoney(-m);
        p.setbillDept(-m);
    }

    /**
     * transformer: Player pays 10% of his loan
     * postcondition: Update player's money
     * @param p is the player playing
     */
    public void payLoanTaxes(Player p) {
        if(p.getMoney() > (p.GetLoan()*10/100)){
            p.setMoney(p.GetLoan()*10/100);
        }else{
            int x = (p.GetLoan()*10/100)-p.getMoney(); 
            p.setMoney(x+1000);
            p.setLoan(x+1000);
            p.setMoney(p.GetLoan()*10/100);
            p.setGL(true);
        }
    }

    /**
     * transformer: Let the player to pay a part or all of his loan
     * postcondition: Update player's money and loan
     * @param p is the player playing
     * @param m the amount selected by the player to be payed
     */
    public void PayLoan(Player p , int m) {
        p.setMoney(-m);
        p.setLoan(-m);
    }

    /**
     * accessor: Return true if player finished the game , false otherwise
     * postcondition: Return true if player finished the game, false otherwise
     * @param p is the player playing
     * @return true if player finished the game , false otherwise (boolean)
     */
    public boolean finish(Player p) {
        if (p.getMonth() <= 1 && p.getPosition() == 31) {
            p.setfinished(true);
            return true;
        }
         return false;       
                
    }

    /**
     * transformer: Set Player's position back to start
     * postcondition: Set Player's position back to start
     * @param p is the player playing
     */
    public void goToStart(Player p){
        p.setPosition(0); 
    }
}
