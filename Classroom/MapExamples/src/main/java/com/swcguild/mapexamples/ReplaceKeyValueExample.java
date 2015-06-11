/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.mapexamples;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class ReplaceKeyValueExample {
    public static void main(String[] args) {
        
    HashMap <String,Integer> populations = new HashMap<>();
        
        populations.put("USA",200000000);
        populations.put("Canada", 34000000);
        populations.put("United Kingdom", 63000000);
        populations.put("Japan", 127000000);
        
        System.out.println("Map size is: "+ populations.size());
        
        populations.put("USA", 313000000);//replaces use 200 million - only counts 4 elements
        
        System.out.println("Map size is: "+ populations.size());
        
        
        
    }
}
