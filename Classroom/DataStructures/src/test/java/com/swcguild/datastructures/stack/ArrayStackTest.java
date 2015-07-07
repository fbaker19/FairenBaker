/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ArrayStackTest {

    ArrayStack as;

    public ArrayStackTest() {
    }

    @Before
    public void setUp() {
        as = new ArrayStack();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayStack instance = new ArrayStack();
        instance.push("anything");
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertTrue(!result);

    }

    /**
     * Test of size method, of class ArrayStack.
     */
    @Test
    public void OverStackSize() {
        System.out.println("Push to the stack");
        ArrayStack instance = new ArrayStack();
        instance.push("a");
        instance.push("b");
        instance.push("c");
        instance.push("d");
        instance.push("e");
        instance.push("f");
        
        int result = instance.size();
        int expResult = 6;
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testSize() {
        System.out.println("size");
        ArrayStack instance = new ArrayStack();
        instance.push("Testing");
        int expResult = 1;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of push method, of class ArrayStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object item = "f";
        ArrayStack instance = new ArrayStack();
        instance.push(item);
        boolean result = instance.isEmpty();
        Assert.assertFalse(result);

    }

    /**
     * Test of pop method, of class ArrayStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        ArrayStack instance = new ArrayStack();
        instance.push("Test");// now has an item

        Object result = instance.pop();// removes object

        Object expResult = "Test";// the object
        //Object result = instance.pop();
        assertEquals(expResult, result);

    }

    /**
     * Test of iterator method, of class ArrayStack.
     */
//    @Test
//    public void testIterator() {
//        System.out.println("iterator");
//        ArrayStack instance = new ArrayStack();
//        Iterator expResult = null;
//        Iterator result = instance.iterator();
//        assertEquals(expResult, result);
        
    //}
}
