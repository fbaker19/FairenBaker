
import java.util.Random;
import java.util.Scanner;

public class DoubleDice {

    public static void main(String[] args) {

        Random r = new Random();

        int die1 = 0;
        int die2 = 1;
        int count = 0;
        //int sum = die1 + die2;

        
        while (die1 != die2 ) {
            
          
            System.out.println("Roll again");
           
            count++;
           
            die1 = 1 + r.nextInt(6);
            die2 = 1 + r.nextInt(6);
            
            int sum = die1 + die2;
            
            System.out.println("first roll is: " + die1 + " second roll is: " + die2);
            System.out.println("Your total is " + sum);
            
        } 
        
        System.out.println("Doubles!");
        

    }
}

