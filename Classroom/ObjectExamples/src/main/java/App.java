/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
        Dog puppy = new Dog("Fido,", 1, 12); //new object

        Dog otherPuppy = new Dog("Not a planet ", 1, 13);

        puppy.bark(); ///connected to "Dog" java class
        otherPuppy.bark();
        System.out.println("created " + Dog.getNumberOfDogs() + " dogs.");
    }

}
