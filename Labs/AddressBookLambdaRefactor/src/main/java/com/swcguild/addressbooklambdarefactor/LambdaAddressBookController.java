/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambdarefactor;

import com.swcguild.addressbooklambdarefactor.dao.LambdaAddressBookDAO;
import com.swcguild.addressbooklambdarefactor.dto.Address;
import com.swcguild.addressbooklambdarefactor.ui.AddressBook;
import com.swcguild.addressbooklambdarefactor.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LambdaAddressBookController {

    AddressBook adBook = new LambdaAddressBookImpl();
    ConsoleIO con = new ConsoleIO();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            adBook.loadAddressBookDAO();
            while (keepGoing) {
                printMainMenu();
                menuSelection = con.readInt("Please select from the 6 choices.", 1, 6);

                switch (menuSelection) {
                    case 1:
                        con.print("Adding an address...");
                        addAddress();
                        break;
                    case 2:
                        con.print("Removing an address...");
                        removeAddress();
                        break;
                    case 3:
                        con.print("Viewing an address...");
                        viewAddress();
                        break;
                    case 4:
                        con.print("Retrieving total number of addresses...");
                        totalNumber();
                        break;
                    case 5:
                        con.print("Retrieving all addresses...");
                        listAddresses();
                        break;
                    case 6:
                        con.print("Exiting...");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Input");
                }
            }
             adBook.writeAddressDTO();
            con.print("Thank you for using Address Book...");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading Address Book");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

    }

    private void printMainMenu() {
        con.print("Welcome to Address Book!\nPress 1 to add an address\nPress 2 to remove an address\nPress 3 to view an address\nPress 4 to view the total number of address\nPress 5 to view all addresses\nPress 6 to exit");
    }

    private void addAddress() throws IOException {
        String firstName = con.readString("Please enter first name");
        String lastName = con.readString("Please enter last name");
        String numberAndStreet = con.readString("Please enter the number and street");
        String city = con.readString("Please enter city");
        String state = con.readString("Please enter state");
        String zip = con.readString("Please enter zip code");
        
        Address currentAddress = new Address(lastName);

        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setNumberAndStreet(numberAndStreet);
        currentAddress.setCity(city);
        currentAddress.setState(state);
        currentAddress.setZip(zip);
        // adBook.getAddress(lastName, currentAddress);
       
        Integer Id = adBook.addAddress(currentAddress);
        
        System.out.println("your id  number is: " + Id);
        
        adBook.writeAddressDTO();
        
    }

    public void removeAddress() {
        Integer Id;
        Id = con.readInt("Please enter the ID number of the address to be removed");
        adBook.removeAddress(Id);
        con.readString("Address successfully removed. Please hit enter to continue.");
    }

    public void viewAddress() {
        Integer Id;
        Id = con.readInt("Please enter the ID number of the address to be view");
        Address currentAddress;
        currentAddress = adBook.getAddress(Id);
        if (currentAddress != null) {
            con.print("You have entered the last name of " + Id);
            con.print(currentAddress.getLastName());
            con.print(currentAddress.getFirstName());
            con.print(currentAddress.getNumberAndStreet());
            con.print(currentAddress.getCity());
            con.print(currentAddress.getState());

            con.print("");
        } else {
            con.print("No person with this name: " + Id);

        }
    }

    private void listAddresses() {
        List<Address> addresses = adBook.getAllAddresses();
        for (Address currentAddress : addresses) {

            con.print(currentAddress.getLastName());
            con.print(currentAddress.getFirstName());
            con.print(currentAddress.getNumberAndStreet());
            con.print(currentAddress.getCity());
            con.print(currentAddress.getState());
        }

        con.readString("Please hit enter to continue");

    }

    private void totalNumber() {
    adBook.getAllAddresses().size();
    
        System.out.println(adBook.getAllAddresses().size());
    }

}
