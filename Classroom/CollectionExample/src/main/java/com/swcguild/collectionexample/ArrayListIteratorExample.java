/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionexample;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayListIteratorExample {
    public static void main(String[] args) {
        
       
        ArrayList<String> stringList = new ArrayList<>();
        
        stringList.add("My 1st string: ");
        stringList.add("My 2nd string: ");
        stringList.add("My 3rd string: ");
        stringList.add("My 4th string: ");
        
        
        System.out.println("Lists size: "+ stringList.size());
        
      Iterator<String> iter = stringList.iterator();
      
      while (iter.hasNext())
      {
          String current = iter.next();
          System.out.println(current);
      }
      
      
    }   
}
