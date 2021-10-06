package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.*;

/**
 *
 * @author csd3035
 */
public class GUI extends JFrame {

    private JDesktopPane theDesktop;
    private JTextField infoBox, Money1, Money2, Loan1, Loan2, Dept1, Dept2, Info1, Info2, Info3, Info4;
    private JTextField[] Name;
    private JPanel Player1, Player2;
    private JPanel[] pall1, pall2;
    private JButton Dice1, Dice2, Deal1, Deal2, MessageC, DealC;
    private ClassLoader cl;
    private JDesktopPane Board;
    private URL ImageURL, imageURL;
    private Image imag;
    private Controller control;
    private JDesktopPane[] Position;
    private JLabel d1, d2;
    private myDesktopPane pawn1, pawn2;
    private myDesktopPane[] pos;
    private boolean draw, get2;
    private int count;

    /**
     * constructor: Constructs the game panel
     */
    public GUI() {
        this.draw = false;
        this.get2 = false;
        this.theDesktop = new JDesktopPane();
        this.cl = this.getClass().getClassLoader();
        control = new Controller();
        this.Position = new JDesktopPane[35];
        this.pall1 = new JPanel[2];
        this.pall2 = new JPanel[2];
        this.d1 = new JLabel();
        this.d2 = new JLabel();

        this.Money1 = new JTextField();
        this.Loan1 = new JTextField();
        this.Dept1 = new JTextField();

        this.Money2 = new JTextField();
        this.Loan2 = new JTextField();
        this.Dept2 = new JTextField();

        this.Info1 = new JTextField();
        this.Info2 = new JTextField();
        this.Info3 = new JTextField();
        this.Info4 = new JTextField();
        control.FirstPlayer();
        control.InitializeGame();

    }

    /**
     * transformer: Initialize board , set the panel , players , info box and
     * cards
     */

