/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.controller;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dto.DVD;
import com.swcguild.dvdlibraryv3.dao.DvdLibraryV3ImplFB;

import com.swcguild.dvdlibraryv3.ui.Console;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class Controller {

    DvdLibraryDao dvdList = new DvdLibraryV3ImplFB();//implemented new Dao (DVDLibraryImpl();
    Console con = new Console();
    ArrayList<String> notes = new ArrayList<>();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            // dvdlib.loadDVDLibrary();
            while (keepGoing) {
                printMainMenu();
                menuSelection = con.readInt("Please select from the 6 choices", 1, 6);

                switch (menuSelection) {
                    case 1:
                        con.print("Adding a DVD...");
                        addDVD();
                        break;
                    case 2:
                        con.print("Removing a DVD...");
                        removeDVD();
                        break;
                    case 3:
                        con.print("Editing a DVD...");
                        editDVD();
                        break;
                    case 4:
                        con.print("Viewing a DVD...");
                        //viewDVD();
                        break;
                    case 5:
                        con.print("Viewing all DVDs...");
                        viewAll();
                        break;
                    case 6:
                        con.print("Exiting...");
                        //writeDVDs();
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Input");
                }
            }
            con.print("Thank you for using the DVD Library...");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading DVD Library");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    private void printMainMenu() {
        con.print("Welcome to DVD Library!");
        con.print("Press 1 to add a DVD entry");
        con.print("Press 2 to remove a DVD entry");
        con.print("Press 3 to edit a DVD entry");
        con.print("Press 4 to view a DVD entry");
        con.print("Press 5 to view all DVD entries");
        con.print("Press 6 to exit");
    }

    /// no method in dao/imple to create id - placed directly here
    ///import DVD/DTO hashmap 

    private Integer nextID() {
        if (dvdList == null || dvdList.listAll().isEmpty()) // is array list is empty 
        {
            return 0;
        }
        Integer id = dvdList.listAll()
                .stream()
                .max(Comparator.comparing(dvd -> dvd.getId() ))//dvd variable (not DVD/DTO)
                .get().getId();    //optional to get integer/int 

        return id + 1;

    }

    private void addDVD() throws IOException {
        String title = con.readString("Please enter the title of the DVD");
        String date = con.readString("Please enter the year of release");
        String mpaaRating = con.readString("Please enter the MPAA rating");
        String director = con.readString("Please enter the name of the director");
        String studio = con.readString("Please enter the name of the studio");
        String note = con.readString("please enter a note in regard to the Dvd");

        DVD currentDVD = new DVD();
        currentDVD.setId(nextID());
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(LocalDate.MIN);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        ArrayList<String> notes = addNote(currentDVD);
        currentDVD.setNote(note);
      
//        dvdlib.add( name, currentDVD);
//        con.readString("DVD successfully added.  Please hit enter to continue.");
    }

    private ArrayList addNote(DVD currentDVD) throws IOException {

        String next = "";
        while (!"n".equals(next)) {
            String note = con.readString("Please enter your note about the DVD");

            notes.add(note);
            next = con.readString("Would you like to add another note? y or n?");
        }
        return notes;
    }

    private void removeDVD() throws FileNotFoundException, IOException {
       int id = con.readInt("Which DVD entry would you like to remove?");
        dvdList.remove(id);
        con.readString("You have successfully removed this DVD entry.  Please hit enter to continue.");
    }

