/* Author: Zack Schiding, Karin Martin, Patrick Leeper
   IST311 Group Project
   Due Date: 12/6/17
   zss5081@psu.edu, kur164@psu.edu, leeper@psu.edu

   KryptoApplication.java
    
   Overview:
   The purpose of the KryptoApplication class is to create a 
   client application that will run the Krypto and KryptoGUI classes.
*/

public class KryptoApplication
{
   public static void main(String[] args)
   {
      Krypto crypto = new Krypto();
   
      KryptoGUI gui = new KryptoGUI("Kracking Krypto");
   }
}