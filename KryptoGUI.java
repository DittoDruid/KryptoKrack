/* Authors: Karin Martin, Zack Schiding, Patrick Leeper
   IST311 Group Project
   Due Date: 12/6/17
   zss5081@psu.edu, kur164@psu.edu, leeper@psu.edu

   KryptoGUI.java
    
   Overview:
   ----------
   The purpose of the KryptoGUI is to build the GUI components of
   the Krypto game and to control the actionListeners of the components..
      
   One method sets a String title on the JFrame and another adds the 
   GUI components. Four methods build the Background, Title, Card, and Game panels.
   Four methods provide functionality to the instructions, hint, solve and deal
   buttons. One method resets the GUI and another updates the card total. Another 
   method provides the logic behind the cards and a final method defines the 
   actions to be performed for the twelve separate component listeners.
	
   Attributes:
   - contentPane: Container
   - game: Krypto
   - backgroundPanel, titlePanel, namePanel: JPanel
   - hintPanel, cardPanel, targetPanel: JPanel
   - gamePanel, gamePanelCtr: JPanel
   - hammerLabel, kryptoKrack: JLabel
   - kryptoKrack: JLabel
   - target, targetAmt, equals, total: JTextField
   - hammerIcon,kryptoIcon: ImageIcon
   - instructionButton, dealButton, hintButton, solveButton: JButton
   - cardOne, cardTwo, cardThree: JButton
   - selectOne, selectTwo, selectThree: JButton
   - operatorJCB1, operatorJCB2: JComboBox
   - operators[], userEquation[]: String
   - order[]: boolean
   - df: DecimalFormat
 
   Methods:
   + KryptoGUI(String)
   - buildGUI()
   - buildBackgroundPanel()
   - buildTitlePanel()
   - buildCardPanel()
   - buildGamePanel()
   + instructions()
   + doHint()
   + doDeal()
   + doSolve()
   + resetGUI()
   + doCard(ActionEvent)
   + updateTotal()
   + actionPerformed(ActionEvent)
 */

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Objects;

