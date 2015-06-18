/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.ui;

import com.swcguild.addressbook.controller.AddressBookController;

/**
 *
 * @author apprentice
 */
public class AddressBookRunner {
    public static void main(String[] args) {
        
        AddressBookController controller = new AddressBookController();
        controller.run();
        
    }
}
