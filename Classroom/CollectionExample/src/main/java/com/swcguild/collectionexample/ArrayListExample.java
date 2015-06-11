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
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> stringList =new ArrayList<>();//allows array to be flexible
        System.out.println("List size before adding any Strings " +stringList.size());
        
        stringList.add("My first string");
        
        System.out.println("List size after adding 1st string: "+stringList.size());
        
        stringList.add("My second string");
        
        System.out.println("List size after adding 2nd string: "+stringList.size());
        
    }
}
