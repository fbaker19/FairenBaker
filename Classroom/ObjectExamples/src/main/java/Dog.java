/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Dog {

//       public String dogName;
//       public int age;
//       public int weight;
    private String dogName;
    private int age;
    private int weight;
    private static int numberOfDogs = 0;

    
    //Constructor 
    public Dog(String nameIn, int ageIn, int weightIn)
    {
        this.dogName = nameIn;
        this.age = ageIn;
        this.weight = weightIn;
        numberOfDogs++;
    }

    public static int getNumberOfDogs() {
        return numberOfDogs;
    }

    public String getDogName() {
        return dogName;
    }

    public int getAge() {
        return age; //return needed with public
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;       // "this" refer's to a class
    }

    public void bark() {
        System.out.println(dogName + " says WOOF");
    }

    public void sit() {
        System.out.println("Sit");
    }

    public static void main(String[] args) {

    }

}
