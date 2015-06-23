/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Coat extends Product {
    
    boolean hasZipper;

    public Coat( int quantity, String size, String gender, String color, Float price) {
        super(quantity, size, gender, color, price);
        this.hasZipper = hasZipper;
    }

    public boolean isHasZipper() {
        return hasZipper;
    }

    public void setHasZipper(boolean hasZipper) {
        this.hasZipper = hasZipper;
    }
    
       public void print() {
        System.out.println("Coat details: ");
        //super.print();
        System.out.println("\t+hasZipper");
    }
    
}