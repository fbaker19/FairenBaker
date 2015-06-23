/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class RPGSatchel {
    public static void main(String[] args) {
        
        Sword weapon = new Sword();
        Shield protection = new Shield("Large Shield", 30);
        Satchel backpack = new Satchel(50);
        
        backpack.addToSatchel(weapon);
        backpack.addToSatchel(protection);
        
        
        Item magic = new Potion();
        backpack.addToSatchel(magic);
        
        
        String[] items = backpack.listItemsInSatchel();
                
        for (String item: items)
                {
                    System.out.println(item);
                }
    }
    
}