    void InitializePane() {
        JMenuBar bar = new JMenuBar();
        JMenu newMenu = new JMenu("New Game");
        newMenu.addActionListener(new NewListener());
        //JMenu saveMenu = new JMenu("Save Game");
        //JMenu loadMenu = new JMenu("Load Game");

        bar.add(newMenu);
        //bar.add(saveMenu);
        //bar.add(loadMenu);
        setJMenuBar(bar);

        Object[] options = {"1 Month", "2 Months", "3 Months"};
        JOptionPane p = new JOptionPane();

        getContentPane().add(this.theDesktop);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setSize(width, height - 50);

        this.theDesktop.setBackground(Color.DARK_GRAY);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int n = JOptionPane.showOptionDialog(this,
                "Πόσους μήνες επιθυμείτε να παίξετε: ",
                "Νέο Παιχνίδι",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch (n) {
            case 0:
                this.control.setPlayingMonths(1);
                break;
            case 1:
                this.control.setPlayingMonths(2);
                break;
            case 2:
                this.control.setPlayingMonths(3);
                break;
            default:
                this.control.setPlayingMonths(1);
                break;
        }

        imageURL = this.cl.getResource("Images/pawn_blue.png");
        imag = new ImageIcon(imageURL).getImage();

        this.pawn1 = new myDesktopPane(imag.getScaledInstance(70, 60, Image.SCALE_SMOOTH));
        this.pawn1.setOpaque(false);
        this.pawn1.setVisible(true);
        this.pawn1.setPreferredSize(new Dimension(70, 70));

        imageURL = this.cl.getResource("Images/pawn_yellow.png");
        imag = new ImageIcon(imageURL).getImage();

        this.pawn2 = new myDesktopPane(imag.getScaledInstance(70, 60, Image.SCALE_SMOOTH));
        this.pawn2.setOpaque(false);
        this.pawn2.setVisible(true);
        this.pawn2.setPreferredSize(new Dimension(70, 70));

        Image message; // load images
        Image deal;
        this.ImageURL = cl.getResource("Images/mailCard.png");
        message = new ImageIcon(ImageURL).getImage();
        message = message.getScaledInstance(140, 80, Image.SCALE_SMOOTH);
        this.ImageURL = cl.getResource("Images/dealCard.png");
        deal = new ImageIcon(ImageURL).getImage();
        deal = deal.getScaledInstance(140, 80, Image.SCALE_SMOOTH);

        addPFrame(this.theDesktop, this.Player1, this.d1, this.pall1, this.Dice1, this.Deal1, this.Money1, this.Loan1, this.Dept1, new Point(width - 350, 10), "Player1", Color.BLUE);
        addTF(this.theDesktop, this.Info1, this.Info2, this.Info3, this.Info4, new Point(width - 350, ((height / 2) - 170)));
        addPFrame(this.theDesktop, this.Player2, this.d2, this.pall2, this.Dice2, this.Deal2, this.Money2, this.Loan2, this.Dept2, new Point(width - 350, height - 300), "Player2", Color.YELLOW);
        addButton(this.theDesktop, this.MessageC, new Point(width - 350, height / 2), new Dimension(140, 80), "Mail", message);
        addButton(this.theDesktop, this.DealC, new Point(width - 200, height / 2), new Dimension(140, 80), "Deal", deal);
        addBoard(this.theDesktop, this.Position, new Point(10, 100), width, height);
        this.setPlayerInfo();
        this.control.PlayGame();
    }

    /**
     * transformer: Create the Player's frame with his informations
     *
     * @param pane the basic panel
     * @param Player the player's panel
     * @param d dice label
     * @param pall information panel
     * @param Dice dice button
     * @param Deal deal button
     * @param Money money text
     * @param Loan loan text
     * @param Dept bill dept text
     * @param p the point of frame on the basic panel
     * @param Title the name of the frame
     * @param c color of the frame
     */

    void addPFrame(JDesktopPane pane, JPanel Player, JLabel d, JPanel[] pall, JButton Dice, JButton Deal, JTextField Money, JTextField Loan, JTextField Dept, Point p, String Title, Color c) {

        Player = new JPanel();
        Player.setSize(300, 180);
        Player.setLocation(p);
        Player.setName(Title);
        Player.setLayout(new BoxLayout(Player, BoxLayout.Y_AXIS));
        Player.setBackground(Color.LIGHT_GRAY);
        Player.setVisible(true);

        JPanel pa = new JPanel();
        pa.setLayout(new BoxLayout(pa, BoxLayout.X_AXIS));
        pall[0] = new JPanel();
        pall[1] = new JPanel();
        pall[1].setBackground(Color.LIGHT_GRAY);
        pall[0].setLayout(new BoxLayout(pall[0], BoxLayout.Y_AXIS));
        pall[0].setBackground(Color.LIGHT_GRAY);

        imageURL = this.cl.getResource("Images/dice-6.jpg");
        imag = new ImageIcon(imageURL).getImage();
        imag = imag.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        d.setIcon(new ImageIcon(imag));

        Money.setEditable(false);
        Money.setOpaque(false);
        Money.setBorder(null);

        Loan.setEditable(false);
        Loan.setOpaque(false);
        Loan.setBorder(null);

        Dept.setEditable(false);
        Dept.setOpaque(false);
        Dept.setBorder(null);
        Money.setText("Money: " + 0 + " Euro");
        Loan.setText("Loan: " + 0 + " Euro");
        Dept.setText("Bill Dept: " + 0 + " Euro");

        JTextField Info = new JTextField();
        Info.setText(Title);

        Info.setBorder(null);
        Info.setBackground(c);

        Player.add(Info);
        pall[0].add(Money);
        pall[0].add(Loan);
        pall[0].add(Dept);
        pall[1].add(d);
        pa.add(pall[0]);
        pa.add(pall[1]);
        Player.add(pa);

        addButtonP(Player, Deal, new Point(5, 150), new Dimension(160, 20), "My Deal Cards");
        addButtonP(Player, Dice, new Point(5, 120), new Dimension(120, 20), "Roll Dice");

        pane.add(Player);
    }

    /**
     * transformer: Create and set the info box
     *
     * @param pane the basic panel
     * @param I1 first row on info box
     * @param I2 second row of info box
     * @param I3 third row of info box
     * @param I4 last row of info box
     * @param p the point of info box on the basic panel
     */

    void addTF(JDesktopPane pane, JTextField I1, JTextField I2, JTextField I3, JTextField I4, Point p) {

        this.infoBox = new JTextField();
        this.infoBox.setSize(300, 120);
        this.infoBox.setLocation(p);
        this.infoBox.setName("Info Box");
        this.infoBox.setLayout(new BoxLayout(infoBox, BoxLayout.Y_AXIS));
        this.infoBox.setBackground(Color.WHITE);
        this.infoBox.setVisible(true);

        I1.setEditable(false);
        I1.setBorder(null);
        I1.setOpaque(false);

        I2.setEditable(false);
        I2.setBorder(null);
        I2.setOpaque(false);

        I3.setEditable(false);
        I3.setBorder(null);
        I3.setOpaque(false);

        I4.setEditable(false);
        I4.setBorder(null);
        I4.setOpaque(false);

        this.infoBox.add(I1);
        this.infoBox.add(I2);
        this.infoBox.add(I3);
        this.infoBox.add(I4);

        I1.setText("Tο παιχνίδι ξεκίνησε");
        I2.setText("------------------------");
        I3.setText("Διαλέξατε " + control.getP1().getMonth() + " μήνες να παίξετε");
        I4.setText("Ξεκινάει πρώτος ο " + control.FirstPlayer());

        pane.add(this.infoBox);
    }

    /**
     * transformer: Buttons for player frame
     *
     * @param player player's frame
     * @param button Jbutton
     * @param p point of the button on the player's frame
     * @param d dimensions of the button
     * @param Title name of the button
     */
    void addButtonP(JPanel player, JButton button, Point p, Dimension d, String Title) {

        button = new JButton();
        button.setSize(d);
        button.setLocation(p);
        button.setBackground(Color.WHITE);
        button.setText(Title);
        if (Title.equals("Roll Dice")) {
            button.addActionListener(new DiceListener());
        } else {
            //deal cards 
        }
        button.setVisible(true);
        player.add(button);
    }

    /**
     * transformer: Create and set buttons on the basic panel
     *
     * @param pane basic panel
     * @param button JButton
     * @param p position of the button on the panel
     * @param d dimensions of the button
     * @param Title name of the button
     * @param img the image of the button
     */
    void addButton(JDesktopPane pane, JButton button, Point p, Dimension d, String Title, Image img) {

        button = new JButton();
        button.setSize(d);
        button.setLocation(p);
        button.setBackground(Color.WHITE);
        button.setIcon(new ImageIcon(img));
        button.addActionListener(new CardListener());
        button.setName(Title);
        button.setVisible(true);

        pane.add(button);
    }

    /**
     * transformer: Set the dice image according the number it rolled
     *
     * @param x the number rolled
     * @param p the player rolled dice
     */
    void setDiceImg(int x, int p) {
        imageURL = this.cl.getResource("Images/dice-" + x + ".jpg");
        imag = new ImageIcon(imageURL).getImage();
        imag = imag.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        if (p == 1) {
            d1.setIcon(new ImageIcon(imag));
        } else {
            d2.setIcon(new ImageIcon(imag));
        }

    }

    /**
     * transformer: Create and set the board with the positions on the basic
     * panel
     *
     * @param pane basic panel
     * @param P array with small panels for its position
     * @param p position of board on basic panel
     * @param w width of board
     * @param h height of board
     */
    void addBoard(JDesktopPane pane, JDesktopPane[] P, Point p, int w, int h) {

        this.Board = new JDesktopPane();
        this.Board.setLocation(p);
        this.Board.setSize(w - 380, h - 300);
        this.Board.setOpaque(false);
        this.Board.setVisible(true);
        this.Board.setLayout(new GridLayout(0, 7));

        this.pos = new myDesktopPane[35];
        this.Name = new JTextField[35];

        P[0] = new JDesktopPane();

        P[0].setVisible(true);
        P[0].setLayout(new BoxLayout(P[0], BoxLayout.Y_AXIS));

        this.Name[0] = new JTextField();
        this.Name[0].setEditable(false);
        this.Name[0].setBorder(null);
        this.Name[0].setBackground(Color.ORANGE);
        this.Name[0].setVisible(true);
        this.Name[0].setText("Start 0");
        P[0].add(this.Name[0]);

        imageURL = this.cl.getResource(this.control.getBoard().getDays()[0].getImage());
        imag = new ImageIcon(imageURL).getImage();
        this.pos[0] = new myDesktopPane(imag.getScaledInstance(140, 80, Image.SCALE_DEFAULT));
        this.pos[0].setPreferredSize(new Dimension(70, 70));

        this.pos[0].setOpaque(false);
        this.pos[0].setBorder(null);
        this.pos[0].setVisible(true);
        this.pos[0].setLayout(new BoxLayout(pos[0], BoxLayout.X_AXIS));

        this.pos[0].add(pawn1);
        this.pos[0].add(pawn2);

        P[0].add(this.pos[0]);
        this.Board.add(P[0]);
        for (int i = 1; i < 32; i++) {
            P[i] = new JDesktopPane();
            P[i].setVisible(true);
            P[i].setLayout(new BoxLayout(P[i], BoxLayout.Y_AXIS));

            this.Name[i] = new JTextField();
            this.Name[i].setEditable(false);
            this.Name[i].setBorder(null);
            this.Name[i].setBackground(Color.ORANGE);
            this.Name[i].setVisible(true);
            switch (i % 7) {
                case 0:
                    this.Name[i].setText("Sunday " + i);
                    break;
                case 1:
                    this.Name[i].setText("Monday " + i);
                    break;
                case 2:
                    this.Name[i].setText("Tuesday " + i);
                    break;
                case 3:
                    this.Name[i].setText("Wednesday " + i);
                    break;
                case 4:
                    this.Name[i].setText("Thursday " + i);
                    break;
                case 5:
                    this.Name[i].setText("Friday " + i);
                    break;
                default:
                    this.Name[i].setText("Saturday " + i);
                    break;
            }
            P[i].add(this.Name[i]);
            imageURL = this.cl.getResource(this.control.getBoard().getDays()[i].getImage());
            imag = new ImageIcon(imageURL).getImage();
            this.pos[i] = new myDesktopPane(imag.getScaledInstance(140, 80, Image.SCALE_DEFAULT));
            this.pos[i].setPreferredSize(new Dimension(70, 70));

            this.pos[i].setOpaque(false);

            this.pos[i].setBorder(null);
            this.pos[i].setVisible(true);
            this.pos[i].setLayout(new FlowLayout());
            P[i].add(this.pos[i]);

            this.Board.add(P[i]);
        }
        P[33] = new JDesktopPane();
        P[33].setBackground(Color.DARK_GRAY);
        P[33].setVisible(true);

        this.Board.add(P[33]);

        P[34] = new JDesktopPane();
        P[34].setVisible(true);
        P[34].setLayout(new BoxLayout(P[34], BoxLayout.Y_AXIS));

        this.Name[34] = new JTextField();
        this.Name[34].setEditable(false);
        this.Name[34].setBorder(null);
        this.Name[34].setBackground(Color.ORANGE);
        this.Name[34].setVisible(true);
        this.Name[34].setText("JackPot = 0 Euro");
        P[34].add(this.Name[34]);

        imageURL = this.cl.getResource(this.control.getJack().getImage());
        imag = new ImageIcon(imageURL).getImage();
        this.pos[34] = new myDesktopPane(imag.getScaledInstance(140, 80, Image.SCALE_DEFAULT));
        this.pos[34].setPreferredSize(new Dimension(70, 70));
        this.pos[34].setLayout(new FlowLayout());

        P[34].add(this.pos[34]);
        this.Board.add(P[34]);

        pane.add(this.Board);
    }

    /**
     * transformer: According the card drawn , show the necessary informations
     * postcondition: According the card , after player's choices , card's
     * actions done
     *
     * @param c card drawn
     */
    public void showMailCard(Card c) {
        count++;
        String s = "";
        MessageCard a = (MessageCard) c;
        if (c instanceof Advertisment) {
            s = "Advertisment";
        } else if (c instanceof Bill) {
            s = "Bill";
        } else if (c instanceof Charity) {
            s = "Charity";
        } else if (c instanceof PaytheNeighbor) {
            s = "Pay the Neighbor";
        } else if (c instanceof MadMoney) {
            s = "Mad Money";
        } else if (c instanceof MovetoDB) {
            s = "Move to Deal/Buyer";
        }
        Object[] options = {a.getChoice()};
        URL imageUR = cl.getResource("resources/images/" + a.getImage());
        Image im = new ImageIcon(imageUR).getImage();
        im = im.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        JOptionPane p = new JOptionPane();
        int n = JOptionPane.showOptionDialog(this,
                a.getMessage(),
                s,
                JOptionPane.OK_OPTION,
                0,
                new ImageIcon(im),
                options,
                options[0]);
        String s1 = null, s2, s3 = null;
        if (!this.control.getP1().getTurn()) {
            s2 = "Σειρά του Player 1 ";
            switch (s) {
                case "Advertisment":
                    a.Action(null, null, a.getAmount());
                    s1 = "Διαφήμιση";
                    break;
                case "Bill":
                    a.Action(this.control.getP1(), null, a.getAmount());
                    s1 = a.getAmount() + " Euro προστέθηκαν στο χρέος (Bill) σου";
                    break;
                case "Charity":
                    a.CharityAction(this.control.getP1(), this.control.getJack(), a.getAmount());
                    this.setJackpot();
                    s1 = a.getAmount() + " Euro δόθηκαν στο JackPot";
                    break;
                case "Pay the Neighbor":
                    a.Action(this.control.getP1(), this.control.getP2(), a.getAmount());
                    s1 = a.getAmount() + " Euro δόθηκαν στον αντίπαλο";
                    break;
                case "Mad Money":
                    a.Action(this.control.getP2(), this.control.getP1(), a.getAmount());
                    s1 = a.getAmount() + " Euro κερδίθηκαν από τον αντίπαλο";
                    break;
                case "Move to Deal/Buyer":
                    a.MoveAction(this.control.getP1(), control.getBoard().getDays());
                    s1 = "Πήγαινε στην πλησιέστρη θέση Deal/Buyer";
                    break;
                default:
                    break;

            }
            if (this.control.getP1().getGL()) {
                int x = (a.getAmount() - this.control.getP1().getMoney()) + 1000;
                s3 = " Player 1 πήρε " + x + " Euro Δάνειο(Loan).";
            }
        } else {
            s2 = "Σειρά του Player 2 ";
            switch (s) {
                case "Advertisment":
                    s1 = "Διαφήμιση";
                    break;
                case "Bill":
                    a.Action(this.control.getP2(), null, a.getAmount());
                    s1 = a.getAmount() + " Euro προστέθηκαν στο χρέος (Bill) σου";
                    break;
                case "Charity":
                    a.CharityAction(this.control.getP2(), this.control.getJack(), a.getAmount());
                    this.setJackpot();
                    s1 = a.getAmount() + " Euro δόθηκαν στο Jackpot";
                    break;
                case "Pay the Neighbor":
                    a.Action(this.control.getP2(), this.control.getP1(), a.getAmount());
                    s1 = a.getAmount() + " Euro δόθηκαν στον αντίπαλο";
                    break;
                case "Mad Money":
                    a.Action(this.control.getP1(), this.control.getP2(), a.getAmount());
                    s1 = a.getAmount() + " Euro κερδίθηκαν από τον αντίπαλο";
                    break;
                case "Move to Deal/Buyer":
                    a.MoveAction(this.control.getP2(), this.control.getBoard().getDays());
                    s1 = "Πήγαινε στην πλησιέστερη θέση Deal/Buyer";
                    break;
                default:
                    break;
            }
            if (this.control.getP2().getGL()) {
                int x = (a.getAmount() - this.control.getP2().getMoney()) + 1000;
                s3 = " Player 2 πήρε " + x + " Euro Δάνειο (Loan).";
            }
        }
        if (s1.equals("Πήγαινε στην πλησιέστερη θέση Deal/Buyer")) {
            if (control.getP1().getTurn()) {
                a.MoveAction(control.getP1(), control.getBoard().getDays());
                paintPawn(1);
            } else {
                a.MoveAction(control.getP2(), control.getBoard().getDays());
                paintPawn(2);
            }
        }
        control.getMstack().ThrowCard(c);
        if (get2 && count == 2) {
            draw = true;
        } else if (!get2) {
            draw = true;
        }
        this.setInfoText(s2, s1, s3);
        this.setPlayerInfo();
    }

    /**
     * transformer: Show the deal card and its informations postcondition:
     * According the choices of the player, keep it or throw it to rejected
     *
     * @param c card drawn
     */
    public void showDealCard(Card c) {

        String s = "Deal Card";
        Dealcards a = (Dealcards) c;
        Object[] options = {a.getChoice(), a.getChoice1()};
        URL imageUR = cl.getResource("resources/images/" + a.getImage());
        Image img = new ImageIcon(imageUR).getImage();
        img = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        JOptionPane p = new JOptionPane();
        int n = JOptionPane.showOptionDialog(this,
                a.getMessage() + "\nΤιμή Αγοράς: " + a.getBuyPrice() + " Ευρώ \nΤιμή Πώλησης: " + a.getSellPrice() + " Ευρώ \n",
                s,
                JOptionPane.OK_OPTION,
                0,
                new ImageIcon(img),
                options,
                options[0]);

        if (n == 0) {
            control.BuyDeal(c, a.getBuyPrice());
            if (this.control.getP1().getGL()) {
                int x = ((a.getBuyPrice() - this.control.getP1().getMoney()) + 1000);
                setInfoText("Player 1", "Αγόρασες την κάρτα", "Πήρες Δάνειο " + x + " Euro");
            } else if (this.control.getP2().getGL()) {
                int x = ((a.getBuyPrice() - this.control.getP2().getMoney()) + 1000);
                setInfoText("Player 2", "Αγόρασες την κάρτα", "Πήρες Δάνειο" + x + " Euro");
            }
            setPlayerInfo();
        } else {
            control.getDstack().ThrowCard(c);
        }
        draw = true;
    }

    /**
     * transformer: Update both Players information
     */
    void setPlayerInfo() {

        this.Money1.setText("Money: " + this.control.getP1().getMoney() + " Euro");
        this.Loan1.setText("Loan: " + this.control.getP1().GetLoan() + " Euro");
        this.Dept1.setText("Bill Dept: " + this.control.getP1().getbillDept() + " Euro");

        this.Money2.setText("Money: " + this.control.getP2().getMoney() + " Euro");
        this.Loan2.setText("Loan: " + this.control.getP2().GetLoan() + " Euro");
        this.Dept2.setText("Bill Dept: " + this.control.getP2().getbillDept() + " Euro");

    }

    /**
     *
     */
    public class myDesktopPane extends JDesktopPane {

        private Image backImage = null;

        /**
         *
         */
        public myDesktopPane() {

        }

        private myDesktopPane(Image scaledInstance) {
            this.backImage = scaledInstance;

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.backImage, 0, 0, this);
        }
    }

