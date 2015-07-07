/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.linkedlist;

import java.util.Iterator;

/**
 *
 * @author apprentice backend of a collection
 */
public class LinkedListNodeImpl<T> implements LinkedList<T> {// 

    private Node first;
    private Node last;
    private int numItems = 0;//counter

    @Override
    public void append(T item) {
        Node prevLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;// because its empty, first/last in the same box
        } else {
            prevLast.next = last;
        }
        numItems++;
    }

    @Override
    public T get(int index) {
        if (index == 0) {

            if (isEmpty()) {
                throw new IndexOutOfBoundsException("linked list is empty. Index is out of bounds");
            }
            return first.item;
        } else if (index == numItems - 1) {
            return last.item;
        } else {
            return getNode(index).item;
        }

    }

    @Override
    public void insert(int index, T item) {
        if (index == numItems - 1) {
            append(item);
        } else if (index == 0) {
            prepend(item);
        } else {
            Node nodeAtIndex = getNode(index);

            Node newNode = new Node();

            newNode.item = item;
            newNode.next = nodeAtIndex.next;
            nodeAtIndex.next = newNode;
            numItems++;
        }
    }

    @Override
    public boolean isEmpty() {

        return numItems == 0;
    }

    @Override
    public void prepend(T item) {
        Node prevFirst = first;
        first = new Node();
        first.item = item;
        first.next = prevFirst;
        numItems++;
        if (numItems == 1) {
            last = first;
        }

    }

    @Override
    public T remove(int index) {
        T ret = null; //ret = return
        if (index == 0) {
            ret = first.item;
            first = first.next;
        } else {
            Node nodeBefore = getNode(index - 1);//node w/value before the one we are at
            ret = nodeBefore.next.item;
            nodeBefore.next = nodeBefore.next.next;// the node behind the nod we want, this is the empty/uncared for node

            if (index == numItems - 1) {
                last = nodeBefore;
            }
        }
        numItems--;
        return ret;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator iterator() {//iterables has been extended on link list to create this method
        //hasNext&net 
        return new LinkedListIterator();
    }

    private class Node {

        T item;
        Node next;
    }

    
    
    private class LinkedListIterator implements Iterator// adds hasNext & Next
    {

        Node current = first;

        @Override
        public boolean hasNext() {//if current not found
            return current != null;
        }

        @Override
        public Object next() {
            if (current == null) {
                return null;//no item to return
            }
            T ret = current.item;
            current = current.next;
            return ret;
        }
        

    }

    private Node getNode(int index) {
        if (index > numItems - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: Index must be between 0 and " + (numItems - 1) + " Inclusive");
        }

        Node nodeAtIndex = first;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }
        return nodeAtIndex;
    }

}
