package model;

/**
 *
 * @author csd3035
 */
public class FamilyKazino extends BoardPosition {
    
    private int Prize;
    /**
     * constructor: Constructs a Family kazino board position
     * @param i the image path 
     */
    public FamilyKazino(String i) {
        super(i);
        this.Prize = 500;
    }

    /**
     * transformer: If dice rolled 1-3-5 player gets the prize else if dice rolled 2-4-6 player loses the amount of the prize from his money 
     * postcondition: Informs the player's money and Jackpot according the result
     * @param p is the player that stepped on the kazino board position
     * @return 0 if player win or prize if player lost
     */
    public boolean toDo(Player p){
        if(p.getDice().getDiceNum() == 1 || p.getDice().getDiceNum() == 3 || p.getDice().getDiceNum() == 5){
            p.setMoney(-this.Prize);
            
            return false;
            
        }else{
            p.setMoney(this.Prize);
            return true;
        }
    }
}
