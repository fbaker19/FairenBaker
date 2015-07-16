package com.swcguild.combolab;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FactorizorServlet", urlPatterns = {"/FactorizorServlet","/"})
public class FactorizorServlet extends HttpServlet {//SERVLET IS A POJO- Plain Old Java

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
        RequestDispatcher rd = request.getRequestDispatcher("factor.jsp");
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
        
        int inputNum = Integer.parseInt(request.getParameter("inputNum"));
        int sumOfFactors =0 ;
        String message ="";//intialize variable
        
        message += "Please enter the number you want to factor:" ;
        
        message += (Integer.parseInt("You entered " + inputNum));
       
        message += ("The factors of " + inputNum + " are: ");
      
         for (int i = 1; i < inputNum; i++) {
            if (inputNum % i == 0) {
                System.out.println(i);
                sumOfFactors = sumOfFactors + i;
            }
        }
        //message = (Integer.parseInt(inputNum));

        if (sumOfFactors == inputNum) {
             message +=(inputNum + " is a perfect number");
        } else {
             message += (inputNum + " is not a perfect number");
        }

        if (sumOfFactors == 1) {
            message += (inputNum + " is a prime number");
        } else {
             message += (inputNum + " is not a prime number");
        }


        request.setAttribute("message", message);
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
    }// </editor-fold>
}