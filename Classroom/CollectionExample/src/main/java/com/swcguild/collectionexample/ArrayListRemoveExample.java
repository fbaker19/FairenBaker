/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionexample;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class ArrayListRemoveExample {
    public static void main(String[] args) {
        ArrayList<String> stringList= new  ArrayList<>();
        
        stringList.add("My first string");
        stringList.add("My second string");
        stringList.add("My third string");
        
        System.out.println("List size after adding  elements: " + stringList.size()); 
        //.size counts the number of objects in the array ie 'stringList' 
         
        stringList.remove(1);
        System.out.println("List size after removeing 1 elements: " + stringList.size()); 
        System.out.println("Printing 2nd element: "+stringList.get(1));
         
        
        stringList.remove(1);
        stringList.remove(0);
        
        System.out.println("List size after removing of last element "+stringList.size());
        
        
        //stringList.remove(0); will cause" index out of bods" exception/ unable to build
         
        
        
        
        
    }
}
