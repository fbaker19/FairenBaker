/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.javaexperiment;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {

        Foo foo = new Foo ("bob");
        Foo donkey = new Foo("Lobster");
        
        foo.report();

        bar(foo);

        foo.report();
        
        donkey.report();
        
        bar(donkey);// this pulls from the heap-----> another class
        bar(donkey);// this pulls from the heap-----> another class
        
         donkey.report(); // this pulls from the heap-----> another class
         foo.report();
        
       
    }

    public static void bar(Foo otherFoo) // this pulls from the heap-----> another class
    {
        otherFoo.poke();

    }
}
