import java.util.*;

/**
 *  Author: Zack Schiding
 * Author Getters/Setters: Karin Martin
  Name: Krypto.java
  Version: 0.1
  Function: Generates three numbers that match up with a generated answer number either by subtraction or addition.
 * 
 */
public class Krypto {

    private int cardOne,cardTwo,cardThree, cardFour, cardFive,equationAnswer;
    private String c1, c2, c3, c4, c5, eA;
    public boolean valid;
    
    public void generateNumber()
    {
        Random rand = new Random();
        cardOne = rand.nextInt(100);
        cardTwo = rand.nextInt(100);
        cardThree = rand.nextInt(100);
        //cardFour = rand.nextInt(100);
        //cardFive = rand.nextInt(100);
        equationAnswer = rand.nextInt(100);      
    }
    public void verify()
    {
        if(cardOne+cardTwo==equationAnswer)
        {
            valid=true;
            System.out.println(cardOne+"+"+cardTwo+"="+equationAnswer);
        }
        else if(cardOne+cardThree==equationAnswer)
        {
            valid=true;   
            System.out.println(cardOne+"+"+cardThree+"="+equationAnswer);
        }
        else if(cardTwo+cardThree==equationAnswer)
        {
            valid=true;
            System.out.println(cardTwo+"+"+cardThree+"="+equationAnswer);
        }
        else if(cardOne-cardTwo==equationAnswer)
        {
            valid=true;
            System.out.println(cardOne+"-"+cardTwo+"="+equationAnswer);
        }
        else if(cardOne-cardThree==equationAnswer)
        {
            valid=true;   
            System.out.println(cardOne+"-"+cardThree+"="+equationAnswer);
        }
        else if(cardTwo-cardThree==equationAnswer)
        {
            valid=true;
            System.out.println(cardTwo+"-"+cardThree+"="+equationAnswer);
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
       // c1 = "testing getCardOne";
        System.out.println("cardOne: " +c1);
        return c1;
    }
    
    public void setCardOne(int c1)
    {
        this.cardOne = c1;
        return;
    }

    public String getCardTwo()
    {
        c2 = String.valueOf(cardTwo);
        System.out.println("cardTwo: " +c2);
        return c2;
    }
    
    public void setCardTwo(int c2)
    {
        this.cardTwo = c2;
        return;
    }

        public String getCardThree()
    {
        c3 = String.valueOf(cardThree);
        System.out.println("cardThree: " +c3);
        return c3;
    }
    
    public void setCardThree(int c3)
    {
        this.cardThree = c3;
        return;
    }

/*
    public String getCardFour()
    {
        c4 = String.valueOf(cardFour);
        System.out.println("cardFour: " +c4);
        return c4;
    }
    
    public void setCardFour(int c4)
    {
        this.cardThree = c4;
        return;
    }
    
    public String getCardFive()
    {
        c5 = String.valueOf(cardFive);
        System.out.println("cardFive: " +c5);
        return c5;
    }
    
    public void setCardFive(int c5)
    {
        this.cardFive = c5;
        return;
    }
*/
    
    public String getEquationAnswer()
    {
        eA = String.valueOf(equationAnswer);
        System.out.println("equationAnswer: " +eA);
        return eA;
    }
    
    public void setEquationAnswer(int eA)
    {
        this.equationAnswer = eA;
        return;
    }    
    
}//endKrypto
