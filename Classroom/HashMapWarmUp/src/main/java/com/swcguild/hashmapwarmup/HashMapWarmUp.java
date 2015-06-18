/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.hashmapwarmup;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class HashMapWarmUp {
    
    public static void main(String[] args) {
        
        Map<String,Integer> stats = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        stats.put("Smith", 23);
        stats.put("Jones", 12);
        stats.put("Jordan", 45);
        stats.put("Pippen", 32);
        stats.put("Kerr", 15);
        int sum  = 0;
        
        Set<String> nameKeys = stats.keySet();
       
        
        for(String name:nameKeys)
        {
            System.out.println(name +": " +stats.get(name));//stats.get(name) == the value
            sum+=stats.get(name);
            //System.out.println(sum);
        }
        
        double avg = (double)sum/stats.keySet().size();//double sum... returns the avg as a double
        System.out.println("The sum of the team's total is "+sum+"  and the average is " + avg);
            
    }
    
}
