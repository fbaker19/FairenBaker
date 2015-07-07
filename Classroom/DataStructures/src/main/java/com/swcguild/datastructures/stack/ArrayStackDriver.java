/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayStackDriver {

    public static void main(String[] args) {

        Stack st = new ArrayStack();

        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";

        //Pushed onto the Stack
        /**
         * First in last out ---loading plates in the caf.
         */
        System.out.println("Pushing " + a);
        st.push(a);

        System.out.println("Pushing " + b);
        st.push(b);

        System.out.println("Pushing " + c);
        st.push(c);

        System.out.println("Pushing " + d);
        st.push(d);

            //pop = remove from the stack
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
//
//        System.out.println("Popping...");
//        System.out.println((String) st.pop());
        
        
        for(Object o: st)
        {
            System.out.println((String)o);
        }
        
        
        Iterator it = st.iterator();
        while(it.hasNext())
        {
            System.out.println((String)it.next());
        }
        
    }

}
