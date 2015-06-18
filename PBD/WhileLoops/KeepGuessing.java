
import java.util.Random;
import java.util.Scanner;


public class KeepGuessing {
    
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
       int myGuess = 1+r.nextInt(10);
       
        System.out.println("Please enter a number");
        int yourGuess = sc.nextInt();
        
        while(myGuess != yourGuess)
        {
            System.out.println("Your guess was " +yourGuess +" Please guess again");
             yourGuess = sc.nextInt();
        
        }
        System.out.println("You're correct!");
         
    }
    
}
