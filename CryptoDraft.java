package cryptodraft;

import java.util.*;


/**
 *  Author: Zack Schiding
 *  Name: CryptoDraft.java
 *  Version: 0.1
 *  Function: Generates three numbers that match up with a generated answer number either by subtraction or addition.
 * 
 */
public class CryptoDraft {

    private int cardOne,cardTwo,cardThree,equationAnswer;
    public boolean valid;
    
    public void generateNumber()
    {
        Random rand = new Random();
        cardOne = rand.nextInt(100);
        cardTwo = rand.nextInt(100);
        cardThree = rand.nextInt(100);
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
    }
}
