/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.queue;

/**
 *
 * @author apprentice
 */
public interface LinkedLinkQueue<T> extends Iterable  {
    
    public void enqueue(T item);

    public T dequeue();

    public boolean isEmpty();

    public int size();

    public int getItemsLength();

    public int getNumOfItems();
}
    