//    private void viewDVD() {
//        boolean goOn = true;
//        int searchInput = con.readInt("How would you like to search for a DVD?\nPress 1 to search by name\nPress 2 to search by year of release\nPress 3 to search by MPAA Rating\nPress 4 to search by director\nPress 5 to search by studio\nPress 6 for stats about your collection: newest film, oldest film, average age of movies, average number of notes for movies\nPress 7 to return to the main menu");
//
//        while (goOn) {
//            switch (searchInput) {
//                case 1:
//                    con.print("Searching by name...");
//                    String name = con.readString("Please enter the last name of the DVD you wish to see");
//                    searchByName(name);
//                    goOn = false;
//                    break;
//                case 2:
//                    con.print("Searching by year of release...");
//                    String date = con.readString("Please enter the year of the of the DVD you wish to see");
//                    searchByDate(date);
//                    goOn = false;
//                    break;
//                case 3:
//                    con.print("Searching by MPAA Rating...");
//                    String rating = con.readString("Please enter the MPAA Rating of the of the DVD you wish to see");
//                    searchByRating(rating);
//                    goOn = false;
//                    break;
//                case 4:
//                    con.print("Searching by director...");
//                    String director = con.readString("Please enter the director of the of the DVD you wish to see");
//                    searchByDirector(director);
//                    goOn = false;
//                    break;
//                case 5:
//                    con.print("Searching by studio...");
//                    String studio = con.readString("Please enter the studio of the of the DVD you wish to see");
//                    searchByStudio(studio);
//                    goOn = false;
//                    break;
//                case 6:
//                    con.print("Searching for stats...");
//                    getStats();
//                    goOn = false;
//                    break;
//                case 7:
//                    con.print("Exiting...");
//                    goOn = false;
//                    break;
//                default:
//                    con.print("Unknown Input");
//            }
//        }
//        if (currentDVD != null) {
//            String printNotes = "";
//            for (String s : notes) {
//                printNotes += s + "\n";
//            }
//            con.print(currentDVD.getName());
//            con.print(currentDVD.getDate());
//            con.print(currentDVD.getRating());
//            con.print(currentDVD.getDirector());
//            con.print(currentDVD.getStudio());
//            con.print(printNotes);
//            con.print("");
//        } else {
//            con.print("No entry was found for " + name);
//        }
//        con.readString("Please hit enter to continue.");
    private void editDVD() throws IOException {
        Integer id = con.readInt("Which DVD entry would you like to edit?");
        DVD currentDVD = dvdList.getById(id);// var = currentDVD of type DVD(DTO) assigning it to the result of getById(method)
        
        //  DVD currentDVD = dvdlib.searchByName(name);
        if (currentDVD != null) {
            String printNotes = "";
            for (String s : notes) {
                printNotes += s + "\n";
            }
            con.print("Current title: " + currentDVD.getTitle());
            String x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String title = con.readString("Enter new title");
                currentDVD.setTitle(title);
                con.print("New name: " + title);
            }

            con.print("Current year of release: " + currentDVD.getReleaseDate());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String releaseDate = con.readString("Enter new year of release");
                currentDVD.setReleaseDate(LocalDate.MIN);
                con.print("New year of release: " + releaseDate);
            }

            con.print("Current MPAA rating: " + currentDVD.getMpaaRating());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String mpaaRating = con.readString("Enter new MPAA rating");
                currentDVD.getMpaaRating();
                con.print("New MPAA rating: " + mpaaRating);
            }

            con.print("Current name of the director: " + currentDVD.getDirector());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String director = con.readString("Enter new name of the director");
                currentDVD.setDirector(director);
                con.print("New name of the director: " + director);
            }

            //  con.print("Current name of the studio: " + currentDVD.getStudio());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String studio = con.readString("Enter new name of the studio");
                //  currentDVD.setStudio(studio);
                con.print("New name of the studio: " + studio);
            }

            con.print("Current notes: " + printNotes);
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                con.print("Enter new note");
                //  addNote(currentDVD);
                con.print("");
            }
        } else {
            con.print("No entry was found for " + id);
        }
        con.readString("Please hit enter to continue.");
    }

    private void viewAll() {//returning(String, Integer, List, ect) element(current__): arrayName
        List<DVD> allDvds = dvdList.listAll();
        con.print("You have " + allDvds.size() + " DVD entries:");//size v length
        for (DVD currentDVD : allDvds) {
            String printNotes = "";
//            for (String s : currentDVD.getNote()) {
//                printNotes += s + "\n";
//            }

            con.print(currentDVD.getTitle());
            con.print(currentDVD.getReleaseDate().toString());
            con.print(currentDVD.getMpaaRating());
            con.print(currentDVD.getDirector());
            con.print(currentDVD.getStudio());
            con.print(printNotes);
            con.print("");
        }
        con.readString("Please hit enter to continue");
    }

