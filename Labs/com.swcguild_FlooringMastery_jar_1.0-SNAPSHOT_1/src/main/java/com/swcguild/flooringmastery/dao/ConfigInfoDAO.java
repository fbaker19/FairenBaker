/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import FlooringDTO.Tax;
import static com.swcguild.flooringmastery.dao.TaxDAO.DELIMETER;
import static com.swcguild.flooringmastery.dao.TaxDAO.TAX_INFO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConfigInfoDAO {
     private static final String CONFIG_INFO= "FMTestConfig.txt";
    
     public String loadConfigInfo(){
         String currentLine ="";
         try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(CONFIG_INFO)));
 
            while (sc.hasNextLine()) {
                
                currentLine = sc.nextLine();

            }
             sc.close();
        } catch (FileNotFoundException e ) {
            System.out.println("Not Available");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Arrays are terrible");
                }
         return currentLine;
}

}
