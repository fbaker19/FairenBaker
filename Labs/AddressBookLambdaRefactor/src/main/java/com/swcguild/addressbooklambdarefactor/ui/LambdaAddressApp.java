/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbooklambdarefactor.ui;

import com.swcguild.addressbooklambdarefactor.LambdaAddressBookController;
import com.swcguild.addressbooklambdarefactor.dao.LambdaAddressBookDAO;
import com.swcguild.addressbooklambdarefactor.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class LambdaAddressApp {

    public static void main(String[] args) {
        LambdaAddressBookController controller = new LambdaAddressBookController();
        controller.run();
    }

}
