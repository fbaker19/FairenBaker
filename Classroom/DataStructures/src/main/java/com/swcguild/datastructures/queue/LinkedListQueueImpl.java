/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queue;

import java.util.Iterator;
import javafx.scene.Node;

/**
 *
 * @author apprentice
 */
public class LinkedListQueueImpl<T> implements LinkedLinkQueue<T> {

    private int numItems = 0;//counter
    private Node<T> first;
    private Node<T> last;

    @Override
    public void enqueue(T item) {//ADDING
        if (numItems == 0) {
            first = new Node<T>();
            first.item = item;
        } else {

            Node prevLast = last;
            last = new Node<>();
            last.item = item;
            prevLast.next = last;//prevLast == the previously lasst slot (before the new/last bbox added)
        }
        numItems++;// outside the if & else == applies to both

    }

    @Override
    public T dequeue() {//REMOVAL
        T ret = first.item;
        first = first.next;
        numItems--;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public int getItemsLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumOfItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        return new LinkedListQueueIterator();
    }

    private class Node<T> {

        T item;
        Node next;
    }

    public class LinkedListQueueIterator implements Iterator {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                return null;//no item to return
            }
            T ret = (T) current.item;
            current = current.next;
            return ret;
        }

    }

}
