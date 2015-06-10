/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.objectexamples.nestobjects;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class AnonClassExample {
    
   
    
    public static void main(String[] args) {
        
        Die die = new Die()
        {
          public int roll()  {
            Random r = new Random();
            return r.nextInt(6)+1;
            }
        };
        
        System.out.println("Single roll "+die.roll());
    }
}
 class Die
    {
    
        public int roll()
        {return 0;}
    }