import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Component.*;
import javax.swing.JComponent.*;

public class KryptoGUI extends JFrame implements ActionListener 
{
    private Container contentPane;
    private Krypto game;
    private JPanel backgroundPanel; 
    private JPanel titlePanel, namePanel, hintPanel;
    private JPanel cardPanel, targetPanel;
    private JPanel gamePanel, gamePanelCtr;
    private JLabel zebraLabel, sumoLabel,kryptoKrack;
    private JTextField target, targetAmt, equals, total;
    private ImageIcon zebraIcon, sumoIcon, kryptoIcon;
    private JButton dealButton, hintButton, solveButton;
    private JButton cardOne, cardTwo, cardThree, cardFour, cardFive;
    private JButton selectOne, selectTwo, selectThree, selectFour, selectFive;
    private JComboBox operatorJCB1, operatorJCB2, operatorJCB3, operatorJCB4;
    private String operators[] = {"+", "-", "*", "/"};
    private final static int OPERATORS = 4;
    private String c1, c2, c3, c4, c5, s1, s2, s3, s4, s5;
    private int order =0;
   
   
   public KryptoGUI (String title)
   {
        buildGUI();
        setTitle(title);
        setSize(600,400);	
        setVisible(true);		
        setResizable(false);
        setLocation(75,15);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }// end GuessTheNumberGUI
    
   private void buildGUI()
   {
        contentPane = getContentPane(); 
        buildBackgroundPanel();
        buildTitlePanel();
        buildCardPanel();
        buildGamePanel();
        testGetters();
        doDeal();
   }  
   
    private void buildBackgroundPanel()
   {
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setBackground(Color.yellow);
        //fix zebraLabel*******************************************
        zebraIcon = new ImageIcon("C:/Users/Karin/Documents/NetBeansProjects"
                + "/Krypto/images/bluewavy.png");        
        zebraLabel = new JLabel(zebraIcon);
        backgroundPanel.add(zebraLabel);
        contentPane.add("Center", backgroundPanel);
   }

    private void buildTitlePanel()
    {
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        //titlePanel.setOpaque(false);
        titlePanel.setBackground(Color.blue);
        backgroundPanel.add("North", titlePanel);
        
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        namePanel.setBackground(Color. blue);
        kryptoKrack = new JLabel(kryptoIcon);
        kryptoKrack = new JLabel(new ImageIcon("C:/Users/Karin/Documents/"
                + "NetBeansProjects/Krypto/images/krackingKryptoblue.jpg"));
        namePanel.add(kryptoKrack);
        titlePanel.add("West", namePanel);
                
        hintPanel = new JPanel();
        hintPanel.setLayout(new FlowLayout());
        hintPanel.setBackground(Color.blue);
        titlePanel.add("East", hintPanel);
        dealButton = new JButton("deal");
        dealButton.setBackground(Color.black);
        dealButton.setForeground(Color.yellow);
        dealButton.addActionListener(this);
        dealButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        hintButton = new JButton("hint");
        hintButton.setBackground(Color.black);
        hintButton.setForeground(Color.yellow);
        hintButton.addActionListener(this);
        hintButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        solveButton = new JButton("solve");
        solveButton.setBackground(Color.black);
        solveButton.setForeground(Color.yellow);
        solveButton.addActionListener(this);
        solveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        hintPanel.add(hintButton);
        hintPanel.add(dealButton);
        hintPanel.add(solveButton);  
   }
    
    private void buildCardPanel()
    {
        cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout());
        cardPanel.setBackground(Color.blue);
        //cardPanel.setOpaque(false);
        backgroundPanel.add("Center", cardPanel);
        
        Box.createRigidArea(new Dimension(0,100));
        cardPanel.add(Box.createRigidArea(new Dimension(0,100)));
        
        cardOne = new JButton("cardOne");
        cardOne.setBackground(Color.black);
        cardOne.setForeground(Color.yellow);
        cardOne.addActionListener(this);
        cardOne.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cardTwo = new JButton("cardTwo");
        cardTwo.setBackground(Color.black);
        cardTwo.setForeground(Color.yellow);
        cardTwo.addActionListener(this);
        cardTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cardThree = new JButton("cardThree");
        cardThree.setBackground(Color.black);
        cardThree.setForeground(Color.yellow);
        cardThree.addActionListener(this);
        cardThree.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        //cardFour = new JButton("4");
        //cardFour.setBackground(Color.black);
        //cardFour.setForeground(Color.yellow);
        //cardFour.addActionListener(this);
        //cardFive = new JButton("5");
        //cardFive.setBackground(Color.black);
        //cardFive.setForeground(Color.yellow);
        //cardFive.addActionListener(this);
        
