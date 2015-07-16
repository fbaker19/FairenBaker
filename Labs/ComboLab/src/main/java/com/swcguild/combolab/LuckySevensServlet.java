/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.combolab;

import java.io.IOException;
import static java.lang.Integer.min;
import static java.lang.Math.min;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "LuckySevensServlet", urlPatterns = {"/LuckySevensServlet"})
public class LuckySevensServlet extends HttpServlet {

    private Random die = new Random();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("lucky.jsp");//place in ROOT (WEB)
        rd.forward(request, response);

    }

    //URL
    //POST  METHODS  ARE USED FOR USER INPUT
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "";
        int die1Num= 0; //nouns
        int die2Num = 0;
        int dollars = Integer.parseInt(request.getParameter("dollars"));         // initial number of dollars (input)
        int countRolls = 0;
        int maxDollars = 0 ;       // maximum amount held user/new number of dollars
        int countMaxRolls =0;
        int min = 0;///??????????
        int userInput =0 ;

    //count down until player does not have any more $$$   
        boolean done = false;
        while (!done) {
            try {
                do {
                    message += " [minimum $" + min + "]";
                    System.out.print("$");
                    
                } while (userInput < min);
                done = true;
            } catch (Exception e) {
                message += "Invalid input, please try again\n";
            }
        }

        message+= "How much money do you have?"; //prompt readUserInputIntRange("How much money do you have?",1); 
        maxDollars = dollars;
        while (dollars > 0) //<---condition
        {
            countRolls++;
            die1Num = die.nextInt(6) + 1;
            die2Num = die.nextInt(6) + 1;
            //  winnings or loses
            if (die1Num + die2Num == 7) {
                dollars += 4;
            } else {
                dollars -= 1;
            }

            // New maxumin of  $$$  
            if (dollars > maxDollars) {
                maxDollars = dollars;
                countMaxRolls = countRolls;
            }
        }

        // Display the results
        System.out.println("You are broke after " + countRolls + " rolls. "
                + "You should have quit after " + countMaxRolls
                + " rolls when you had $" + maxDollars);

        request.setAttribute("message", message);//"how it's written in the HTML RESPONSE file ${}"
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp"); // Pulling the Java method ${}
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
