/* Authors: Zack Schiding, Karin Martin, Patrick Leeper
   IST311 Group Project
   Due Date: 12/6/17
   zss5081@psu.edu, kur164@psu.edu, leeper@psu.edu

   Krypto.java
    
   Overview:
   ----------
   The purpose of the Krypto class it to:
      Generate three "card" numbers between 1-100 
      Generate answer number that matches the three cards through addition,
            subtraction, multiplication or division.
      
   One method sets a value flag to false and runs a verify and generate number method
   while false. Another method verifies the card numbers and their possible equations.
   Three methods return the card numbers as strings to the GUI. And two more methods deal
   getting the equation and the equation total.
 

   Attributes:
   - cardOne: Double
   - cardTwo: Double
   - cardThree: Double
   - equationAnwer: Double
   - c1: String
   - c2: String
   - c3: String
   - eA: String
   + equation[]: String
   + df: DecimalFormat

   Methods:
   + Krypto()
   + generateNumber()
   + verify()
   + getCardOne(): String
   + getCardTwo(): String
   + getCardThree(): String
   + getEquationAnswer(): String
   + getEquation(): String
*/

import java.util.*;
import java.text.DecimalFormat;

public class Krypto {

   private double cardOne,cardTwo,cardThree, equationAnswer;
   private String c1, c2, c3, eA; 
   public boolean valid;
   public String equation[]={"null","null","null","null","null"};
   public DecimalFormat df = new DecimalFormat("#");
           
   public void Krypto()
   {
      valid=false;
      while(valid==false)
      {
         generateNumber();
         verify();
      }
   }// end Krypto
   
   /** generate numbers for cards 1, 2 and 3, and equation answer */
   
   public void generateNumber()
   {
      Random rand = new Random();
      cardOne = rand.nextInt(100)+1;
      cardTwo = rand.nextInt(100)+1;
      cardThree = rand.nextInt(100)+1;
      equationAnswer = rand.nextInt(100)+1;      
   }// end generateNumber
   
   /** verify calculations */
   
   public void verify()
   {
      if(cardOne+cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"+"+cardTwo+"+"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"+",
             String.valueOf(cardTwo),"+",String.valueOf(cardThree)};
      }
      else if(cardOne+cardTwo-cardThree==equationAnswer)
      {
         valid=true;   
         System.out.println(cardOne+"+"+cardTwo+"-"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"+",
             String.valueOf(cardTwo),"-",String.valueOf(cardThree)};
      }
      else if(cardOne-cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"+"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"-",
             String.valueOf(cardTwo),"+",String.valueOf(cardThree)};
      }
      else if(cardOne-cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"-"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"-",
             String.valueOf(cardTwo),"-",String.valueOf(cardThree)};
      }
      else if((cardOne+cardTwo)*cardThree==equationAnswer)
      {
         valid=true;   
         System.out.println(cardOne+"+"+cardTwo+"*"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"+",
             String.valueOf(cardTwo),"*",String.valueOf(cardThree)};
      }
      else if(cardOne*cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"+"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"*",
             String.valueOf(cardTwo),"+",String.valueOf(cardThree)};
      }
      else if(cardOne*cardTwo*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"*"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"*",
             String.valueOf(cardTwo),"*",String.valueOf(cardThree)};
      }
      
      else if((cardOne-cardTwo)*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"*"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"-",
             String.valueOf(cardTwo),"*",String.valueOf(cardThree)};
      }
      else if(cardOne*cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"-"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"*",
             String.valueOf(cardTwo),"-",String.valueOf(cardThree)};
      }
      else if(cardOne/cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"/"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"/",
             String.valueOf(cardTwo),"/",String.valueOf(cardThree)};
      }
      else if(cardOne/cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"+"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"/",
             String.valueOf(cardTwo),"+",String.valueOf(cardThree)};
      }
      else if((cardOne+cardTwo)/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"+"+cardTwo+"/"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"+",
             String.valueOf(cardTwo),"/",String.valueOf(cardThree)};
      }
      
      else if((cardOne-cardTwo)/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"/"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"-",
             String.valueOf(cardTwo),"/",String.valueOf(cardThree)};
      }
      else if(cardOne/cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"-"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"/",
             String.valueOf(cardTwo),"-",String.valueOf(cardThree)};
      }
      else if(cardOne*cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"/"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"*",
             String.valueOf(cardTwo),"/",String.valueOf(cardThree)};
      }
      else if(cardOne/cardTwo*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"*"+cardThree+"="+equationAnswer);
         equation= new String[] {String.valueOf(cardOne),"/",
             String.valueOf(cardTwo),"*",String.valueOf(cardThree)};
      }
   }// end verify

   /** returns value of 1st card as a string
     * @return c1*/
   
   public String getCardOne()
   {
      c1 = String.valueOf(df.format(cardOne));   
      return c1;
   }// end getCardOne
   
    /** returns value of 2nd card as a string
     * @return c2*/
   
   public String getCardTwo()
   {
      c2 = String.valueOf(df.format(cardTwo));
      return c2;
   }// end getCardTwo
   
    /** returns value of 3rd card as a string
     * @return c3 */
   
   public String getCardThree()
   {
      c3 = String.valueOf(df.format(cardThree));
      return c3;
   }// end getCardThree
   
   /**return sum of equation as a string
     * @return equation answer */
   
   public String getEquationAnswer()
   {
      eA = String.valueOf(df.format(equationAnswer));
      return eA;
   }// end getEquationAnswer 
   
   /** returns equation
     * @return equation */
   
   public String[] getEquation()
   {
       return equation;
   }// end getEquation
}//endKrypto