        cardPanel.add(cardOne);
        cardPanel.add(cardTwo);
        cardPanel.add(cardThree);
        //cardPanel.add(cardFour);
        //cardPanel.add(cardFive);
        
        targetPanel = new JPanel();
        targetPanel.setLayout(new BorderLayout());
        targetPanel.setBackground(Color.blue);
        target = new JTextField("Target");
        target.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        target.setEditable(false);
        target.setBackground(Color.blue);
        target.setForeground(Color.white);
        //target = new JTextField(game.getEquationAnswer()); //not working yet
        target.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        targetAmt = new JTextField("43");
        targetAmt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        targetAmt.setEditable(false);
        targetAmt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        targetAmt.setBackground(Color.orange);
        targetPanel.add("North", target);
        
        Box.createRigidArea(new Dimension(50,50));
        targetPanel.add(Box.createRigidArea(new Dimension(50,50)));
        
        targetPanel.add("Center", targetAmt);
        cardPanel.add(targetPanel);   
    }
    
    private void buildGamePanel()
    {
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(Color.blue);
        
        gamePanelCtr = new JPanel();
        gamePanelCtr.setLayout(new FlowLayout());
        gamePanelCtr.setBackground(Color.blue);
        
        selectOne = new JButton("One");
        selectOne.setBackground(Color.black);
        selectOne.setForeground(Color.yellow);
        selectOne.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        selectOne.addActionListener(this);
        selectTwo = new JButton("Two");
        selectTwo.setBackground(Color.black);
        selectTwo.setForeground(Color.yellow);
        selectTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
        selectTwo.addActionListener(this);
        selectThree = new JButton("Three");
        selectThree.setBackground(Color.black);
        selectThree.setForeground(Color.yellow);
        selectThree.setFont(new Font("Comic Sans MS", Font.BOLD, 15));       
        selectThree.addActionListener(this);
        selectFour = new JButton("Four");
        selectFour.setBackground(Color.black);
        selectFour.setForeground(Color.yellow);
        selectFour.setFont(new Font("Comic Sans MS", Font.BOLD, 15));       
        selectFour.addActionListener(this);
        selectFive = new JButton("Five");
        selectFive.setBackground(Color.black);
        selectFive.setForeground(Color.yellow);
        selectFive.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
        selectFive.addActionListener(this);
        equals = new JTextField("=");
        equals.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        equals.setCaretColor(black);
        equals.setEditable(false);
        equals.setBackground(Color.black);
        equals.setForeground(Color.yellow);
        equals.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
        equals.setBackground(Color.blue);
        equals.setForeground(Color.yellow);
        total = new JTextField("0");
        total.setEditable(false);
        total.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
        total.setBackground(Color.orange);
        
        operatorJCB1 = new JComboBox(operators);
        //operatorJCB1.setBackground(Color.black);
        operatorJCB1.addActionListener(this);
        operatorJCB2 = new JComboBox(operators);
        operatorJCB2.addActionListener(this);
        operatorJCB3 = new JComboBox(operators);
        operatorJCB3.addActionListener(this);
        operatorJCB4 = new JComboBox(operators);
        operatorJCB4.addActionListener(this);
        
        gamePanelCtr.add(selectOne);
        gamePanelCtr.add(operatorJCB1);
        gamePanelCtr.add(selectTwo);
        gamePanelCtr.add(operatorJCB2);
        gamePanelCtr.add(selectThree);
        //gamePanelCtr.add(operatorJCB3);
        //gamePanelCtr.add(selectFour);
        //gamePanelCtr.add(operatorJCB4);
        //gamePanelCtr.add(selectFive);
        gamePanelCtr.add(equals);
        gamePanelCtr.add(total);
        
        gamePanel.add("Center", gamePanelCtr);
        
        Box.createRigidArea(new Dimension(150,150));
        //gamePanel.add(Box.createRigidArea(new Dimension(150,150)));
        
        sumoLabel = new JLabel(sumoIcon);
        sumoLabel = new JLabel(new ImageIcon("C:/Users/Karin/Documents/"
                + "NetBeansProjects/Krypto/images/mchammer.gif"));
        gamePanel.add("South", sumoLabel);
        
        backgroundPanel.add("South", gamePanel);   
    }
    
    //************************************************** 
    
    public void doHint()
    {
        System.out.println("This is where hint button function goes.");
    }
    
    public void doDeal()
    {
        Krypto game = new Krypto();
        game.Krypto();
        cardOne.setText(game.getCardOne());
        cardTwo.setText(game.getCardTwo());
        cardThree.setText(game.getCardThree());
        total.setText(game.getEquationAnswer());//not setting it correctly
        targetAmt.setText(game.getEquationAnswer());
        System.out.println("This is where deal button function goes.");
        resetGUI();
        
    }
    public void resetGUI()
    {
        selectOne.setText("0");
        selectTwo.setText("0");
        selectThree.setText("0");
        order=0;
        cardOne.setEnabled(true);
        cardTwo.setEnabled(true);
        cardThree.setEnabled(true);
    }
        
    public void doSolve()
    {
        System.out.println("This is where solve button function goes.");
    }
    
    //*****************************************************

    public void doCard(ActionEvent e)
    {
        String label;
        System.out.println("card functionality");
        label=((JButton)e.getSource()).getText();
        System.out.println(label);
        if(order==0)
        {
            selectOne.setText(label);
            ((JButton)e.getSource()).setEnabled(false);
            
        }
        else if(order==1)
        {
            selectTwo.setText(label);
            ((JButton)e.getSource()).setEnabled(false);
        }
        else if(order>=2)
        {
            selectThree.setText(label);
            ((JButton)e.getSource()).setEnabled(false);
        }
        order++;
        updateTotal();
        
    }
    public void updateTotal() //need a way to read combo boxes and use the symbol as an equation not just a string. gonna have to do 16 if statements   
    {
        
    }
    
    //***************************************************** gamePanel Cards
    
    public void doSelectOne()
    {
        System.out.println("selectOne functionality");
    }
       
    public void doSelectTwo()
    {
        System.out.println("selectTwo functionality");
    }

    public void doSelectThree()
    {
        System.out.println("selectThree functionality");
    }

    public void doSelectFour()
    {
        System.out.println("selectFour functionality");
    }

    public void doSelectFive()
    {
        System.out.println("selectFive functionality");
    }

    //***********************************************operator JComboBoxes
    
    public void doSelectOperator1()
    {
        System.out.println("Select operator1 functionality here.");
    }
 
    public void doSelectOperator2()
    {
        System.out.println("Select operator2 functionality here.");
    }    
 
    public void doSelectOperator3()
    {
        System.out.println("Select operator3 functionality here.");
    }
    
    public void doSelectOperator4()
    {
        System.out.println("Select operator4 functionality here.");
    }   
  
    //**************************************actionListener activities
    
    public void actionPerformed(ActionEvent e)
    {
        //local variables declared here
        
   
        if (e.getSource() == hintButton)
        {
            doHint();
        }
        else if (e.getSource() == dealButton)
        {
           doDeal();
        }      
        else if (e.getSource() == solveButton)
        {
           doSolve();
        }  
        else if (e.getSource() == cardOne)
        {
            doCard(e);
        }
        else if (e.getSource() == cardTwo)
        {
           doCard(e);
        }      
        else if (e.getSource() == cardThree)
        {
           doCard(e);
        }   
        else if (e.getSource() == selectOne)
        {
           doSelectOne(); 
        }
        else if (e.getSource() == selectTwo)
        {
           doSelectTwo(); 
        }
        else if (e.getSource() == selectThree)
        {
           doSelectThree(); 
        }
        else if (e.getSource() == selectFour)
        {
            doSelectFour(); 
        }
        else if (e.getSource() == selectFive)
        {
            doSelectFive(); 
        }        
        else if (e.getSource() == operatorJCB1)
        {
            doSelectOperator1(); 
        }     
        else if (e.getSource() == operatorJCB2)
        {
            doSelectOperator2(); 
        }     
        else if (e.getSource() == operatorJCB3)
        {
            doSelectOperator3(); 
        }     
        else if (e.getSource() == operatorJCB4)
        {
            doSelectOperator4(); 
        }   
        else
        {
        //
        }
        
    }//end ActionPerformed
    
    public void testGetters()
    {
        //not working yet
        //game.getCardOne();
        //c1 = game.getCardOne();
        
    }
    
    public void paintComponent(Graphics g)
    {
        //not working yet
        super.paintComponents(g);
        Image bkgrnd = Toolkit.getDefaultToolkit().getImage("images/bluewavy.png");
        g.drawImage(bkgrnd, 0, 0, this);
        requestFocusInWindow();      
    }
    
}//end KryptoGUI