    /**
     * transformer: Paint the pawn of each player according to their position
     *
     * @param x the player that has turn
     */
    void paintPawn(int x) { // thelei ftiaksimof

        if (x == 1) {
            int i = this.control.getP1().getPosition();
            this.pos[i].remove(this.pawn1);
            this.pos[i].repaint();

            i = this.control.getP1().getPosition() + this.control.getP1().getDice().getDiceNum();

            this.control.getP1().setPosition(i);
            this.pos[control.getP1().getPosition()].add(this.pawn1);

        } else if (x == 2) {
            int i = this.control.getP2().getPosition();
            this.pos[i].remove(this.pawn2);
            this.pos[i].repaint();

            i = this.control.getP2().getPosition() + this.control.getP2().getDice().getDiceNum();

            this.control.getP2().setPosition(i);
            this.pos[control.getP2().getPosition()].add(this.pawn2);
        }

    }

    /**
     * transformer: Update Jackpot informations
     */
    void setJackpot() {

        Name[34].setText("JackPot = " + control.getJack().GetPrize() + " Euro");

    }

    /**
     * transformer: Update info box
     *
     * @param s1 first row informations (Which player has turn and months
     * remaining )
     * @param s3 third row informations
     * @param s4 last row informations
     */
    void setInfoText(String s1, String s3, String s4) {
        if (control.getP1().getTurn()) {
            Info1.setText(s1 + " Μήνας1: " + control.getP1().getMonth());
        } else {
            Info1.setText(s1 + " Μήνας2: " + control.getP2().getMonth());
        }
        Info3.setText(s3);
        Info4.setText(s4);

    }

