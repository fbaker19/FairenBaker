/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.mapexamples;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class ListingAllTheKeys {
    public static void main(String[] args) {
        HashMap <String,Integer> populations = new HashMap<>();
        
        populations.put("USA", 313000000);
        populations.put("Canada", 34000000);
        populations.put("United Kingdom", 63000000);
        populations.put("Japan", 127000000);
        
        System.out.println("Map size is: "+ populations.size());
       
       Set<String> keys = populations.keySet(); //countries are the "keys"
                                    
       
       for(String k:keys)//this loop list the keys/countries
                         // ':' are used in enhanced for loops
       {
           System.out.println(k);
       }
    }
}
