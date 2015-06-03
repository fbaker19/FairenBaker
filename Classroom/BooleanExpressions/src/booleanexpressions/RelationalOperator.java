/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

/**
 *
 * @author apprentice
 */
public class RelationalOperator {
    public static void main(String[] args){
   boolean test = (5 == 3+2);
    System.out.println("eval = 5 == 3+2 =>" + test);
    
    //!= Not equal
    
    int value = 15;
    
    test = (value!= 17);
    System.out.println("eval "+ value+ " != 17 =>" +test);
    
    int value2 = 32;
            System.out.println("eval value< value2" + (value < value2));
    
    
    
    
    }
    
}
