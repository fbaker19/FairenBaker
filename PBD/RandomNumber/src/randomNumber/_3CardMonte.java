/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomNumber;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class _3CardMonte {
    
    public static void main(String[]args){
    
    Scanner sc = new Scanner (System.in);
    Random r = new Random();
    
    int fastEddie = 1+r.nextInt(3);
    
    System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
"He glances at you out of the corner of his eye and starts shuffling.\n" +
"He lays down three cards.");
    
    System.out.println("Which one is the ace? Please pick a number 1-3");
        int player = sc.nextInt();
    
        if(player == fastEddie){
        System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
     
      }
        
        if(player != fastEddie){
        System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.");
        }
    }
    
}
