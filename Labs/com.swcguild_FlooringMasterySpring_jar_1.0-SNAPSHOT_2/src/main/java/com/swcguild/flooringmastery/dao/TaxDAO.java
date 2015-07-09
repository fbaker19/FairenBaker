/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;


import com.swcguild.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author apprentice
 */
public class TaxDAO {

    public static final String TAX_INFO = "Data/Taxes.txt";
    public static final String DELIMETER = ",";
   

    public ArrayList <Tax> loadTaxInfo() {
       
        ArrayList<Tax> arrayTax = new ArrayList<>();
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(TAX_INFO)));
            String currentLine;
            String[] currentTokens;

            
            while (sc.hasNextLine()) {
                Tax currentTax = new Tax();///INSIDE WHILE LOOP
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMETER);

                currentTax.setStateName(currentTokens[0]);
                currentTax.setTaxRate(Double.parseDouble(currentTokens[1]));       
                arrayTax.add(currentTax);
            }
             sc.close();
        } catch (FileNotFoundException e ) {
            System.out.println("Not Available");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Arrays are terrible");
                }

    return arrayTax;
    }

}
