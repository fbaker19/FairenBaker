/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Makes10 {

    public boolean Makes10(int a, int b) {
       int sum = a+b;
       if(sum == 10 || a == 10 || b ==10 )
       {
         return true;  
       }else{
           return false;
       }
       
    }
}

//Given two ints, a and b, return true if one of them is 10 or if their sum is 10. 
//
//Makes10(9, 10) -> true
//Makes10(9, 9) -> false
//Makes10(1, 9) -> true
