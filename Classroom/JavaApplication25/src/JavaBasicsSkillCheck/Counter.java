/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBasicsSkillCheck;

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number that is less than or equal to 10");
        int num= sc.nextInt();
       
        System.out.println("Your number is " +num);
       
        for(int i = num; i< 11; i++)
        {
            System.out.println(i);
        }
        
                
    }
    
}
