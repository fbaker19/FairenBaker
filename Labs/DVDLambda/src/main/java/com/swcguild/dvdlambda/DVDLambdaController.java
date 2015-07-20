/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlambda;

//import com.swcguild.dvdlibraryweb.model.LibraryLambda;
/*import swcguild.dvdlibraryweb.dao.DVDLibraryImpl;
import swcguild.dvdlibraryweb.dao.Library;*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*
 1.add in refactored console IO & DAO/fileholder
 ///place in the global scope/outside public void run

 2. Inside the 'run method',create int variable (ex. int menuSelection) for switch case>>> switch(variable){}
 -create switch case(make sure 'case' is lowercase

 3. create a 'menu' method based off of switch 
 -ex) private void printMenu(){
 con.print("press 1 for blah blah blah");
 }

 4. Place switch case inside a while loop. ex) while(varExamp){run switch case...}
 - break th loop by makin the condition/boolean expression false 
 -ex. varExamp = false;---see case 7

 5. create methods out of the run method, but inside the class. Base methods off of switch case
 -ie private void addDvd(){}

 6.add"try catch" aroung while loop/switch case to catch FILEIO exceptions for writing/loading file
 7. call Writer -"library.writeLibrary();" above the "catch"

 */
public class DVDLambdaController {

    private ConsoleIO con = new ConsoleIO(); //1 add in refactored console IO
    private Library libraryDao = (Library) new DVDLibraryImpl();// add in DAO/fileholder>>Lambda use "impl"

    Integer Id;

    public void run() {

        boolean keepGoing = true; //new variables << for while loop
        int menuSelection = 0; //new variables <<<used for switch

        try {
            libraryDao.loadLibraryLambda();

            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("please select from the above choices.", 1, 7);

                switch (menuSelection) {
                    case 1:
                        con.print("Adding DVD...");
                        addDvd();
                        libraryDao.writeLibraryLambda();
                        break;

                    case 2:
                        con.print("Removing DVD....");
                        removeDvd();
                        break;

                    case 3:
                        con.print("Searching for DVD...");
                        //searchDvd();
                        break;

                    case 4:
                        con.print("Displaying DVD information....");
                        displayDvd();
                        break;

                    case 5:
                        con.print("editing DVD...");
                        editDvd();
                        libraryDao.writeLibraryLambda();
                        break;

                    case 6:
                        con.print("view ALL Dvds.....");
                        viewAll();
                        break;

                    case 7:
                        con.print("Goodbye!!");
                        keepGoing = false;// breaks the loop by making the condition false
                        break;

                    default:
                        con.print("Unknown input");

                }
            }
            //Call Writer >>> write to file
            //try catch added
            libraryDao.writeLibraryLambda();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading file");
        } catch (IOException e) {
            System.out.println("Error writing the file");
        }

    }

    private void printMenu() {
        con.print("Please choose 1 to add DVD");
        con.print("Please choose 2 to remove DVD");
        con.print("Please choose 3 to search for DVD");
        con.print("Please choose 4 to display all DVD information");
        con.print("Please choose 5 to edit DVD");
        con.print("Please choose 6 to view all DVDs in the library");
        con.print("Please choose 7 to Exit");

    }

    public void addDvd() throws IOException {
        String title = con.readString("Please enter movie title");
        String director = con.readString("Please enter movie director");
        int year = con.readInt("Please enter the year the movie was released");
        String mpaa = con.readString("Please enter MPAA rating");
        String studio = con.readString("Please enter movie studio");
        float userRating = con.readFloat("Please enter user rating of the movie");

        LibraryLambda currentLibrary = new LibraryLambda(Id);//imports DTO

        currentLibrary.setTitle(title);
        currentLibrary.setDirector(director);
        currentLibrary.setYear(year);
        currentLibrary.setMpaa(mpaa);
        currentLibrary.setRating(userRating);//user rating
        currentLibrary.setStudio(studio);

        con.readString("DVD entry successfully created. Please hit enter to continue");

        Id = libraryDao.addDvd(currentLibrary);

        System.out.println("your id  number is: " + Id);

        libraryDao.writeLibraryLambda();
    }

    public void displayDvd() {
      Integer ID = con.readInt("Please enter the ID of the movie you wish to view");
        List<LibraryLambda> currentLibrary = libraryDao.searchById(ID);
        if (currentLibrary.size()>0) {
            con.print(currentLibrary.get(0).getTitle());//pullint from the index section of array list(ALWAYS 0 - searching by Id)
            con.print(currentLibrary.get(0).getDirector());
            con.printInt(currentLibrary.get(0).getYear());//added to console IO
            con.print(currentLibrary.get(0).getMpaa());
            con.printFloat(currentLibrary.get(0).getRating());//user rating -- added to console IO
            con.print(currentLibrary.get(0).getStudio());

        } else {
            con.print("No DVD with this: " + ID);

        }
    }

    public void removeDvd() {
        String title = con.readString("Please enter the ID of the student to be removed");
        libraryDao.removeTitle(Id);
        con.readString("DVD successfully removed. Please hit to continue.");
    }

    public void editDvd() {
        Id = con.readInt("Please enter the ID number of the DVD you would like to edit");
        String title = con.readString("Please enter movie title you would like to edit");
        String director = con.readString("Please enter the new director ");
        int year = con.readInt("Please enter the year to be edited");
        String mpaa = con.readString("Please enter movie rating  you would like to edit");
        String studio = con.readString("Please enter movie studio you would like to edit");
        float userRating = con.readFloat("Please enter new user rating.");

        LibraryLambda currentLibrary = new LibraryLambda(title);//imports DTO
        currentLibrary.setDirector(director);
        currentLibrary.setYear(year);
        currentLibrary.setMpaa(mpaa);
        currentLibrary.setRating(userRating);//user rating
        currentLibrary.setStudio(studio);

        libraryDao.getTitle(Id);
        //(currentLibrary.getId(), currentLibrary);

    }

    public void viewAll() {
        List<LibraryLambda> title = libraryDao.getAllTitles();
        for (LibraryLambda currentLibrary : title) {

            con.print(title.get(Id) + ": " + currentLibrary.getTitle() + " " + currentLibrary.getDirector() + " "
                    + currentLibrary.getYear());
        }

        con.readString("Please hit enter to continue");

    }

    public void exit() {

    }

}
