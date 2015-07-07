/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.controller;

import com.swcguild.addressbook.dao.AddressBook;
import com.swcguild.addressbook.dto.Address;
import com.swcguild.addressbook.ui.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    AddressBook adBook = new AddressBook();
    Console con = new Console();
    private Object addressBook;
    private Object getAddresses;

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            adBook.loadAddressBook();
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
        adBook.addAddress(lastName, currentAddress);
        adBook.writeAddress();
    }

    public void removeAddress() {
        String lastName = con.readString("Please enter the last name of the address to be removed");
        adBook.removeAddress(lastName);
        con.readString("Address successfully removed. Please hit enter to continue.");
    }

    public void viewAddress() {
        String lastName = con.readString("Please enter the last name of the person you wish to view");

        Address currentAddress;
        currentAddress = adBook.getAddress(lastName);
        if (currentAddress != null) {
            con.print("You have entered the last name of " + lastName);
            con.print(currentAddress.getLastName());
            con.print(currentAddress.getFirstName());
            con.print(currentAddress.getNumberAndStreet());
            con.print(currentAddress.getCity());
            con.print(currentAddress.getState());

            con.print("");
        } else {
            con.print("No person with this name: " + lastName);

        }
    }
        

    public void totalNumber() {
        con.print(adBook.totalNumber());

    }

    private void listAddresses() {
         String[] addresses = adBook.getAllAddresses();
        for (int i = 0; i < addresses.length; i++) 
        
        {
            Address currentAddress = adBook.getAddress(addresses[i]);
            con.print(currentAddress.getLastName());
            con.print(currentAddress.getFirstName());
            con.print(currentAddress.getNumberAndStreet());
            con.print(currentAddress.getCity());
            con.print(currentAddress.getState());
        }

        con.readString("Please hit enter to continue");
       
    }

}