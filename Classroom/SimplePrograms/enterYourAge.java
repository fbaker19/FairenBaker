/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimplePrograms;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class enterYourAge {
    public static void main(String[] args){
     Scanner sc = new Scanner (System.in);
       
     
     int age;
    System.out.println("Enter your age")
            int age = sc.nextInt();
        
if(age <= 18){
System.out.println("You must be in school");

}

if((age > 18)&&(age<65)){

System.out.println ("time to go to work");}

else{

System.out.println("Enjoy retirement");
}



}
}
