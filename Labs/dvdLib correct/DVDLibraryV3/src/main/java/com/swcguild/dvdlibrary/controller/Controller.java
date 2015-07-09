/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.controller;

import com.swcguild.dvdlibrary.dao.DVDLibrary;
import static com.swcguild.dvdlibrary.dao.DVDLibrary.DVDLIB_FILE;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.ui.Console;
import com.swcgulid.dvdlibrary.dto.Dvd;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class Controller {
    private DvdLibraryDao dao;
    
    public Controller(DvdLibraryDao dao)////constructor
    {
        this.dao = dao;
    
    }

    DVDLibrary dvdlib = new DVDLibrary();
    Console con = new Console();
    ArrayList<String> notes = new ArrayList();

    public Controller() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    public void run() {

        boolean keepOnTruckin = true;
        int menuSelection = 0;

        try {
            dvdlib.loadDVDLibrary();
            while (keepOnTruckin) {
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
                        viewDVD();
                        break;
                    case 5:
                        con.print("Viewing all DVDs...");
                        viewAll();
                        break;
                    case 6:
                        con.print("Exiting...");
                        writeDVDs();
                        keepOnTruckin = false;
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

    private void addDVD() throws IOException {
        String name = con.readString("Please enter the name of the DVD");
        String date = con.readString("Please enter the year of release");
        String rating = con.readString("Please enter the MPAA rating");
        String director = con.readString("Please enter the name of the director");
        String studio = con.readString("Please enter the name of the studio");
        notes = addNote();
        Dvd currentDVD = new Dvd(name);
        currentDVD.setName(name);
        currentDVD.setDate(date);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setNotes(notes);
        dvdlib.addDVD(name, currentDVD);
        con.readString("DVD successfully added.  Please hit enter to continue.");
    }

    private ArrayList addNote() throws IOException {

        String next = "";
        while (!"n".equals(next)) {
            String note = con.readString("Please enter your note about the DVD");
            notes.add(note);
            next = con.readString("Would you like to add another note? y or n?");
        }
        return notes;
    }

    private void removeDVD() throws FileNotFoundException, IOException {
        String name = con.readString("Which DVD entry would you like to remove?");
        dvdlib.removeDVD(name);
        con.readString("You have successfully removed this DVD entry.  Please hit enter to continue.");
    }

    private void viewDVD() {
        String name = con.readString("For which DVD would you like to view the entry?");
        Dvd currentDVD = dvdlib.getDVD(name);
        if (currentDVD != null) {
            String printNotes = "";
            for (String s : notes) {
                printNotes += s + "\n";
            }
            con.print(currentDVD.getName());
            con.print(currentDVD.getDate());
            con.print(currentDVD.getRating());
            con.print(currentDVD.getDirector());
            con.print(currentDVD.getStudio());
            con.print(printNotes);
            con.print("");
        } else {
            con.print("No entry was found for " + name);
        }
        con.readString("Please hit enter to continue.");
    }

    private void editDVD() throws IOException {
        String name = con.readString("Which DVD entry would you like to edit?");
        Dvd currentDVD = dvdlib.getDVD(name);
        if (currentDVD != null) {
            String printNotes = "";
            for (String s : notes) {
                printNotes += s + "\n";
            }
            con.print("Current name: " + currentDVD.getName());
            String x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                name = con.readString("Enter new name");
                currentDVD.setName(name);
                con.print("New name: " + name);
            }

            con.print("Current year of release: " + currentDVD.getDate());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String date = con.readString("Enter new year of release");
                currentDVD.setDate(date);
                con.print("New year of release: " + date);
            }

            con.print("Current MPAA rating: " + currentDVD.getRating());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String rating = con.readString("Enter new MPAA rating");
                currentDVD.setRating(rating);
                con.print("New MPAA rating: " + rating);
            }

            con.print("Current name of the director: " + currentDVD.getDirector());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String director = con.readString("Enter new name of the director");
                currentDVD.setDirector(director);
                con.print("New name of the director: " + director);
            }

            con.print("Current name of the studio: " + currentDVD.getStudio());
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                String studio = con.readString("Enter new name of the studio");
                currentDVD.setStudio(studio);
                con.print("New name of the studio: " + studio);
            }

            con.print("Current notes: " + printNotes);
            x = con.readString("Would you like to change this value? y or n?");
            if (!"n".equals(x)) {
                con.print("Enter new note");
                addNote();
                con.print("");
            }
        } else {
            con.print("No entry was found for " + name);
        }
        con.readString("Please hit enter to continue.");
    }

    private void viewAll() {
        String[] allDVDs = dvdlib.getAllDVDs();
        for (int i = 0; i < allDVDs.length; i++) {
            Dvd currentDVD = dvdlib.getDVD(allDVDs[i]);
            String printNotes = "";
            for (String s : notes) {
                printNotes += s + "\n";
            }
            con.print("You have " + allDVDs.length + " DVD entries:");
            con.print(currentDVD.getName());
            con.print(currentDVD.getDate());
            con.print(currentDVD.getRating());
            con.print(currentDVD.getDirector());
            con.print(currentDVD.getStudio());
            con.print(printNotes);
            con.print("");
        }
        con.readString("Please hit enter to continue");
    }

    public void writeDVDs() throws IOException {
        dvdlib.writeDVDs();
    }
}
