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
                    saveCurrentWork();
                    break;
                case 6:
                    String quitChoice = con.readString("Are you sure you want to quit?");
                    if (quitChoice.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        con.print("Quit");
                        keepGoing = false;
                        saveCurrentWork();
                    }
                    break;

                default:
                    con.print("Unknown input");
            }
        }

        oFB.WriteOrder();

    }

    public void printMenu() {
        con.print("**********************************************************");
        con.print("*                  Flooring Program");
        con.print("*");
        con.print("*1.Display all orders");
        con.print("*2.Add an order");
        con.print("*3.Edit order");
        con.print("*4.Remove an order");
        con.print("*5.Save to file");
        con.print("*6.Quit");
        con.print("*");
        con.print("**********************************************************");

    }

    public void addOrder() {

        String date = "a";

        while (date.length() != 8) {
            date = con.readString("Please enter today's date");
        }

        String customerName = con.readString("Please enter customer name");

        String state = "b";
        while (!state.equalsIgnoreCase("pa") && !state.equalsIgnoreCase("in") && !state.equalsIgnoreCase("mi") && !state.equalsIgnoreCase("oh")) {
            state = con.readString("Please enter customer State.(OH, MI, IN, or PA)");
        }

        String material = "c";
        while (!material.equalsIgnoreCase("wood") && !material.equalsIgnoreCase("tile") && !material.equalsIgnoreCase("carpet") && !material.equalsIgnoreCase("laminate")) {
            material = con.readString("Which material would the customer like to use?(Wood, Laminate, Tile, or Carpet)");
        }

        Double area = con.readDouble("Please enter the area of the floor to be covered");
        Order toBeAdded = factory.createNewOrder(customerName, state, material, area, date);

        oFB.addOrder(toBeAdded);

    }

    public void displayAllOrders() {

        oFB.displayAllOrders();
    }

    public void editOrder() {

        int orderVarify = con.readInt("Please enter order number that you would like to edit.");
        oFB.editOrder(orderVarify);

    }

    public void removeOrder() {
        
        String orderNum = con.readString("Please enter order number of order you want to remove");
        String choice = con.readYorN("Are you sure you want to remove the order?");
            if(choice.equalsIgnoreCase("y"))
            {
        oFB.removeOrder(Integer.parseInt(orderNum));
        con.print("Your Order has now been deleted");
            }
    }

    public void saveCurrentWork() {
        oFB.WriteOrder();

    }

    public void printOrder() {
        int orderToBeViewed = con.readInt("Please enter order number you would like to view: ");
        oFB.printOrder(orderToBeViewed);

    }

}
