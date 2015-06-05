/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBasicsSkillCheck;


public class AreTheyTrue {
    public static void main(String[] args) {
        
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        
        
        if (num1> num2){
            System.out.println("that's right!");
        }else{
            System.out.println("Thats false!!");
              }
               
        if((num4>num1)&&(num2<num3)){
            System.out.println("You are correct!");
        }else{System.out.println("Sorry, that is false, try again");}
        
       if((num1<num3)||(num2>num1)){
           System.out.println("true");
       }else{System.out.println("false");}
        
        
        
    }
}