//    public void writeDVDs() throws IOException {
//        dvdlib.writeDVDs();
//    }
    /////LAMBDA-SEARCH Interface LAMBDA-SEARCH Interface LAMBDA-SEARCH Interface LAMBDA-SEARCH Interface
//    private void searchByName(String name) {
//        DVD currentDVD = dvdlib.searchByName(name);
//
//        if (currentDVD != null) {
//            String printNotes = "";
//            for (String s : notes) {
//                printNotes += s + "\n";
//            }
//            con.print(currentDVD.getName());
//            con.print(currentDVD.getDate());
//            con.print(currentDVD.getRating());
//            con.print(currentDVD.getDirector());
//            con.print(currentDVD.getStudio());
//            con.print(printNotes);
//            con.print("");
//        } else {
//            con.print("No entry was found for " + name);
//        }
//        con.readString("Please hit enter to continue.");
//    }
//
//    private void searchByDate(String date) {
//        List<DVD> dvds = dvdlib.searchByDate(date);
//
//        dvds
//                .stream()
//                .filter(s -> s.getDate().equalsIgnoreCase(date))
//                .forEach(currentDVD -> {
//                    con.print(currentDVD.getName());
//                    con.print(currentDVD.getDate());
//                    con.print(currentDVD.getRating());
//                    con.print(currentDVD.getDirector());
//                    con.print(currentDVD.getStudio());
//                    String printNotes = "";
//                    for (String s : notes) {
//                        printNotes += s + "\n";
//                    }
//                    con.print(printNotes);
//                    con.print("");
//
//                });
//
//    }
//
//    private void searchByRating(String rating) {
//
//        List<DVD> dvds = dvdlib.searchByRating(rating);
//
//        dvds
//                .stream()
//                .filter(s -> s.getRating().equalsIgnoreCase(rating))
//                .forEach(currentDVD -> {
//                    con.print(currentDVD.getName());
//                    con.print(currentDVD.getDate());
//                    con.print(currentDVD.getRating());
//                    con.print(currentDVD.getDirector());
//                    con.print(currentDVD.getStudio());
//                    String printNotes = "";
//                    for (String s : notes) {
//                        printNotes += s + "\n";
//                    }
//                    con.print(printNotes);
//                    con.print("");
//
//                });
//
//    }
//
//    private void searchByDirector(String director) {
//
//        Map<String, List<DVD>> dvds = dvdlib.searchByDirector(director);
//        dvds.values()
//                .stream()
//                .forEach(f -> {
//                    f.stream()
//                    .forEach(currentDVD -> {
//                        con.print(currentDVD.getName());
//                        con.print(currentDVD.getDate());
//                        con.print(currentDVD.getRating());
//                        con.print(currentDVD.getDirector());
//                        con.print(currentDVD.getStudio());
//                        String printNotes = "";
//                        for (String s : notes) {
//                            printNotes += s + "\n";
//                        }
//                        con.print(printNotes);
//                        con.print("");
//
//                    }
//                    );
//                }
//                );
//    }
//
//    private void searchByStudio(String studio) {
//
//        List<DVD> dvds = dvdlib.searchByStudio(studio);
//
//        dvds
//                .stream()
//                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
//                .forEach(currentDVD -> {
//                    con.print(currentDVD.getName());
//                    con.print(currentDVD.getDate());
//                    con.print(currentDVD.getRating());
//                    con.print(currentDVD.getDirector());
//                    con.print(currentDVD.getStudio());
//                    String printNotes = "";
//                    for (String s : notes) {
//                        printNotes += s + "\n";
//                    }
//                    con.print(printNotes);
//                    con.print("");
//
//                });
//
//    }
    private void getStats() {
//        dvdlib.getAvgAge();

//average age of movies
//newest movie
//oldest movie
//average number of notes
    }
}
