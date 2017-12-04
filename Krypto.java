 /**
 * Authors: Zack Schiding, Karin Martin, Patrick Leeper
 * Name: Krypto.java
  Version: 0.4
  Function: Generates three numbers that match up with a 
   generated answer number either by subtraction or addition.
 */

import java.util.*;


public class Krypto {

   private int cardOne,cardTwo,cardThree, cardFour, cardFive,equationAnswer;
   private String c1, c2, c3, c4, c5, eA;
   public boolean valid;
   
   public void Krypto()
   {
      valid=false;
      while(valid==false)
      {
         generateNumber();
         verify();
      }
   }
   public void generateNumber()
   {
      Random rand = new Random();
      cardOne = rand.nextInt(100)+1;
      cardTwo = rand.nextInt(100)+1;
      cardThree = rand.nextInt(100)+1;
      //cardFour = rand.nextInt(100);
      //cardFive = rand.nextInt(100);
      equationAnswer = rand.nextInt(100)+1;      
   }
   public void verify()
   {
      if(cardOne+cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"+"+cardTwo+"+"+cardThree+"="+equationAnswer);
      }
      else if(cardOne+cardTwo-cardThree==equationAnswer)
      {
         valid=true;   
         System.out.println(cardOne+"+"+cardTwo+"-"+cardThree+"="+equationAnswer);
      }
      else if(cardOne-cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"+"+cardThree+"="+equationAnswer);
      }
      else if(cardOne-cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"-"+cardThree+"="+equationAnswer);
      }
      else if(cardOne+cardTwo*cardThree==equationAnswer)
      {
         valid=true;   
         System.out.println(cardOne+"+"+cardTwo+"*"+cardThree+"="+equationAnswer);
      }
      else if(cardOne*cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"+"+cardThree+"="+equationAnswer);
      }
      else if(cardOne*cardTwo*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"*"+cardThree+"="+equationAnswer);
      }
      
      else if(cardOne-cardTwo*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"*"+cardThree+"="+equationAnswer);
      }
      else if(cardOne*cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"-"+cardThree+"="+equationAnswer);
      }
      else if(cardOne/cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"/"+cardThree+"="+equationAnswer);
      }
      else if(cardOne/cardTwo+cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"+"+cardThree+"="+equationAnswer);
      }
      else if(cardOne+cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"+"+cardTwo+"/"+cardThree+"="+equationAnswer);
      }
      
      else if(cardOne-cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"-"+cardTwo+"/"+cardThree+"="+equationAnswer);
      }
      else if(cardOne/cardTwo-cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"-"+cardThree+"="+equationAnswer);
      }
      else if(cardOne*cardTwo/cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"*"+cardTwo+"/"+cardThree+"="+equationAnswer);
      }
      else if(cardOne/cardTwo*cardThree==equationAnswer)
      {
         valid=true;
         System.out.println(cardOne+"/"+cardTwo+"*"+cardThree+"="+equationAnswer);
      }
      
      
      else
      {
         
      }
   }
   public void test()
   {
      valid=false;
      while(valid==false)
      {
         generateNumber();
         verify();
      }
      System.out.println("1: "+cardOne+" 2: "+cardTwo+" 3: "+cardThree+" A: "+equationAnswer);
      getCardOne();
      getCardTwo();
      getCardThree();
      //getCardFour();
      //getCardFive();
      getEquationAnswer();
      //getCardOne();
   }
   
   public String getCardOne()
   {
      c1 = String.valueOf(cardOne);   
      return c1;
   }
   
   public String getCardTwo()
   {
      c2 = String.valueOf(cardTwo);
      return c2;
   }
   
   public String getCardThree()
   {
      c3 = String.valueOf(cardThree);
      return c3;
   }
   
/*
   public String getCardFour()
   {
       c4 = String.valueOf(cardFour);
       System.out.println("cardFour: " +c4);
       return c4;
   }
      
   public String getCardFive()
   {
       c5 = String.valueOf(cardFive);
       System.out.println("cardFive: " +c5);
       return c5;
   }
*/
   
   public String getEquationAnswer()
   {
      eA = String.valueOf(equationAnswer);
      return eA;
   }   
   
}//endKrypto
