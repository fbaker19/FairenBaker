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
public class RetrieveKeyValueExample {
    public static void main(String[] args) {
         HashMap <String,Integer> populations = new HashMap<>();
        
        populations.put("USA", 313000000);
        populations.put("Canada", 34000000);
        populations.put("United Kingdom", 63000000);
        populations.put("Japan", 127000000);
       
        
        System.out.println("Map size is: "+ populations.size());
       
        
        Integer japanPopulation = populations.get("Japan");
        
        System.out.println("The population of Japan is: " +japanPopulation);
        
    }
    
}
