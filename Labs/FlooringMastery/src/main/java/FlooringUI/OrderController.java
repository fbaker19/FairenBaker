/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlooringUI;

import FlooringDAO.OrderFileBook;

import com.swcguild.flooringmastery.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class OrderController {

    ConsoleIO con = new ConsoleIO();
    OrderFileBook oFB = new OrderFileBook();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            printMenu();
            menuSelection = con.readInt("please select fromt the above choices.", 1, 6);

            switch (menuSelection) {
                case 1:
                    con.print("Displaying all orders...");
                    //displayAllOrders();
                    break;
                case 2:
                    con.print("Adding new order...");
                    //addOrder();
                    break;
                case 3:
                    con.print("Editing order...");
                    //editOrder();
                    break;
                case 4:
                    con.print("Removing order...");
                    //removeOrder();
                    break;

                case 5:
                    con.print("Saving current work...");
                //saveCurrentwork();
                case 6:
                    con.print("Quit");
                    keepGoing = false;
                    break;

                default:
                    con.print("Unknown input");
            }
        }

    }

    public void printMenu() {

        con.print("Main Menu");
        con.print("1.Display all orders");
        con.print("2.Add an order");
        con.print("3.Edit order");
        con.print("4.Remove a student");
        con.print("5.Save to file");
        con.print("6.Quit");

    }

}
