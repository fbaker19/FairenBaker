/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import FlooringDTO.Order;
import FlooringDTO.OrderFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DAOJUnitTest {
    
    public DAOJUnitTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
//    @Test
//    public void loadDaoFile()
//    {
//    ProductDAO pdao = new ProductDAO();
//    pdao.loadProductInfo();
//    
//    }
    
    @Test
    public void addOrder()
    {
        OrderFileBook ofb = new OrderFileBook();
        OrderFactory factory = new OrderFactory();
       // Order order = factory.createNewOrder("bob", "OH","Carpet", 100,"date");
       // ofb.addOrder(order);
        
    }
    @Test
    
    public void writeOrder()
    {
     OrderFileBook ofb = new OrderFileBook();
        OrderFactory factory = new OrderFactory();
       Order order = factory.createNewOrder("bob", "OH","Carpet", 100, "06242015");
        ofb.addOrder(order);
        
        order = factory.createNewOrder("Mike", "MI","Tile", 100, "06242015");
        ofb.addOrder(order);
        
        ofb.WriteOrder();
    }
}
