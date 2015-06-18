/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.statecapitals1and2;

import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {

   
        
    
    public class Capital {
        
       

        public String capName;
        public int population;
        public int sqMiles;

        public Capital(String name, int pop, int sqM) {
            capName = name;
            population = pop;
            sqMiles = sqM;

        }

        public void getCapitals() {
            System.out.println("The capital is " + capName);
            System.out.println("The population is " + population);
            System.out.println("The square  mileage is " + sqMiles);

        }
         
        private HashMap<String,State> states =  new HashMap<>();

        public void StateCap() {
            
            State state = new State(4822023, 50744, "Montgomery","Alabama");//Data Tranfer Object                                      
            states.put(state.getName(), state);                             //DTO>>>>Template
            
            state = new State(731449, 571951,"Juneau", "Alaska");
            states.put(state.getName(), state);
            
           state = new State(6553255,13635,"Phoenix","Arizona");
           states.put(state.getName(), state);
            
           
           
           HashMap<String, String> sc = new HashMap<>(); //not valid
          HashMap<Integer, Integer> scI = new HashMap<>(); //not valid
//
//            sc.put("Montgomery", "Alabama");
//            scI.put(4822023, 50744);
//          
//            sc.put("Juneau", "Alaska");
//            scI.put(731449, 571951);
//          
//            sc.put("Phoenix", "Arizona");
//            scI.put(6553255, 13635);
          
            sc.put("Little Rock", "Arkansas");
            scI.put(2949131, 52068);
         
            sc.put("Sacramento", "California");
            scI.put(38041430, 155959);
         
            sc.put("Denver", "Colorado");
            scI.put(5187582, 103718);
           
            sc.put("Hartford", "Connecticut");
            scI.put(3590347, 4845);
           
            sc.put("Dover", "Delaware");
            scI.put(917092, 1954);
          
            sc.put("Tallahassee", "Florida");
            scI.put(19317568, 53927);
          
            sc.put("Atlanta", "Georgia ");
            scI.put(9919945, 57906);
          
            sc.put("Honolulu", "Hawaii");
            scI.put(1392313, 6423);
          
            sc.put("Boise", "Idaho");
            scI.put(1595728, 82747);
           
            sc.put("Springfield", "Illinois");
            scI.put(12875255, 55584);
          
            sc.put("Indianapolis", "Indiana");
            scI.put(6537334, 35867);
          
            sc.put("Des Moines", "Iowa ");
            scI.put(3074186, 55869);
          
            sc.put("Topeka", "Kansas ");
            scI.put(2885905, 81815);
           
            sc.put("Frankfort", "Kentucky");
            scI.put(4380415, 39728);
          
            sc.put("Baton Rouge", "Louisiana");
            scI.put(4601893, 43562);
          
            sc.put("Augusta", "Maine");
            scI.put(1329192, 30862);
            
            sc.put("Annapolis", "Maryland");
            scI.put(5884563, 9774);
           
            sc.put("Boston", "Massachusetts ");
            scI.put(6646144, 7840);
            
            sc.put("Lansing", "Michigan");
            scI.put(9883360, 56804);
           
            sc.put("St. Paul", "Minnesota");
            scI.put(5379139, 79610);
            
            sc.put("Jackson", "Mississippi");
            scI.put(2984926, 46907);
           
            sc.put("Jefferson City", "Missouri");
            scI.put(6021988, 68886);
           
            sc.put("Helena", "Montana");
            scI.put(1005141, 145552);
            
            sc.put("Lincoln", "Nebraska ");
            scI.put(1855525, 76872);
            
            sc.put("Carson City", "Nevada");
            scI.put(2758931, 109826);
           
            sc.put("Concord", "New Hampshire");
            scI.put(1320718, 8968);
            
            sc.put("Trenton", "New Jersey");
            scI.put(8864590, 7417);
            
            sc.put("Santa Fe", "New Mexico");
            scI.put(2085538, 121356);
            
            sc.put("Albany", "New York");
            scI.put(19570261, 47214);
           
            sc.put("Raleigh", "North Carolina");
            scI.put(9752073, 48711);
           
            sc.put("Bismarck", "North Dakota ");
            scI.put(699628, 68976);
          
            sc.put("Columbus", "Ohio");
            scI.put(11544225, 40948);
           
            sc.put("Oklahoma City", "Oklahoma");
            scI.put(3814820, 68667);
            
            sc.put("Salem", "Oregon");
            scI.put(3899353, 95997);
            
            sc.put("Harrisburg", "Pennsylvania");
            scI.put(12763536, 44817);
            
            sc.put("Providence", "Rhode Island");
            scI.put(1050292, 1045);
           
            sc.put("Columbia", "South Carolina");
            scI.put(4723723, 30109);
            
            sc.put("Pierre", "South Dakota");
            scI.put(833354, 75885);
           
            sc.put("Nashville", "Tennessee");
            scI.put(6456243, 41217);
            
            sc.put("Austin", "Texas ");
            scI.put(26059203, 261797);
           
            sc.put("Salt Lake City", "Utah");
            scI.put(2855287, 82144);
            
            sc.put("Montpelier", "Vermont");
            scI.put(626011, 9250);
           
            sc.put("Richmond", "Virginia ");
            scI.put(8185867, 39594);
           
            sc.put("Olympia", "Washington");
            scI.put(6897012, 66544);
            
            sc.put("Charleston", "West Virginia");
            scI.put(1855413, 24078);
            
            sc.put("Madison", "Wisconsin");
            scI.put(5726398, 54310);
            
            sc.put("Cheyenne", "Wyoming ");
            scI.put(576412, 97100);

        }

        public String getCapName() {
            return capName;
        }

        public void setCapName(String capName) {
            this.capName = capName;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getSqMiles() {
            return sqMiles;
        }

        public void setSqMiles(int sqMiles) {
            this.sqMiles = sqMiles;
        }
    }
    
}


