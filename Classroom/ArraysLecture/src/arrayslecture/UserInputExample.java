/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayslecture;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserInputExample {
    
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    
 int userInput =0;
int total = 0;
int count =0;
int min =0;
int max = 0;

System.out.println("Please enter greater then or equal to zero:");
    userInput =sc.nextInt();
    min = userInput;
    max = userInput;
   
    while(userInput>=0)
    {
        
    total+= userInput;
    if(userInput>  max)
    {
         max = userInput;
    }
        if(userInput <min)
        {
      min = userInput;
        }
        
        count++;
        
        System.out.println("Please enter greater then or equal to zer:o");
    userInput =sc.nextInt();
        
    }
        System.out.println("Min" +min+ "max" +max+ "average" + (double)total/count);
    
    }


//do{ System.out.println("Please enter greater then or equal to zer:o");
  //  userInput =sc.nextInt();
    



    
    
    
    
    
    }
    
}
