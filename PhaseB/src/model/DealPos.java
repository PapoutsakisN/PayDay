
package model;

/**
 *
 * @author csd3035
 */
public class DealPos extends BoardPosition {

    /**
     * constructor: Constructs a deal board position
     * @param i the path of the image
     */
    public DealPos(String i){
        super(i);
    }
    
    /**
     * transformer: Player draw a deal card from deal card stack
     * postcondition: Top deal card from table's deal card stack is transferred to player's deal card stack
     * @param d
     * @param p is the player that stepped on the deal board position
     */
    public void toDo(CardStack  d,Player p){
        Dealcards c = (Dealcards)d.DrawCard();
        boolean b=false;
        
        
        
        //if player buy's card b=true, else false
        
        if(b){
            p.SetDealCards(c);
            p.setMoney(-c.getBuyPrice());
        }
     }
}
