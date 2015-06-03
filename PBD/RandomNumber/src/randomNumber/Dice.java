/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomNumber;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class Dice {
    public static void main(String[] args){
    
        Random r = new Random();
        
        int diceRoll1 = 1+r.nextInt(6);
        int diceRoll2 = 1+r.nextInt(6);
        
        System.out.println("Here's roll #1:  " + diceRoll1);
            
        System.out.println("Here's roll #2:  " +  diceRoll2);
        
        System.out.println("The total of the dice is "+ (diceRoll1 + diceRoll2));
           
            
            
            
            
        
            
        
       
    
   
    }
    
}
