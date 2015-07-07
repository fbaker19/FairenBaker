/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.linkedlist;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListDriver {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedListNodeImpl<>();

        System.out.println("Size: " + ll.size());
        String one = "one";
        String two = "two";
        String three = "three";
        String four = "four";
        String five = "five";

        ll.prepend(one);

        System.out.println("Size: " + ll.size());
       
        System.out.println(ll.get(0));

        ll.remove(0);

        System.out.println("Size: " + ll.size());

        ll.prepend(one);
        ll.prepend(two);
        ll.prepend(three);
        ll.prepend(four);

        System.out.println("Size: " + ll.size());
        System.out.println("+++++++++++++++++++++++++++");
        
        for(Object s : ll)
        {
            System.out.println(s);
        }
        
        ll.remove(1);
        System.out.println("++++++++++++++++++++++++++++");
         for(Object s : ll)
        {
            System.out.println(s);
        }
        
         ll.append(four);
         ll.append(five);
         
         ll.remove(3);// remove from array
         System.out.println("++++++++++++++++++++++++++++");
         for(Object s : ll)
        {
            System.out.println(s);
        }
         
         ll.insert(0, five);
         System.out.println("++++++++++++++++++++++++++++");
         for(Object s : ll)
        {
            System.out.println(s);
        }
         
         
         
         ll.insert(2, four);
         System.out.println("++++++++++++++++++++++++++++");
         for(Object s : ll)
        {
            System.out.println(s);
        }
         
         Iterator iter =  ll. iterator();
         while(iter.hasNext())
         {
             System.out.println(iter.next());
         }
    }

}