public class KryptoGUI extends JFrame implements ActionListener 
{
   private Container contentPane;
   private JPanel backgroundPanel, titlePanel, namePanel, hintPanel;
   private JPanel cardPanel, targetPanel, gamePanel, gamePanelCtr;
   private JLabel hammerLabel,kryptoKrack;
   private JTextField target, targetAmt, equals, total;
   private ImageIcon hammerIcon,kryptoIcon;
   private JButton instructionButton, dealButton, hintButton, solveButton;
   private JButton cardOne, cardTwo, cardThree;
   private JButton selectOne, selectTwo, selectThree;
   private JComboBox operatorJCB1, operatorJCB2;
   private String operators[] = {"+", "-", "*", "/"};
   private boolean order[] = {false,false,false};
   private String userEquation[]={"null","null","null","null","null"};
   Krypto game = new Krypto();
   private DecimalFormat df = new DecimalFormat("#");  
  
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
      doDeal();
   }//end buildGUI
  
   private void buildBackgroundPanel()
   {
      backgroundPanel = new JPanel();
      backgroundPanel.setLayout(new BorderLayout());
      backgroundPanel.setBackground(new Color(0,0,255));
      contentPane.add("Center", backgroundPanel);
   }//end buildBackgroundPanel

   private void buildTitlePanel()
   {
      titlePanel = new JPanel();
      titlePanel.setLayout(new BorderLayout());
      titlePanel.setBackground(new Color(0,0,255));
      backgroundPanel.add("North", titlePanel);
      
      namePanel = new JPanel();
      namePanel.setLayout(new FlowLayout());
      namePanel.setBackground(new Color(0,0,255));
      kryptoKrack = new JLabel(kryptoIcon);
      kryptoKrack = new JLabel(new ImageIcon("images/krackingkrypto.png"));
      namePanel.add(kryptoKrack);
      titlePanel.add("West", namePanel);
                 
      hintPanel = new JPanel();
      hintPanel.setLayout(new FlowLayout());
      hintPanel.setBackground(new Color(0,0,255));
      titlePanel.add("East", hintPanel);
      
      instructionButton = new JButton("instructions");
      instructionButton.setBackground(Color.black);
      instructionButton.setForeground(Color.yellow);
      instructionButton.setFocusPainted(false);
      instructionButton.addActionListener(this);
      instructionButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
      dealButton = new JButton("deal");
      dealButton.setBackground(Color.black);
      dealButton.setForeground(Color.yellow);
      dealButton.setFocusPainted(false);
      dealButton.addActionListener(this);
      dealButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
      hintButton = new JButton("hint");
      hintButton.setBackground(Color.black);
      hintButton.setForeground(Color.yellow);
      hintButton.setFocusPainted(false);
      hintButton.addActionListener(this);
      hintButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
      solveButton = new JButton("solve");
      solveButton.setBackground(Color.black);
      solveButton.setForeground(Color.yellow);
      solveButton.setFocusPainted(false);
      solveButton.addActionListener(this);
      solveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      
      hintPanel.add(instructionButton);
      hintPanel.add(dealButton);
      hintPanel.add(hintButton);      
      hintPanel.add(solveButton);  
   }//end buildTitlePanel
   
   private void buildCardPanel()
   {
      cardPanel = new JPanel();
      cardPanel.setLayout(new FlowLayout());
      cardPanel.setBackground(new Color(0,0,255));
      backgroundPanel.add("Center", cardPanel);
      
      Box.createRigidArea(new Dimension(0,100));
      cardPanel.add(Box.createRigidArea(new Dimension(0,100)));
      
      cardOne = new JButton("cardOne");
      cardOne.setBackground(Color.black);
      cardOne.setForeground(Color.yellow);
      cardOne.setFocusPainted(false);
      cardOne.addActionListener(this);
      cardOne.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
      cardTwo = new JButton("cardTwo");
      cardTwo.setBackground(Color.black);
      cardTwo.setForeground(Color.yellow);
      cardTwo.setFocusPainted(false);
      cardTwo.addActionListener(this);
      cardTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
      cardThree = new JButton("cardThree");
      cardThree.setBackground(Color.black);
      cardThree.setForeground(Color.yellow);
      cardThree.setFocusPainted(false);
      cardThree.addActionListener(this);
      cardThree.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
      
      cardPanel.add(cardOne);
      cardPanel.add(cardTwo);
      cardPanel.add(cardThree);
      
      targetPanel = new JPanel();
      targetPanel.setLayout(new BorderLayout());
      targetPanel.setBackground(new Color(0,0,255));
      targetPanel.setBorder(BorderFactory.createTitledBorder(""));
      target = new JTextField("Target");
      target.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      target.setEditable(false);
      target.setBackground(Color.blue);
      target.setForeground(Color.white);
      target.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      targetAmt = new JTextField("");
      //targetAmt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      targetAmt.setEditable(false);
      targetAmt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
      targetAmt.setBackground(Color.orange);
      targetPanel.add("North", target);
      
      cardPanel.add(Box.createRigidArea(new Dimension(25,25)));
      
      targetPanel.add("Center", targetAmt);
      cardPanel.add(targetPanel);   
   }//end buildCardPanel
   
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
      selectOne.setFocusPainted(false);
      selectOne.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
      selectOne.addActionListener(this);
      
      selectTwo = new JButton("Two");
      selectTwo.setBackground(Color.black);
      selectTwo.setForeground(Color.yellow);
      selectTwo.setFocusPainted(false);
      selectTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
      selectTwo.addActionListener(this);
      
      selectThree = new JButton("Three");
      selectThree.setBackground(Color.black);
      selectThree.setForeground(Color.yellow);
      selectThree.setFocusPainted(false);
      selectThree.setFont(new Font("Comic Sans MS", Font.BOLD, 15));       
      selectThree.addActionListener(this);
       
      equals = new JTextField("=");
      equals.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      equals.setCaretColor(black);
      equals.setEditable(false);
      equals.setBackground(Color.black);
      equals.setForeground(Color.yellow);
      equals.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
      equals.setBackground(new Color(0,0,255));
      equals.setForeground(Color.yellow);
      
      total = new JTextField("0");
      total.setEditable(false);
      total.setFont(new Font("Comic Sans MS", Font.BOLD, 15));        
      total.setBackground(Color.orange);
      
      //Border border = BorderFactory.createLineBorder(Color.red, 15);
      //UIManager.put("ComboBox.border", border);
          
      operatorJCB1 = new JComboBox(operators);
      operatorJCB1.setBackground(Color.blue);
      operatorJCB1.setForeground(Color.yellow);
      operatorJCB1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      operatorJCB1.addActionListener(this);
      
      operatorJCB2 = new JComboBox(operators);
      operatorJCB2.setBackground(Color.blue);
      operatorJCB2.setForeground(Color.yellow);
      operatorJCB2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      operatorJCB2.addActionListener(this);
    
      gamePanelCtr.add(selectOne);
      gamePanelCtr.add(operatorJCB1);
      gamePanelCtr.add(selectTwo);
      gamePanelCtr.add(operatorJCB2);
      gamePanelCtr.add(selectThree);
      gamePanelCtr.add(equals);
      gamePanelCtr.add(total);
      
      gamePanel.add("Center", gamePanelCtr);
      
      Box.createRigidArea(new Dimension(150,150));
      
      hammerLabel = new JLabel(hammerIcon);
      hammerLabel = new JLabel(new ImageIcon("images/mchammer.gif"));
      gamePanel.add("South", hammerLabel);
      
      backgroundPanel.add("South", gamePanel);   
   }//end buildGamePanel
   
   public void instructions()
   {
      JOptionPane.showMessageDialog(null, "Instructions of the game.\n\n-Combine three number cards using the four arithmetic \n operations (+, -, *, /) to arrive at a \"target\" number.\n-Deal Button resets the game. \n-Hint button shows the correct operators of the equation. \n-Solve Button solves the equation. \n-Dropboxes make the the operators. \n\n*Note* This game uses integer division!");
   }   
    
   public void doHint()
   {
      String[] compEquation = game.getEquation();

      if(compEquation[1]=="+")
      {
          operatorJCB1.setSelectedIndex(0);
      }
      else if(compEquation[1]=="-")
      {
          operatorJCB1.setSelectedIndex(1);
      }
      else if(compEquation[1]=="*")
      {
          operatorJCB1.setSelectedIndex(2);
      }
      else if(compEquation[1]=="/")
      {
          operatorJCB1.setSelectedIndex(3);
      }
      if(compEquation[3]=="+")
      {
          operatorJCB2.setSelectedIndex(0);
      }
      else if(compEquation[3]=="-")
      {
          operatorJCB2.setSelectedIndex(1);
      }
      else if(compEquation[3]=="*")
      {
          operatorJCB2.setSelectedIndex(2);
      }
      else if(compEquation[3]=="/")
      {
          operatorJCB2.setSelectedIndex(3);
      }

   }//end doHint
   
   public void doDeal()
   {
      game.Krypto();
      cardOne.setText(game.getCardOne());
      cardTwo.setText(game.getCardTwo());
      cardThree.setText(game.getCardThree());
      total.setText("0");
      targetAmt.setText(game.getEquationAnswer());
      resetGUI();
   }// end doDeal
        
   public void doSolve()
   {
      doHint();
      String[] compEquation = game.getEquation();
      selectOne.setText(compEquation[0]);
      selectTwo.setText(compEquation[2]);
      selectThree.setText(compEquation[4]);
      updateTotal();    
   }// end doSolve
   
   public void resetGUI()
   {
      selectOne.setText("0");
      selectTwo.setText("0");
      selectThree.setText("0");
      
      order[0]=false;
      order[1]=false;
      order[2]=false;
      
      cardOne.setEnabled(true);
      cardTwo.setEnabled(true);
      cardThree.setEnabled(true);
   }//end resetGUI

   public void doCard(ActionEvent e)
   {
      String label;
      label=((JButton)e.getSource()).getText();
      System.out.println(label);
      if(order[0]==false)
      {
         selectOne.setText(label);
         ((JButton)e.getSource()).setEnabled(false);
         order[0]=true;
      }
      else if(order[1]==false)
      {
         selectTwo.setText(label);
         ((JButton)e.getSource()).setEnabled(false);
         order[1]=true;
      }
      else if(order[2]==false)
      {
         selectThree.setText(label);
         ((JButton)e.getSource()).setEnabled(false);
         order[2]=true;
      }
      if(order[0]==true&&order[1]==true&&order[2]==true)
         {
            updateTotal();
         }
   }// end doCard
    
   public void updateTotal()
   {
    String answer="";
    double aurene,firstNum,secondNum,thirdNum;
    aurene=0;
    firstNum=Double.parseDouble(selectOne.getText());
    secondNum=Double.parseDouble(selectTwo.getText());
    thirdNum=Double.parseDouble(selectThree.getText());
    answer=selectOne.getText()+operatorJCB1.getSelectedItem()+selectTwo.getText()+operatorJCB2.getSelectedItem()+selectThree.getText();
    System.out.println(answer);
    if(operatorJCB1.getSelectedItem()=="+")
    {
       if(operatorJCB2.getSelectedItem()=="+")
       {
           aurene=firstNum+secondNum+thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="-")
       {
           aurene=firstNum+secondNum-thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="*")
       {
           aurene=(firstNum+secondNum)*thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="/")
       {
           aurene=(firstNum+secondNum)/thirdNum;
       }
    }
    else if(operatorJCB1.getSelectedItem()=="-")
    {
       if(operatorJCB2.getSelectedItem()=="+")
       {
           aurene=firstNum-secondNum+thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="-")
       {
           aurene=firstNum-secondNum-thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="*")
       {
           aurene=(firstNum-secondNum)*thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="/")
       {
           aurene=(firstNum-secondNum)/thirdNum;
       }
    }
    else if(operatorJCB1.getSelectedItem()=="*")
    {
       if(operatorJCB2.getSelectedItem()=="+")
       {
           aurene=firstNum*secondNum+thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="-")
       {
           aurene=firstNum*secondNum-thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="*")
       {
           aurene=firstNum*secondNum*thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="/")
       {
           aurene=firstNum*secondNum/thirdNum;
       }
    }
    else if(operatorJCB1.getSelectedItem()=="/")
    {
       if(operatorJCB2.getSelectedItem()=="+")
       {
           aurene=firstNum/secondNum+thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="-")
       {
           aurene=firstNum/secondNum-thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="*")
       {
           aurene=firstNum/secondNum*thirdNum;
       }
       else if(operatorJCB2.getSelectedItem()=="/")
       {
           aurene=firstNum/secondNum/thirdNum;
       }
    }
    total.setText(String.valueOf(df.format(aurene)));
    if(Objects.equals(Double.valueOf(total.getText()),
            Double.valueOf(targetAmt.getText())))
    {
        wonIt();
    }
   }// end updateTotal
    
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == instructionButton)
      {
         instructions();
      }
   
      if (e.getSource() == hintButton)
      {
         doHint();
         JOptionPane.showMessageDialog(null, "Operators have been provided for you.");
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
          
         if(selectOne.getText() == cardOne.getText())
         {
             cardOne.setEnabled(true);
         }
         else if(selectOne.getText() == cardTwo.getText())
         {
             cardTwo.setEnabled(true);
         }
         else if(selectOne.getText() == cardThree.getText())
         {
             cardThree.setEnabled(true);
         }
         selectOne.setText("0");
         
         order[0]=false;
         if(order[0]==true&&order[1] == true&&order[2]==true)
         {
            updateTotal();
         }
                
      }
      else if (e.getSource() == selectTwo)
      {
         
         if(selectTwo.getText()==cardOne.getText())
         {
             cardOne.setEnabled(true);
         }
         else if(selectTwo.getText()==cardTwo.getText())
         {
             cardTwo.setEnabled(true);
         }
         else if(selectTwo.getText()==cardThree.getText())
         {
             cardThree.setEnabled(true);
         }
         selectTwo.setText("0");
         order[1]=false;
         if(order[0]==true&&order[1]==true&&order[2]==true)
         {
            updateTotal();
         }
         
      }
      else if (e.getSource() == selectThree)
      {
         
         if(selectThree.getText()==cardOne.getText())
         {
             cardOne.setEnabled(true);
         }
         else if(selectThree.getText()==cardTwo.getText())
         {
             cardTwo.setEnabled(true);
         }
         else if(selectThree.getText()==cardThree.getText())
         {
             cardThree.setEnabled(true);
         }
         selectThree.setText("0");
         order[2]=false;
         if(order[0]==true&&order[1]==true&&order[2]==true)
         {
            updateTotal();
         }
      }
      else if (e.getSource() == operatorJCB1)
      {
         if(order[0]==true&&order[1]==true&&order[2]==true)
         {
            updateTotal();
         }
      }     
      else if (e.getSource() == operatorJCB2)
      {
         if(order[0]==true&&order[1]==true&&order[2]==true)
         {
            updateTotal();
         } 
      }   
   }//end ActionPerformed
   
   public void wonIt()
   {
      JOptionPane.showMessageDialog(null, "You won!!!");
   }  
}//end KryptoGUI