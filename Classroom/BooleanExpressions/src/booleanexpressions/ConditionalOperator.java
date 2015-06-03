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
public class ConditionalOperator {
    public static void main(String[] args){
  
        boolean test = true;
        
        //toggle - test=!test;
         test=!test;
        System.out.println("Not true =>" + !test);
    
//(true && true) == true
//(true && false) = false    
//(false && true) =  false
//(false && false) = false
        
        
        test = (5>7) && (3<4);
        
        
        int ourValue =7;
        
        test =(ourValue >6) && (ourValue<13); //<-------number between 6 & 13
        System.out.println("ourValue isi int the range of 6...13 =" + test);
        
        
        // OR ---> ||
        // (true || true) == true
        // (true || false)== true
        // (false|| true)==true
        //(false || false)==false
        
        
        ourValue = 11;
        
        test = (ourValue<15) ||(ourValue>42); // < true, Our value<15 
        
        //XOR ---> ^
        //(true^true) == false
        //(false^true)== true 
        //(true^false)== true
        //(false^false)==false
        
        ourValue =18;
        
        test = (ourValue == 15)^(ourValue==17);
        System.out.println(("XOR or value is either 15 or 17 => ")+test);
       
        
        ourValue= 17;
       // value is in (0...20) or in(15...42)
        test = ((ourValue >=0)&&(ourValue <=20))^((ourValue>15)&&(ourValue<42));
        System.out.println("Value is in (0...20) or in (15...42)" +test);
        
        
        
        
    }
    
}
