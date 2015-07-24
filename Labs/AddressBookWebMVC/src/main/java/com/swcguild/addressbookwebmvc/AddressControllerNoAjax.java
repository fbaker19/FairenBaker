package com.swcguild.addressbookwebmvc;

import com.swcguild.addressbookwebmvc.dao.AddressInterface;
import com.swcguild.addressbookwebmvc.model.Address;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class AddressControllerNoAjax {//NO AJAX
    private AddressInterface dao;

    @Inject
    public AddressControllerNoAjax(AddressInterface dao) {
        this.dao = dao;
    }
        
    @RequestMapping(value ={"/displayAddressList"}, method = RequestMethod.GET )
    public String displayAddressList(Model model)
    {
        List<Address> alist = dao.getAllAddresses();
        model.addAttribute("addressList", alist);//orange attributes/varible name is what is recognized by JSP's
             //addAllAttributes>>>ADD-ATTRIBUTE not addALL
        return "displayAddressList";
    }
     @RequestMapping(value="/displayNewAddressForm", method=RequestMethod.GET)
    public String displayNewAddressForm() {
        return "newAddressForm";//JSP
    }

    @RequestMapping(value="/addNewAddress", method=RequestMethod.POST)
    public String addNewAddress(HttpServletRequest request) {
       
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String numberAndStreet = request.getParameter("numberAndStreet");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip =request.getParameter("zip");
        
        Address addressVar = new Address();
        addressVar.setFirstName(firstName);
        addressVar.setLastName(lastName);
        addressVar.setNumberAndStreet(numberAndStreet);
        addressVar.setCity(city);
        addressVar.setState(state);
        addressVar.setZip(zip);
        
        dao.addAddress(addressVar);
        
        return "redirect:displayAddressList";//diplays the newly added address
    }
    
    @RequestMapping(value="/deleteAddress", method=RequestMethod.GET)
    public String deleteAddress(HttpServletRequest request) {
        int id= Integer.parseInt(request.getParameter("addressId"));
        dao.removeAddress(id);
        return "redirect:displayAddressList";
    }
    
//        @RequestMapping(value="/addressSearch", method=RequestMethod.GET)
//    public String searchAddress(HttpServletRequest request) {
////        int id= Integer.parseInt(request.getParameter("addressId"));///seen on displayAddress
////        dao.getAddressId(id);
//        return"addressSearch"; //"redirect:displayAddressList"
//    }
//     @RequestMapping(value="/addressSearch", method=RequestMethod.POST)
//    public String searchPostAddress(HttpServletRequest request) {
//        int id= Integer.parseInt(request.getParameter("addressId"));///seen on displayAddress
//        dao.getAllAddresses();
//        return"addressSearch"; //"redirect:displayAddressList"
//    }
      @RequestMapping(value="/displayEditAddressForm", method=RequestMethod.GET)
    public String displayEditAddressForm(HttpServletRequest request, Model model) {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        Address addressVar = dao.getAddressId(addressId);
        model.addAttribute("address", addressVar);
        return "editAddressForm";
    }
    
    
    @RequestMapping(value="/editAddress", method=RequestMethod.POST)
    public String editAddress(@Valid @ModelAttribute("address") Address addressVar,
                                        BindingResult result)
    {
        if(result.hasErrors())
        {
            return "editAddressForm";
        }
        
        dao.updateAddress(addressVar);
        //(addressVar);// add to array and display
        return "redirect:displayAddressList";
    }
}
