/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class DoubleDice {
    
    public static void main(String[] args){
        Random r = new Random();
        
        int dice1 = 1+r.nextInt(6);
        int dice2 = 1+r.nextInt(6);
       
        
    boolean total = (dice1 == dice2);
        while (!(dice1 == dice2)){
            System.out.println("Try again until you get a double");
            System.out.println("The total is "  + (dice1 + dice2));
        }
         
              System.out.println("Double Double");
              System.out.println("The total is "  + (dice1 + dice2));
          }
    }
    
    

