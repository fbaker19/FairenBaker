/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import FlooringDTO.Order;
import FlooringDTO.OrderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;//adds dates
//import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
//import java.util.Calendar;

/**
 *
 * @author apprentice
 */
public class OrderFileBook {

    OrderFactory freshOrder = new OrderFactory();
//    TaxDAO tdao = new TaxDAO();
//    ProductDAO pdao = new ProductDAO();

   // Order diffOrder = new Order();
    private HashMap<Integer, Order> order = new HashMap<>();
   
    //Collection <Order> date = order.values();
   
    public static final String ORDER_DATE ="Orders_MMDDYYYY.txt";
    public static final String DELIMITER = ",";

    

    public void loadOrder() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_DATE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
            currentOrder.setDate(currentTokens[1]);
            currentOrder.setCustomerName(currentTokens[2]);
            currentOrder.setState(currentTokens[3]);
            currentOrder.setMaterials(currentTokens[4]);
            currentOrder.setArea(Double.parseDouble(currentTokens[5]));
            order.put(currentOrder.getOrderNum(), currentOrder);
        }

        sc.close();
    }

    public void writeOrder() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ORDER_DATE));
        Integer[] keys = this.getAllOrders();
        for (int i = 0; i < keys.length; i++) {
            Order currentOrder = order.get(keys[i]);
                    //this.getOrder(keys[i]);
            out.println(currentOrder.getOrderNum() + DELIMITER
                    + currentOrder.getDate()+DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getTaxRate() + DELIMITER
                    + currentOrder.getMaterials() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getCostPerSqFt() + DELIMITER
                    + currentOrder.getLaborCostPerSqFt() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getTotal());

            out.flush();
        }
        out.close();

    }
    
    public void WriteOrders()
    {
        ArrayList<String>  orderDate = new ArrayList<>();
       //File file = new  File(order.get(0).getDate());
       
       
//        for(int i =0; i<order.size(); i++)
//        {
//             //orderDate.add( order.get(i).getDate() );
//            File file = new  File("c:\\"+ order.get(i).getDate()+ ".txt");
//        }
//        
        for(String date: orderDate)
        {
        PrintWriter out = null;
        
        File f = null;
        boolean b = false;
            
        try {
            f = new File("test.txt");
            b = f.createNewFile();
            
            System.out.println("File Created:" + b);
                
            out = new PrintWriter(new FileWriter("test.txt"));
                Integer[] keys = this.getAllOrders();
                for (int i = 0; i < keys.length; i++) {
                    Order currentOrder = order.get(keys[i]);
                    //this.getOrder(keys[i]);
                    out.println(currentOrder.getOrderNum() + DELIMITER
                            + currentOrder.getDate()+ DELIMITER
                            + currentOrder.getCustomerName() + DELIMITER
                            + currentOrder.getState() + DELIMITER
                            + currentOrder.getTaxRate() + DELIMITER
                            + currentOrder.getMaterials() + DELIMITER
                            + currentOrder.getArea() + DELIMITER
                            + currentOrder.getCostPerSqFt() + DELIMITER
                            + currentOrder.getLaborCostPerSqFt() + DELIMITER
                            + currentOrder.getMaterialCost() + DELIMITER
                            + currentOrder.getLaborCost() + DELIMITER
                            + currentOrder.getTax() + DELIMITER
                            + currentOrder.getTotal());
                    
                    out.flush();
                }       out.close();
            } catch (IOException ex) {
                System.out.println("Hell Nope!");            
            } finally {
                out.close();
            }

        }
        
        
    }

    public Integer[] getAllOrders() {
        Set<Integer> keySet = order.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Order getOrder(int orderNum) {
        return order.get(orderNum);
    }

    
    
    public void addOrder(Order o)
    {
    Order nextOrder = freshOrder.createNewOrder(o.getDate(),o.getCustomerName(), o.getState(), o.getMaterials(), o.getArea());
    order.put(nextOrder.getOrderNum(), nextOrder);
    //return nextOrder;
    }

    public Order removeOrder(int orderNum) {
        return order.remove(orderNum);
    }
}
