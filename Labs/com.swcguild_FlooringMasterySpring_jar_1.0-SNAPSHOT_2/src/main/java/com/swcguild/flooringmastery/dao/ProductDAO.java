/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmastery.dao;

import com.swcguild.flooringmastery.dto.Product;
import com.swcguild.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author apprentice
 */
public class ProductDAO {//load file only

    public static final String PRODUCT_INFO = "Data/Products.txt";
    public static final String DELIMETER = ",";
   
    ArrayList<Product> arrayProduct = new ArrayList<>();

    public ArrayList<Product> loadProductInfo()  {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_INFO)));
            String currentLine;
            String[] currentTokens;

            while (sc.hasNextLine())  {
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMETER);
                 Product currentProduct = new Product();///INSIDE THE WHILE LOOP

                currentProduct.setProductName(currentTokens[0]);
                currentProduct.setCostPerSqFt(Double.parseDouble(currentTokens[1]));
                currentProduct.setLaborCostPerSqFt(Double.parseDouble(currentTokens[2]));

                arrayProduct.add(currentProduct);// adds current product to array list
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hell no!");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Arrays suck");
                }

        return arrayProduct;
    }
}
