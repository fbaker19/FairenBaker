/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambdarefactor.dao;

import com.swcguild.addressbooklambdarefactor.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class LambdaAddressBookDAO {
    
    

    public static final String ADBOOK_FILE = "LambdaAddress.txt";
    public static final String DELIMITER = ",";
    private Map<Integer, Address> addressMap = new HashMap<>();
    
    
    
    public void loadAddressBookDAO() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADBOOK_FILE)));
        String currentLine;
        String[] currentTokens;//string array----> String []

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Address currentAddress = new Address(currentTokens[1]);

            currentAddress.setId(Integer.parseInt(currentTokens[0]));
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setLastName(currentTokens[2]);
            currentAddress.setNumberAndStreet(currentTokens[3]);
            currentAddress.setCity(currentTokens[4]);
            currentAddress.setState(currentTokens[5]);
            currentAddress.setZip(currentTokens[6]);

            addressMap.put(currentAddress.getId(), currentAddress);

        }
        sc.close();
    }

//    public Address getAddress(String lastName) {
//        return addresses.get(lastName);
//    }
    public void writeAddressDTO() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADBOOK_FILE));
        String[] keys = this.getAllAddresses();
        //use enhanced for loop to traverse through all elements
        for (int i = 0; i < keys.length; i++) {
            Address currentAddress = this.getAddress(keys[i]);
            out.print(currentAddress.getId() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER
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
        return addressMap.get(lastName);
    }

    public String[] getAllAddresses() {
        Set<Integer> keySet = addressMap.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Address removeAddress(Integer id) {
        return addressMap.remove(id);

    }

    public String totalNumber() {
        String x = Integer.toString(addressMap.size());
        return x;
    }

   

}