    /**
     * transformer: According the position of the player on the board , are done
     * the necessary actions
     *
     * @param p player that has turn
     */
    void PositionAction(Player p) {
        int i = p.getPosition();
        if (i != 0) {
            draw = false;
        }
        if (i == 0) {
            return;//do nothing at start??
        }
        count = 0;
        BoardPosition[] b = this.control.getBoard().getDays();
        String s = "";
        if (b[i] instanceof DealPos) {
            s = "1";
        } else if (b[i] instanceof MessagePos) {
            s = "2";
        } else if (b[i] instanceof YardSale) {
            s = "3";
        } else if (b[i] instanceof Buyer) {
            s = "4";
        } else if (b[i] instanceof FamilyKazino) {
            s = "5";
        } else if (b[i] instanceof Lottery) {
            s = "6";
        } else if (b[i] instanceof RadioContest) {
            s = "7";
        } else if (b[i] instanceof Sweepstakes) {
            s = "8";
        } else if (b[i] instanceof PayDay) {
            s = "9";
        }

        switch (s) {
            case "1":
                setInfoText(p.getName(), "Θέση Συμφωνίας", "Τράβηξε κάρτα Συμφωνίας");
                break;
            case "2":
                MessagePos a = (MessagePos) b[i];
                if (a.getTwo()) {
                    setInfoText(p.getName(), "Θέση Μηνύματος", "Τράβηξε 2 κάρτες Μηνυμάτος");
                    get2 = true;
                } else {
                    get2 = false;
                    setInfoText(p.getName(), "Θέση Μηνύματος", "Τράβηξε 1 κάρτα Μηνύματος");
                }
                break;
            case "3":
                setInfoText(p.getName(), "Θέση Αγορά με Έκπτωση", "Ρίξε το ζάρι κ πάρε την έκπτωση");
                YardSale c = (YardSale) b[i];
                c.toDo(p);
                p.SetDealCards(this.control.getDstack().DrawCard());
                setInfoText(p.getName(), "Πήρες την πρώτη κάρτα Συμφωνίας", "Έδωσες " + p.getDice().getDiceNum() * 100 + " Ευρώ");
                setPlayerInfo();
                draw = true;
                break;
            case "4":
                setInfoText(p.getName(), "Θέση Αγοραστή", "Πούλησε μια κάρτα Συμφωνίας");
                Buyer d = (Buyer) b[i];
                Card ca = d.toDo(p, 0);//from i to 
                if (ca == null) {
                    setInfoText(p.getName(), "", "Δεν έχεις κάρτες συμφωνίας στην κατοχή σου");
                } else {
                    this.control.getDstack().ThrowCard(ca);
                }
                setPlayerInfo();
                draw = true;
                break;
            case "5":
                setInfoText(p.getName(), "Θέση Καζίνο", "Είσαι τυχερός?");
                FamilyKazino F = (FamilyKazino) b[i];
                if (!F.toDo(p)) {
                    this.control.getJack().AddPrize(500);
                    setInfoText(p.getName(), "Έχασες", "Έδωσες 500 Ευρώ στο JackPot");
                    setJackpot();
                } else {
                    setInfoText(p.getName(), "Κέρδισες", "Πήρες 500 Ευρώ");
                }
                setPlayerInfo();
                draw = true;
                break;
            case "6":
                Object[] options = {"1", "2", "3", "4", "5", "6"};
                JOptionPane pc = new JOptionPane();
                setInfoText(p.getName(), "Θέση Λοταρίας", "Διαλέξτε έναν αριθμό ο καθένας");
                Lottery l = (Lottery) b[i];
                int x1 = JOptionPane.showOptionDialog(this,
                        p.getName() + "Διάλεξε έναν αριθμό",
                        "Λοταρία",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[5]);
                int x2 = JOptionPane.showOptionDialog(this,
                        p.GetOpponent().getName() + "Διάλεξε έναν αριθμό",
                        "Λοταρία",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[5]);
                int x0 = l.toDo(p, p.GetOpponent(), x1 + 1, x2 + 1);
                if (x0 == 1) {
                    setInfoText(p.getName(), "Κέρδισες", "Πήρες 1000 Ευρώ");
                } else if (x0 == 2) {
                    setInfoText(p.GetOpponent().getName(), "Κέρδισες", "Πήρες 1000 Ευρώ");
                }
                setPlayerInfo();
                draw = true;
                break;
            case "7":
                setInfoText(p.getName(), "Θέση Διαγωνισμός Ραδιοφώνου", "Κ οι δύο παίκτες ρίξτε το ζάρι , πρώτα ο " + p.getName());
                RadioContest r = (RadioContest) b[i];
                int xr = r.toDo(p, p.GetOpponent());
                if (xr == 1) {
                    setInfoText(p.getName(), "Κέρδισες", "Πήρες 1000 Ευρώ");
                } else if (xr == 2) {
                    setInfoText(p.GetOpponent().getName(), "Κέρδισες", "Πήρες 1000 Ευρώ");
                }
                setPlayerInfo();
                draw = true;
                break;
            case "8":
                setInfoText(p.getName(), "Θέση Λαχείο", "Ρίξε το ζάρι");
                p.getDice().setThrown();
                Sweepstakes sw = (Sweepstakes) b[i];
                sw.toDo(p);
                setInfoText(p.getName(), "Συγχαρητήρια", "Κέρδισες " + p.getDice().getDiceNum() * 1000 + " Ευρώ");
                setPlayerInfo();
                draw = true;
                break;
            case "9":
                Object[] options0 = {"Πλήρωσε Δάνειο", "Τέλος"};
                JOptionPane pc0 = new JOptionPane();
                PayDay a0 = (PayDay) b[i];
                a0.PayDay(p);
                setInfoText(p.getName(), "Θέση Ημέρα Πληρωμών", "Πήρες 2500 Ευρώ");
                a0.payLoanTaxes(p);

                int x00 = JOptionPane.showOptionDialog(this,
                        p.getName() + "Διάλεξε τι θέλεις να κάνεις",
                        "Ημέρα Πληρωμών",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options0,
                        options0[1]);
                if (x00 == 0) {
                    Object[] options2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                    int x01 = JOptionPane.showOptionDialog(this,
                            p.getName() + "Διάλεξε πόσο θέλεις να πληρώσεις x1000",
                            "Πληρωμή Δανείου",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options2,
                            options2[9]);
                    a0.PayBill(p, x01 * 1000);
                    setInfoText(p.getName(), "Πλήρωσες Φόρο", "Πλήρωσες " + x01 * 1000 + " Ευρώ");
                    setPlayerInfo();
                }
                p.setMonth(-1);

                if (a0.finish(p)) {
                    p.setTurn(false);
                } else {
                    a0.goToStart(p);
                }
                if (control.GameFinished()) {
                    Object[] optionsf = {"Νέο Παιχνίδι", "Έξοδος"};
                    int f = JOptionPane.showOptionDialog(this,
                            "Το παιχνίδι τελείωσε , νικητής είναι ο: " + control.Winner().getName(),
                            "Τέλος Παιχνιδιού",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsf,
                            optionsf[1]);
                    if (f == 0) {
                        new_game();
                    } else {
                        System.exit(0);
                    }
                }
                draw = true;
        }

        p.setTurn(false);
        p.GetOpponent().setTurn(true);

    }

