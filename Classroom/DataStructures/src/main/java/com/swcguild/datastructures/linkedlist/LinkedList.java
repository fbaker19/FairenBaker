/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructures.linkedlist;

/**
 *
 * @author apprentice
 */
public interface LinkedList<T> extends Iterable {//links objects, such as arrays

    void append(T item);// only accepts what is in the append ie , string, int, ect
    // this is a form of generics

    T get(int index);

    void insert(int index, T item);

    boolean isEmpty();

    void prepend(T item);

    T remove(int index);

    int size();

}
