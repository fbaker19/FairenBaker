/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queue;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class ArrayQueue implements Queue {

    private static final int DEFAULT_INTITIAL_SIZE = 10;
    private Object[] items;// 10 black spaces in the queue
    private int numItems;//private int variable is defaulted to 0 -- queue.size() = numItems

    private int head;// always = 0
    private int tail;

    public ArrayQueue()//default constructor  if other constructor fails == safety net      
    {
        this(DEFAULT_INTITIAL_SIZE);// set stacks size
    }

    public ArrayQueue(int size) {
        items = new Object[size];
        head = 0;
    }

    @Override
    public void enqueue(Object item) {// add to tail
//       if(items[0] ==null)
//       {
//           items[tail] = item;
//           tail++;
//           numItems++;
//       }
        //adding to enqueue
//        if (numItems == items.length) {//items.length = array boxes
//            resize(2 * items.length);// numItems == wahts in the array boxes
//        }
//        
        if ((tail == items.length - 1) && numItems == items.length - 1) {
            resize(2 * items.length);
            items[tail] = item;
            tail++;
            head++;
        }else{
        
        }
        numItems--;
    }

    @Override
    public Object dequeue() {// remove from head// tail does not have to move
        if (numItems == 0) {
            return null;//if this is empty, it can't pop/remove
        }

        Object item = items[head];
        items[head] = null;// slot is no longer/ non existent

        if (head == items.length - 1) {
            head = 0;
        } else {
            head++;// moves right(no longer 0)
        }
        numItems--;

        //RESIZE
        if (numItems > items.length / 2) {
            resize(items.length * 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;//returns the number of items in the array
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];

//             if(items.length < numItems/2)
//        {
//            head = 0;// resets the head to 0 -->shift
//            tail = head+numItems;        
//        }
//        else{
//            resize(items.length*2);
//        
//        }
        }
        items = temp;

    }

    public int getHead() {
        return head;
    }

    @Override
    public int getItemsLength() {
        return items.length;
    }

    @Override
    public int getNumOfItems() {
        return numItems;
    }

}
