/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swcguild.projectinventory.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InventoryController {

    
    private final Console con = new Console();

    String gender, color, size;
    float price;
    int quantity;
    int id;

    public void run() throws IOException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing = true) {
            printMenu();
            menuSelection = con.readInt("Please select from the above choices.", 1, 6);
            
            Product productObj;
            
            switch (menuSelection) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                    
                case 3:
                    productCount();
                    break;
                case 4:
                    printAllProducts();
                    break;
                    
                case 6:
                    con.print("Exiting...");
                    keepGoing = false;
                    break;
                default:
                    con.print("Unknown input...");
            }
        }
        con.print("Thank you for viewing...");
    }

    private void printMenu() {
        con.print("\n Main Menu");
        con.print("1. Add Product");
        con.print("2. Delete Product");
        con.print("3. List Product Count");
        con.print("4. List All Products");
        con.print("5. Exit \n------------------------------");
    }

    private void addProduct() {

        quantity = con.readInt("Enter your quantity: ");
        size = con.readString("Enter the size:  's' for small \n"
                + "\t\t 'm' for Medium \n \t\t 'L' for Large ");
        String gender = con.readString("Enter the gender: ");
        color = con.readString("Enter the color:");
        price = con.readFloat("Enter the price:");
        con.print("Added Product...");
        
    }

    private void deleteProduct() {
        String ids = con.readString("Enter the id "
                + "for the product you with to delete: ");
        con.print("Delete Address...");
       
    }


    private void productCount() {
        con.print("Lists the count  of Addresses:");
       
    }

    private void printAllProducts() {
        con.print("Listing all Products: ");
        Iterable<Product> currentProduct = null;
       
        for (Product productObj : currentProduct) {

            System.out.println(productObj.toString());
        }
    }
        
}