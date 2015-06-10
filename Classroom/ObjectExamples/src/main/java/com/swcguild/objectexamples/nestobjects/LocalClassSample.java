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
public class LocalClassSample {
    public static void main(String[] args) {
        class Die{
            public int roll(){
             Random rnd = new  Random();
             return rnd.nextInt(6) +1;
            }
        }
        
        
        Die die = new Die();
        System.out.println("Single roll: "+die.roll());
    }
    
    
    public static void foo()
    
    {
        //Die die = new Die();
    }
}
