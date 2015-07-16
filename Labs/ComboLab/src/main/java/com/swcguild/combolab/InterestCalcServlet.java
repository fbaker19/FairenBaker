package com.swcguild.combolab;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InterestCalc", urlPatterns = {"/InterestCalcServlet"})
public class InterestCalcServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("interest.jsp");//place in ROOT (WEB)
        rd.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//Initial amount of principal:
        float originalBalance = Float.parseFloat(request.getParameter("originalBalance"));//user input
        float currentBalance;

        //The number of years the money is to stay in the fund:
        float numYears = Float.parseFloat(request.getParameter("numYears")); //user input

        float numPeriods=Float.parseFloat(request.getParameter("numPeriods")); //user input
        //Annual interest rate:
        float intRate = Float.parseFloat(request.getParameter("intRate")); //user input

        float annualInterest;

        //Year end new balance:
        float newBalance;
        String message = "";
      //message.append("Your cost without labor is: $<b>" + cost.format(totalCostWithoutLabor) + "</b><br/>");

        int yearCount = 0;

        do {

            newBalance = (float) (originalBalance * (Math.pow(1 + ((intRate * .01) / numPeriods), (numPeriods))));
            annualInterest = (newBalance - originalBalance);
            yearCount++;
            message += "Year " + yearCount;
            message += " - Principal at start of year: "+ originalBalance;
            message += "  Interest earned this year:" + annualInterest;
            message +=  "Principal at end of year:" + newBalance;
           

            originalBalance = newBalance;
        } while (yearCount <= (numYears - 1));

            request.setAttribute("message", message);//"how it's written in the HTML RESPONSE file ${}"
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp"); // Pulling the Java method ${}
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
