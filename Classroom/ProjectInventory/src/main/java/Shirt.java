/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class Shirt extends Product {

    Float sleeveLength;  
    
    //protected Shirt()
    
    public Shirt(int quantity, String size, String gender, String color, Float price) {
        super(quantity, size, gender, color, price);
        this.sleeveLength = sleeveLength;
        
    }

    public Float getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(Float sleeveLength) {
        this.sleeveLength = sleeveLength;
    }
    
    
    public void print() {
        System.out.println("Shirt details: ");
        //super.print();
        System.out.println("\t+sleeveLength");
    }
    
    
}