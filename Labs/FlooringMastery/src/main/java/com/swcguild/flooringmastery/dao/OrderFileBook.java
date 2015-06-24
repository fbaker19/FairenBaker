/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import FlooringDTO.Order;
import FlooringDTO.OrderFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;//adds dates
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
    public static final String ORDER_DATE = "Orders_MMDDYYYY.txt";
    public static final String DELIMITER = ",";

    private HashMap<Integer, Order> order = new HashMap<>();

    public void loadOrder() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_DATE)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState(currentTokens[2]);
            currentOrder.setMaterials(currentTokens[3]);
            currentOrder.setArea(Double.parseDouble(currentTokens[4]));
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
    Order nextOrder = freshOrder.createNewOrder(o.getCustomerName(), o.getState(), o.getMaterials(), o.getArea());
    order.put(nextOrder.getOrderNum(), nextOrder);
    //return nextOrder;
    }

    public Order removeOrder(int orderNum) {
        return order.remove(orderNum);
    }
}
