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
public class UserInputArrayExp {
    public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    
    int[] userInput =new int[10];
    
    System.out.println("Please enter 10 values");
    
    for(int i=0; i<userInput.length; i++)
    {
        //i+1 showing the array ex.) value[1]<-----What user sees
        System.out.println("Please enter a value[" +(i+1)+"]:");
        userInput[i]=sc.nextInt();
    }
        //user inputs number for arrays
        int min= userInput [0];
        int max = userInput [0];
        int total = 0;
    
         System.out.println("[");
            for(int num:userInput) //':' short cut for 'for loop' - rus through everything in the array
            {
                //if statements w/o {}
                if (min>num)  min = num;
                if (max<num)  max = num;
                total+= num;
                System.out.println(num +" ");
            }
    
     System.out.println("]");
     System.out.println("min: "+min+" max: "+max+ " average: "+(double)total/userInput.length);
        //min/max/average formula
    
    
    
    
    
    }
    
}
