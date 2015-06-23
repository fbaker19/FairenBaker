/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author apprentice
 */
public class Product {

    public static int idGen = 1;
    public Float price;
    int quantity;
    String size;
    String gender;
    String color;
    int id;

    public Product(int quantity, String size, String gender, String color, Float price) {
        this.id = idGen++;
        this.quantity = quantity;
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        String desc = getId() + " - "
                + getQuantity() + " "
                + getSize() + " "
                + getGender() + " "
                + getColor() + " "
                + getPrice();
        return desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    void print() {
//        currentProduct.toString();
//    }
}