    /**
     * transformer: Let the player choose to bid or not
     *
     * @return the choice(bid) of the player (int)
     */
    private int SundayM() {
        Object[] optionsm = {"Νίκη Γηπεδούχου", "Ισοπαλία", "Νίκη Φιλοξενούμενου", "Δεν θέλω να στοιχηματίσω"};
        int m = JOptionPane.showOptionDialog(this,
                "Πιστεύεις σε Νίκη του Γηπεδούχου ή του Φιλοξενούμενου;",
                "Κυριακάτικος Αγώνας",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsm,
                optionsm[3]);
        switch (m) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return 0;
        }
    }

    /**
     * transformer: Show the result of the player's bid , if he won or lost
     *
     * @param mr true if he won , false otherwise
     */
    private void MatchResult(boolean mr) {
        Object[] optionsm = {"OK"};
        String sr;
        if (mr) {
            sr = "Κέρδισες";
        } else {
            sr = "Έχασες";
        }
        int m = JOptionPane.showOptionDialog(this,
                sr,
                "Αποτέλεσμα Στοιχήματος",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                optionsm,
                optionsm[0]);
    }

    /**
     * transformer: Creates a new game
     */
    private void new_game() {
        this.setVisible(false);
        GUI game = new GUI();
        game.InitializePane();
    }

    private class DiceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (control.getP1().getTurn() && !control.getP1().finished()) {
                control.getP1().getDice().RollDice();
                control.getP1().getDice().setThrown();
                setDiceImg(control.getP1().getDice().getDiceNum(), 1);

                if (control.getP1().getDice().getDiceNum() == 6) {
                    setInfoText("Player 1 κέρδισες τα χρήματα από το JackPot", "Έριξες το ζάρι. Έφερε " + control.getP1().getDice().getDiceNum(), "Πήγες στην θέση: " + (control.getP1().getPosition() + control.getP1().getDice().getDiceNum()));
                    control.getP1().setMoney(control.getJack().winPrize());
                } else {
                    setInfoText("Player 1", "Έριξες το ζάρι. Έφερε " + control.getP1().getDice().getDiceNum(), "Πήγες στην θέση: " + (control.getP1().getPosition() + control.getP1().getDice().getDiceNum()));
                }
                setJackpot();
                paintPawn(1);
                if (control.getBoard().Sunday(control.getP1().getPosition())) {
                    int x = SundayM();
                    int x1 = 0;
                    switch (x) {
                        case 1:
                            x1 = 1;
                            MatchResult(control.SMatch(control.getP1(), x1));
                            break;
                        case 2:
                            x1 = 3;
                            MatchResult(control.SMatch(control.getP1(), x1));
                            break;
                        case 3:
                            x1 = 5;
                            MatchResult(control.SMatch(control.getP1(), x1));
                            break;
                        default:
                            break;
                    }

                }
                PositionAction(control.getP1());

            } else {
                control.getP2().getDice().RollDice();
                control.getP2().getDice().setThrown();
                setDiceImg(control.getP2().getDice().getDiceNum(), 2);
                if (control.getP2().getDice().getDiceNum() == 6) {
                    setInfoText("Player 2 κέρδισες τα χρήματα από το JackPot", "Έριξες το ζάρι. Έφερε " + control.getP2().getDice().getDiceNum(), "Πήγες στην θέση: " + (control.getP2().getPosition() + control.getP2().getDice().getDiceNum()));
                    control.getP2().setMoney(control.getJack().winPrize());
                } else {
                    setInfoText("Player 2", "Έριξες το ζάρι. Έφερε " + control.getP2().getDice().getDiceNum(), "Πήγες στην θέση: " + (control.getP2().getPosition() + control.getP2().getDice().getDiceNum()));
                }
                setJackpot();
                paintPawn(2);
                if (control.getBoard().Sunday(control.getP2().getPosition())) {
                    int x = SundayM();
                    int x1 = 0;
                    switch (x) {
                        case 1:
                            x1 = 1;
                            MatchResult(control.SMatch(control.getP2(), x1));
                            break;
                        case 2:
                            x1 = 3;
                            MatchResult(control.SMatch(control.getP2(), x1));
                            break;
                        case 3:
                            x1 = 5;
                            MatchResult(control.SMatch(control.getP2(), x1));
                            break;
                        default:
                            break;
                    }
                }
                PositionAction(control.getP2());

            }
        }
    }

    private class CardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getName().equals("Mail")) {
                if (control.getMstack().isEmpty()) {
                    control.getMstack().ShuffleStack();
                }
                Card c = control.getMstack().DrawCard();
                showMailCard(c);
                control.getMstack().ThrowCard(c);
            } else if (button.getName().equals("Deal")) {
                if (control.getDstack().isEmpty()) {
                    control.getDstack().ShuffleStack();
                }
                Card c = control.getDstack().DrawCard();
                showDealCard(c);
            }
        }
    }

    private class NewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("New game");
            Object[] options = {"Ναι", "Όχι"};
            JOptionPane pc = new JOptionPane();
            int n = pc.showOptionDialog(null,
                    "Θέλετε σίγουρα να ξεκινήσετε νέο παιχνίδι;",
                    "Νέο Παιχνίδι",
                    JOptionPane.OK_OPTION,
                    0,
                    null,
                    options,
                    options[1]);
            if (n == 0) {
                new_game();
            }
        }

    }

}
