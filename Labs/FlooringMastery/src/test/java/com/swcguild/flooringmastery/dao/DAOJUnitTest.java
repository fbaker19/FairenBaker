/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import FlooringDTO.Order;
import FlooringDTO.OrderFactory;
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
}
