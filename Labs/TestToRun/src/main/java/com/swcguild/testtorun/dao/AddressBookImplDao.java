/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.testtorun.dao;

import com.swcguild.testtorun.model.Address;
import com.swcguild.testtorun.model.AddressSearchTerm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Lambda DAO
 *
 * @author apprentice
 */
public class AddressBookImplDao implements AddressInterface {//after interface (not a class) is implemented -
    // import all abstract methods(@Overrides)

    public static final String ADBOOK_FILE = "LambdaAddress.txt";
    public static final String DELIMITER = "::";

    private Map<Integer, Address> addressMap = new HashMap<>();

    List<Address> address = new ArrayList<>();// create array list of getters and setters

    @Override
    public List<Address> searchByCity(String cityName) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getCity().equalsIgnoreCase(cityName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByState(String stateName) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getState().equalsIgnoreCase(stateName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByZip(Integer zip) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getZip().equals(zip))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchNumberAndStreet(String numberAndStreet) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getNumberAndStreet().equalsIgnoreCase(numberAndStreet))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByFirstName(String firstName) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> searchByLastName(String lastName) {
        return addressMap.values()
                .stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                /**
                 * creates new list of filtered objects (whats left
                 * over/bottleneck effect)
                 */
                .collect(Collectors.toList());
        //.forEach(e -> System.out.println(e.getLastName()));

    }

    @Override
    public Integer addAddress(Address address) {
        address.setId(nextID());
        addressMap.put(address.getId(), address);
        return address.getId();// returns ID that was gotten
    }

    @Override
    public void removeAddress(int Id) {
        addressMap.remove(Id);
    }

    private Integer nextID() {
        if (addressMap == null || addressMap.isEmpty()) {
            return 0;
        }
        Integer id = addressMap.keySet()
                .stream()
                /**
                 * Comparator for Lambda
                 */
                .max((Integer val1, Integer val2) -> {
                    return val1.compareTo(val2);
                })
                //^^^ shorthand version of what is below
                //                    if (val1 > val2) {
                //                        return 1;
                //                    } else if (val1 == val2) {
                //
                //                        return 0;
                //                    } else {
                //                        return -1;
                //                    }

                .get();//optional to get integer/int 

        return id + 1;

    }

  

//     public void loadAddressBookDAO() throws FileNotFoundException {
//        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADBOOK_FILE)));
//        String currentLine;
//        String[] currentTokens;//string array----> String []
//
//        while (sc.hasNextLine()) {
//            currentLine = sc.nextLine();
//            currentTokens = currentLine.split(DELIMITER);
//
//            Address currentAddress = new Address(currentTokens[1]);
//
//            currentAddress.setId(Integer.parseInt(currentTokens[0]));
//            currentAddress.setFirstName(currentTokens[1]);
//            currentAddress.setLastName(currentTokens[2]);
//            currentAddress.setNumberAndStreet(currentTokens[3]);
//            currentAddress.setCity(currentTokens[4]);
//            currentAddress.setState(currentTokens[5]);
//            currentAddress.setZip(currentTokens[6]);
//
//            addressMap.put(currentAddress.getId(), currentAddress);
//
//        }
//        sc.close();
//    }
//
////    public Address getAddress(String lastName) {
////        return addresses.get(lastName);
////    }
//  
//    public void writeAddressDTO() throws IOException {
//        PrintWriter out = new PrintWriter(new FileWriter(ADBOOK_FILE));
//        List<Address> addresses = this.getAllAddresses();
//        //use enhanced for loop to traverse through all elements
//        for (Address currentAddress : addresses) { //what is is returning(String, Integer, List, ect) element(current__): arrayName
//           
//            out.print(currentAddress.getId() + DELIMITER
//                    + currentAddress.getFirstName() + DELIMITER
//                    + currentAddress.getLastName() + DELIMITER
//                    + currentAddress.getNumberAndStreet() + DELIMITER
//                    + currentAddress.getCity() + DELIMITER
//                    + currentAddress.getState() + DELIMITER
//                    + currentAddress.getZip());
//            out.flush();
//        }
//        out.close();
//    }
//    
    @Override
    public List<Address> getAllAddresses() {
        List<Address> address = new ArrayList<>(addressMap.values());///constuctor of Array List<>()
        return address;

    }

    @Override
    public List<Address> searchAddress(Map<AddressSearchTerm, String> criteriaMap) {

        //ArrayList with the parameter of a map< enum, accepting a 'String'>
        //enum= what to searchby(green)
        String firstNameCriteria = criteriaMap.get(AddressSearchTerm.FIRST_NAME);
        String lastNameCriteria = criteriaMap.get(AddressSearchTerm.LAST_NAME);
        String numberAndStreetCriteria = criteriaMap.get(AddressSearchTerm.NUMBER_AND_STREET);
        String cityCriteria = criteriaMap.get(AddressSearchTerm.CITY);
        String stateCriteria = criteriaMap.get(AddressSearchTerm.STATE);
        String zipCriteria = criteriaMap.get(AddressSearchTerm.ZIP);

        //stores DTO in form of an Array List
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> numberAndStreetMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipMatches;

        Predicate<Address> truePredicate = (c) -> {
            return true;
        };

        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getFirstName().equalsIgnoreCase(firstNameCriteria);

        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getLastName().equalsIgnoreCase(lastNameCriteria);

        numberAndStreetMatches = (numberAndStreetCriteria == null || numberAndStreetCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getNumberAndStreet().equalsIgnoreCase(numberAndStreetCriteria);

        cityMatches = (cityCriteria == null || cityCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCity().equalsIgnoreCase(cityCriteria);

        stateMatches = (stateCriteria == null || cityCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getCity().equalsIgnoreCase(cityCriteria);
        zipMatches = (zipCriteria==null || zipCriteria.isEmpty())
                ? truePredicate
                :(c)-> c.getZip().equalsIgnoreCase(zipCriteria);
        
        return addressMap.values().stream()
                        .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(numberAndStreetMatches)
                        .and(cityMatches)
                        .and(stateMatches)
                        .and(zipMatches)
                )
                .collect(Collectors.toList());

    }

    @Override
    public Address getAddressId(int addressId) {
        return (Address) addressMap;
    }

    @Override
    public void updateAddress(Address addressVar) {
        addressMap.put(addressVar.getId(), addressVar);
    }

}

        //LambdaAddressBookDAO addDao = new ();
//ConsoleIO con = new ConsoleIO();
//    private Object addressBook;
//    private Object getAddresses;
// Collections.sort(list, lastName);
//        one.getLastName();
//        one.getFirstName();
//        one.getCity();
//        one.getNumberAndStreet();
//        one.getState();
//        one.getZip();
//
//        address.add(one);
//        
        //        one = new Address();
