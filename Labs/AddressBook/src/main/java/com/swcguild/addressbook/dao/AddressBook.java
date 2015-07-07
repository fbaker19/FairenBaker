/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dao;

import com.swcguild.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class AddressBook {

    public static final String ADBOOK_FILE = "adbook.txt";
    public static final String DELIMITER = "::";
    private HashMap<String, Address> addresses = new HashMap<String, Address>();

    public void loadAddressBook() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADBOOK_FILE)));
        String currentLine;
        String[] currentTokens;//string array----> String []

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Address currentAddress = new Address(currentTokens[1]);

            currentAddress.setFirstName(currentTokens[0]);
            currentAddress.setLastName(currentTokens[1]);
            currentAddress.setNumberAndStreet(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZip(currentTokens[5]);

            addresses.put(currentAddress.getLastName(), currentAddress);

        }
        sc.close();

    }

    public void addAddress(String lastName, Address address) {
        addresses.put(lastName, address);
    }

    public void writeAddress() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADBOOK_FILE));
        String[] keys = this.getAllAddresses();
        for (int i = 0; i < keys.length; i++) {
            Address currentAddress = this.getAddress(keys[i]);
            out.print(currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getLastName() + DELIMITER
                    + currentAddress.getNumberAndStreet() + DELIMITER
                    + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZip());
            out.flush();
        }
        out.close();
    }

    public Address getAddress(String lastName) {
        return addresses.get(lastName);
    }

    public String[] getAllAddresses() {
        Set<String> keySet = addresses.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Address removeAddress(String lastName) {
        return addresses.remove(lastName);

    }
    
    public String totalNumber()
    {
        String x = Integer.toString (addresses.size());
        return x;
    }

}