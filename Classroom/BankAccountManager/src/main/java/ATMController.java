
import com.swcguild.bankaccountmanager.Console;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class ATMController {

    Console con = new Console();

    public void run() {

        int pin = 12345;

        con.print("WELCOME TO THE BANK.");
        con.readInt("ENTER YOUR PIN: ");

        con.print("hello");

        int entry = 0;

        while (entry != pin) {

            con.readString("\nINCORRECT PIN. TRY AGAIN.");
            con.readInt("ENTER YOUR PIN: ");
            entry = con.readInt("");
        }

        con.readString("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");

        boolean keepGoing = true;
        int menuSelection = 0;

       // try {
        //roster.loadRoster();
        while (keepGoing) {
            printMenu();
            menuSelection = con.readInt("please select fromt the above choices.", 1, 4);

            switch (menuSelection) {

                case 1:
                    con.print("View account information...");
                    //viewAccount();
                    break;
                case 2:
                    con.print("Withdrawing amount to account ...");
                    // withdraw();
                    break;
                case 3:
                    con.print("adding amount to account...");
                    //deposit();
                    break;

                case 4:
                    con.print("Exit");
                    keepGoing = false;
                    break;

                default:
                    con.print("Unknown input");
            }

        }
//            con.print("Thank you");
//            //roster.writeRoster();
//        } catch (FileNotFoundException e) {
//            System.out.println("Error loading roster");
//        } catch (IOException e) {
//            System.out.println("Error writing the file");
//        }

    }

    private void printMenu() {
        con.print("Main Menu");
        con.print("1.View account");
        con.print("2.Withdraw from account");
        con.print("3.add to account");
        con.print("4.Exit");

    }
}
