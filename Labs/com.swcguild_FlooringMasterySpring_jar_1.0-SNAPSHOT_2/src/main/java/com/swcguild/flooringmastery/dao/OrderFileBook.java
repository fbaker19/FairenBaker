/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import com.swcguild.flooringmastery.dto.Order;
import com.swcguild.flooringmastery.dto.OrderFactory;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static HashMap<Integer, Order> orderByDate = new HashMap<>();
    private static  Map<String, HashMap<Integer, Order>> ordersMap = new HashMap<>();

    //Collection <Order> date = order.values();
    public static final String ORDER_DATE = "Orders_";
    public static final String DELIMITER = ",";

    public void loadOrder() throws FileNotFoundException {
        //Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_DATE)));
        String currentLine;
        String[] currentTokens;

        Set<String> keySet = ordersMap.keySet();
        for (String k : keySet) {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDER_DATE + k + ".txt")));
            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                Order currentOrder = new Order(Integer.parseInt(currentTokens[0]));
                currentOrder.setDate(currentTokens[1]);
                currentOrder.setCustomerName(currentTokens[2]);
                currentOrder.setState(currentTokens[3]);
                currentOrder.setMaterials(currentTokens[4]);
                currentOrder.setArea(Double.parseDouble(currentTokens[5]));
                orderByDate.put(currentOrder.getOrderNum(), currentOrder);
            }

            sc.close();//for loop?
        }

    }

    public void WriteOrder() {
        PrintWriter out = null;

        Set<String> uniqueDates = this.getUniqueDates();
        List<Order> ordersForDate = null;

        for (String date : uniqueDates) {
            try {
                out = new PrintWriter(new FileWriter("Orders_" + date + ".txt"));
            } catch (IOException ex) {
                Logger.getLogger(OrderFileBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            ordersForDate = getOrdersByDate(date);
            for (Order temp : ordersForDate) {
                out.println(temp.getOrderNum() + DELIMITER
                        + temp.getDate() + DELIMITER
                        + temp.getCustomerName() + DELIMITER
                        + temp.getState() + DELIMITER
                        + temp.getTaxRate() + DELIMITER
                        + temp.getMaterials() + DELIMITER
                        + temp.getArea() + DELIMITER
                        + temp.getCostPerSqFt() + DELIMITER
                        + temp.getLaborCostPerSqFt() + DELIMITER
                        + temp.getMaterialCost() + DELIMITER
                        + temp.getLaborCost() + DELIMITER
                        + temp.getTax() + DELIMITER
                        + temp.getTotal());

                out.flush();
            }
            out.close();
        }
    }

    public Integer[] getAllOrders() {
        Set<Integer> keySet = orderByDate.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Order getOrder(int orderNum) {
        return orderByDate.get(orderNum);
    }

    public void addOrder(Order o) {
        Order nextOrder = freshOrder.createNewOrder(o.getCustomerName(), o.getState(), o.getMaterials(), o.getArea(), o.getDate());
        orderByDate.put(nextOrder.getOrderNum(), nextOrder);
        System.out.println("Your order number is " + 2 * o.getOrderNum());
    }

    public Order removeOrder(int orderNum) {

        File file = new File("Orders_" + orderByDate.get(orderNum).getDate() + ".txt");

        Set<Integer> keySet = orderByDate.keySet();
        for (Integer i : keySet) {
            if (i == orderNum) {
                orderByDate.remove(i);
                file.delete();
            }
        }

        return orderByDate.remove(orderNum);
    }

    public Set<String> getUniqueDates() {
        Set<String> dateSet = new HashSet<>();
        Set<Integer> keySet = orderByDate.keySet();
        for (Integer k : keySet) {

            String date;
            date = orderByDate.get(k).getDate();
            boolean add = dateSet.add(date);

        }
        return dateSet;
    }

    public List<Order> getOrdersByDate(String date) {
        //Set<String> dates = this.getUniqueDates();
        List<Order> orders = new ArrayList<>();
        for (Integer i : orderByDate.keySet()) {
            if (date.equals(orderByDate.get(i).getDate())) {

                orders.add(orderByDate.get(i));
            }
        }
        return orders;
    }

    public void printOrder(int orderNum) {

        Set<Integer> keySet = orderByDate.keySet();
        Order seeOrder = null;
        boolean hasOrder = false;
        for (Integer i : keySet) {
            if (i == orderNum) {
                seeOrder = orderByDate.get(i);
                hasOrder = true;

            }

        }
        if (hasOrder) {

            System.out.println("Customer name: " + seeOrder.getCustomerName());
            System.out.println("Date ordered: " + seeOrder.getDate());
            System.out.println("State: " + seeOrder.getState());
            System.out.println("Materials requested: " + seeOrder.getMaterials());
            System.out.println("area: " + seeOrder.getArea() + " sqFt");
            System.out.println("Total cost:" + seeOrder.getTotal());
        } else {
            System.out.println("No such order with this number exist");
        }

    }

    public void editOrder(int orderNum) {
        Set<Integer> keySet = orderByDate.keySet();
        Order editOrder = null;
        Scanner sc2 = new Scanner(System.in);
        for (Integer i : keySet) {

            if (i == orderNum) {
                editOrder = orderByDate.get(i);
                System.out.println("If you would like to change individual fields\n enter the change to be made. If you would like filed to remain the same\nplease press enter.");

                System.out.println("Customer name: " + editOrder.getCustomerName());
                String cN = "";
                String customerName = sc2.nextLine();
                if (customerName.length() >= 1) {
                    cN = customerName;
                } else {
                    cN = editOrder.getCustomerName();
                }

                System.out.println("Date ordered: " + editOrder.getDate());
                String dO = "";
                String dateOrder = sc2.nextLine();
                if (dateOrder.length() >= 1) {
                    dO = dateOrder;
                } else {
                    dO = editOrder.getDate();
                }

                System.out.println("State: " + editOrder.getState());
                String sO = "";
                String stateOrder = sc2.nextLine();
                if (stateOrder.length() >= 1) {
                    sO = stateOrder;
                } else {
                    editOrder.getState();
                }

                System.out.println("Materials requested: " + editOrder.getMaterials());
                String mO = "";
                String materialsOrder = sc2.nextLine();
                if (materialsOrder.length() >= 1) {
                    mO = materialsOrder;
                } else {
                    mO = editOrder.getMaterials();
                }

                System.out.println("area: " + editOrder.getArea() + " sqFt");
                String aOString;
                double aO = 0;
                String areaOrder = sc2.nextLine();
                if (areaOrder.length() >= 1) {
                    aOString = areaOrder;
                    aO = Double.parseDouble(aOString);
                } else {
                    aO = editOrder.getArea();
                }
                int tempOrderNumber = editOrder.getOrderNum();
                this.removeOrder(editOrder.getOrderNum());
                Order nextOrder = freshOrder.createNewOrder(cN, sO, mO, aO, dO);
                nextOrder.setOrderNum(tempOrderNumber);
                orderByDate.put(nextOrder.getOrderNum(), nextOrder);
                System.out.println("Your order number is " + 2 * nextOrder.getOrderNum());

            }

        }
    }

    public void displayAllOrders() {
        Set<Integer> keySet = orderByDate.keySet();
        Order seeOrder = null;

        for (Integer i : keySet) {

            seeOrder = orderByDate.get(i);

            System.out.println("___________________________________________");

            System.out.println("Customer name: " + seeOrder.getCustomerName());
            System.out.println("Date ordered: " + seeOrder.getDate());
            System.out.println("State: " + seeOrder.getState());
            System.out.println("Materials requested: " + seeOrder.getMaterials());
            System.out.println("area: " + seeOrder.getArea() + " sqFt");
            System.out.println("Total cost:" + seeOrder.getTotal());

            System.out.println("___________________________________________");
        }

    }

//  
}
