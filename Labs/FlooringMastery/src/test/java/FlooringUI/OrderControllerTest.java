/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class OrderControllerTest {
    
    public OrderControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class OrderController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        OrderController instance = new OrderController();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
      Assert.assertEquals(instance, this);
    }

    /**
     * Test of printMenu method, of class OrderController.
     */
    @Test
    public void testPrintMenu() {
        System.out.println("printMenu");
        OrderController instance = new OrderController();
        instance.printMenu();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addOrder method, of class OrderController.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        OrderController instance = new OrderController();
        instance.addOrder();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of displayAllOrders method, of class OrderController.
     */
    @Test
    public void testDisplayAllOrders() {
        System.out.println("displayAllOrders");
        OrderController instance = new OrderController();
        instance.displayAllOrders();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of editOrder method, of class OrderController.
     */
    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        OrderController instance = new OrderController();
        instance.editOrder();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeOrder method, of class OrderController.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        OrderController instance = new OrderController();
        instance.removeOrder();
        // TODO review the generated test code and remove the default call to fail.
       ;
    }

    /**
     * Test of saveCurrentWork method, of class OrderController.
     */
    @Test
    public void testSaveCurrentWork() {
        System.out.println("saveCurrentWork");
        OrderController instance = new OrderController();
        instance.saveCurrentWork();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of printOrder method, of class OrderController.
     */
    @Test
    public void testPrintOrder() {
        System.out.println("printOrder");
        OrderController instance = new OrderController();
        instance.printOrder();
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
