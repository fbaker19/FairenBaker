/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

/**
 *
 * @author apprentice
 */
public class LuckySevens {
    private static Object dice;
    public static void main(String[] args) {
        // TODO code application logic here
        
                
             int die1;   .
             int die2;   
            
             PairOfDice() {
                   
                roll();  
            }
            
           roll() {
                    
                die1 = (int)(Math.random()*6) + 1;
                die2 = (int)(Math.random()*6) + 1;
                rollCount = 0;
           
           
           
           do {
               dice.roll();
               System.out.println("The dice come up " + dice.getDie1() 
                                                + " and " + dice.getDie2());
               rollCount++;
           } while (dice.getTotal() != 2);
           
           
           
           System.out.println("\nIt took " + rollCount + " rolls to get a 2.");
           
    }
    
}
