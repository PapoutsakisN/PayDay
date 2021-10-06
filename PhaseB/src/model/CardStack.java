package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.Stack;


/**
 *
 * @author csd3035
 */
public class CardStack implements Card {

    /**
     *
     */
    public ClassLoader cldr;
    private Stack<Card> stack;
    private Stack<Card> init_stack;
    private String[][] deal;
    private String[][] mail;

    /**
     * constructor: Constructs a stack of cards
     *
     * @param Type
     */
    public CardStack(String Type) {
        this.cldr = this.getClass().getClassLoader();
        this.stack = new Stack();
        this.init_stack = new Stack();
        if ("MailCards".equals(Type)) {
            this.mail = new String[48][6];
            this.readFile("Mail");
            this.InitializeCards(Type);
        }
        if ("DealCards".equals(Type)) {
            this.deal = new String[20][8];
            this.readFile("Deal");
            this.InitializeCards(Type);
        }
    }

    /**
     * transformer: Initialize the stack with the necessary cards postcondition:
     * Initialized stack of cards
     */
    private void InitializeCards(String type) {
        if ("MailCards".equals(type)) {
            int v;
            for (int i = 0; i < 48; i++) {
                v = Integer.parseInt(this.mail[i][4]);
                if (null != this.mail[i][1]) switch (this.mail[i][1]) {
                    case "Αdvertisement":
                        this.init_stack.add(new Advertisment(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    case "Bill":
                        this.init_stack.add(new Bill(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    case "Charity":
                        this.init_stack.add(new Charity(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    case "PayTheNeighbor":
                        this.init_stack.add(new PaytheNeighbor(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    case "MadMoney":
                        this.init_stack.add(new MadMoney(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    case "MoveToDealBuyer":
                        this.init_stack.add(new MovetoDB(this.mail[i][2], v, this.mail[i][5],this.mail[i][3]));
                        break;
                    default:
                        break;
                }
            }
        }
        if ("DealCards".equals(type)) {
            int b, s;
            for (int i = 0; i < 20; i++) {
                b = Integer.parseInt(this.deal[i][3]);
                s = Integer.parseInt(this.deal[i][4]);
                this.init_stack.add(new Dealcards(this.deal[i][2], b, s, this.deal[i][5],this.deal[i][6],this.deal[i][7]));//dealCards
            }
        }
        this.ShuffleStack();
    }
    
    
    private void readFile(String type) {
        BufferedReader br = null;
        String sCurrentLine;
        try {
            if (type.equals("Deal")) {
                URL fullPath = cldr.getResource("resources/dealCards.csv");
                String fpath = fullPath.getPath();
                br = new BufferedReader(new FileReader(fpath));
            } else {
                URL fullPath = cldr.getResource("resources/mailCards.csv");
                String fpath = fullPath.getPath();
                br = new BufferedReader(new FileReader(fpath));
            }
        } catch (FileNotFoundException ex) {
        System.out.println(ex);
        }
        int count = 0;
        try {
            br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                if (type.equals("Mail")) {
                    this.mail[count++] = sCurrentLine.split(",");
                } else {
                    this.deal[count++] = sCurrentLine.split(",");
                }
            }
            br.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * accessor: Returns the top card of the stack postcondition: Returns the
     * card from the top of the stack for the player
     *
     * @return
     */
    public Card DrawCard() {
        return this.stack.pop();

    }

    /**
     * transformer: Get the rejected card and throws it in the initialize stack 
     * @param c the card thrown
     */
    public void ThrowCard(Card c) {
        this.init_stack.push(c);
    }

    /**
     * observer: Returns if the card stack is empty postcondition: Returns if
     * the card stack is empty
     *
     * @return true if the stack is empty of cards , false otherwise
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * transformer: Shuffle the stack of cards 
     * postcondition: Shuffled stack of cards
     */
    public void ShuffleStack() {
        int index; 
        Card temp;
        Random random = new Random();
        for (int i = this.init_stack.size() - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = this.init_stack.remove(index);
            this.stack.add(temp);
        }
    }
}
