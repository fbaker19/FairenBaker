/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author apprentice
 */
public class Pants extends Product {
    
    int numOfPockets;

    public Pants(int quantity, String size, String gender, String color, Float price) {
        super(quantity, size, gender, color, price);
        this.numOfPockets = numOfPockets;
    }

    public int getNumOfPockets() {
        return numOfPockets;
    }

    public void setNumOfPockets(int numOfPockets) {
        this.numOfPockets = numOfPockets;
    }
    
       public void print() {
        System.out.println("Pant details: ");
        //super.print();
        System.out.println("\t+numOfPockets");
    }
    
}