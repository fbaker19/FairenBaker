/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals1and2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals {

    public static void main(String[] args) {
        
        HashMap<String, String> sc = new HashMap<>();

        sc.put("Montgomery", "Alabama");
        sc.put("Juneau", "Alaska");
        sc.put("Phoenix", "Arizona");
        sc.put("Little Rock", "Arkansas");
        sc.put("Sacramento", "California");
        sc.put("Denver", "Colorado");
        sc.put("Hartford", "Connecticut");
        sc.put("Dover", "Delaware");
        sc.put("Tallahassee", "Florida");
        sc.put("Atlanta", "Georgia ");
        sc.put("Honolulu", "Hawaii");
        sc.put("Boise", "Idaho");
        sc.put("Springfield", "Illinois");
        sc.put("Indianapolis", "Indiana");
        sc.put("Des Moines", "Iowa ");
        sc.put("Topeka", "Kansas ");
        sc.put("Frankfort", "Kentucky");
        sc.put("Baton Rouge", "Louisiana");
        sc.put("Augusta", "Maine");
        sc.put("Annapolis", "Maryland");
        sc.put("Boston", "Massachusetts ");
        sc.put("Lansing", "Michigan");
        sc.put("St. Paul", "Minnesota");
        sc.put("Jackson", "Mississippi");
        sc.put("Jefferson City", "Missouri");
        sc.put("Helena", "Montana");
        sc.put("Lincoln", "Nebraska ");
        sc.put("Carson City", "Nevada");
        sc.put("Concord", "New Hampshire");
        sc.put("Trenton", "New Jersey");
        sc.put("Santa Fe", "New Mexico");
        sc.put("Albany", "New York");
        sc.put("Raleigh", "North Carolina");
        sc.put("Bismarck", "North Dakota ");
        sc.put("Columbus", "Ohio");
        sc.put("Oklahoma City", "Oklahoma");
        sc.put("Salem", "Oregon");
        sc.put("Harrisburg", "Pennsylvania");
        sc.put("Providence", "Rhode Island");
        sc.put("Columbia", "South Carolina");
        sc.put("Pierre", "South Dakota");
        sc.put("Nashville", "Tennessee");
        sc.put("Austin", "Texas ");
        sc.put("Salt Lake City", "Utah");
        sc.put("Montpelier", "Vermont");
        sc.put("Richmond", "Virginia ");
        sc.put("Olympia", "Washington");
        sc.put("Charleston", "West Virginia");
        sc.put("Madison", "Wisconsin");
        sc.put("Cheyenne", "Wyoming ");

        Collection<String> capKeys = sc.keySet();
        Collection<String> stateValues = sc.values();

        System.out.println("THE CAPITALS ARE: ");
        for (String cap : capKeys) {
            System.out.println(cap);
        }

        System.out.println("THE STATES ARE: ");

        for (String state : stateValues) {
            System.out.println(state);
        }

        System.out.println("STATES  & CAPITALS: ");
        
       
        for(String cap : capKeys)
       {
           System.out.println("The capital of " + sc.get(cap) + " is " +cap );
       }
        
     
        }

    }


