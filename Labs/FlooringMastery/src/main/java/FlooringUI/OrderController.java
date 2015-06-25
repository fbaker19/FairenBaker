/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringUI;

import FlooringDTO.Order;
import FlooringDTO.OrderFactory;
import com.swcguild.flooringmastery.dao.OrderFileBook;

import com.swcguild.flooringmastery.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class OrderController {

    ConsoleIO con = new ConsoleIO();
    OrderFileBook oFB = new OrderFileBook();
    OrderFactory factory = new OrderFactory();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            printMenu();
            menuSelection = con.readInt("please select from the above choices.", 1, 6);
            
            switch (menuSelection) {
                case 1:
                    con.print("Displaying all orders...");
                    displayAllOrders();
                    break;
                case 2:
                    con.print("Adding new order...");
                    addOrder();
                    break;
                case 3:
                    con.print("Editing order...");
                    editOrder();
                    break;
                case 4:
                    con.print("Removing order...");
                    removeOrder();
                    break;
                    
                case 5:
                    con.print("Saving current work...");
                    //saveCurrentwork();
                    break;
                case 6:
                    con.print("Quit");
                    keepGoing = false;
                    break;
                    
                default:
                    con.print("Unknown input");
            }
        }
        oFB.WriteOrders();
    }
 


    public void printMenu() {
        con.print("-----------------------------------------------------------");
        con.print("Main Menu");
        con.print("1.Display all orders");
        con.print("2.Add an order");
        con.print("3.Edit order");
        con.print("4.Remove an order");
        con.print("5.Save to file");
        con.print("6.Quit");
        con.print("-----------------------------------------------------------");

    }

    public void addOrder()  {
        String date = con.readString("Please enter today's date");
        String customerName = con.readString("Please enter customer name");
        String state = con.readString("Please enter customer State.");
        String material = con.readString("Which material would the customer like to use?");
        Double area = con.readDouble("Please enter the area of the floor to be covered");
        Order toBeAdded = factory.createNewOrder(date,customerName, state, material, area);
       oFB.addOrder(toBeAdded);
        

    }

    public void displayAllOrders() {
        
        

    }

    public void editOrder() {

    }

    public void removeOrder() {

    }

    public void saveCurrentWork() {

    }

    public void printOrder() {

    }

}