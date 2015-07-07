/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.stack;

import java.util.Iterator;

/**
 * make sure to place in the type: <T>
 *
 * @author Fairen
 */
public class GenLinkedListStack<T> implements GenStack<T> {

    private Node<T> first;
    private int numItems;

    @Override
    public boolean isEmpty() {
        return first == null;
        //or numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public void push(T item) {//PUSH===ADD
        Node prevFirst = first;//first node in place
        first =  new Node<T>();//creates a new node/ block
        first.item = item;// places item into the new node
        first.next = prevFirst;
        numItems++;//moves to next node down line / counter
    }

    @Override
    public T pop() {//POP===SUBTRACT
        T ret = first.item;
        first = first.next;
        numItems --;
        return ret;
    }

    @Override
    public Iterator iterator() {///return *NEW*  LinkedListIterator
        return new LinkedListIterator();
    }

   

    private class Node<Item> {

        Item item;
        Node next;
    }
    


   private class LinkedListIterator implements Iterator
    {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;// current is empty
        }

        @Override
        public Object next() {
            if(current == null){
            return null;
            }T ret = current.item;
            current = current.next;
            return ret;
        }
    
    }

}