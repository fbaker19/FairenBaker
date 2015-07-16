package com.swcguild.combolab;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
@WebServlet(name = "FloorCalcServlet", urlPatterns = {"/FloorCalcServlet"})
public class FloorCalcServlet extends HttpServlet {
   
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
        RequestDispatcher rd = request.getRequestDispatcher("floor.jsp");//place in ROOT (WEB)
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
    float width = Float.parseFloat(request.getParameter("width"));
    float length =Float.parseFloat(request.getParameter("length"));    
    
   float  sqFtPerQt = 5;//sqft==area
   float costPerQt = (float) 21.5;
   
   String message ="";
  
    //every 15 min -  put down 5 sqft
    //5sqft = 21.50 per 15min
    
    
    message +="Enter the length of room: ";
    message +="Enter the width of room: ";
     
    float area = (length*width);
  
    
    message +="Your area is: "+area;
//   
//    if(area <=4)
//    {
//        System.out.println( Math.floor(area));
//    }else{
//        System.out.println( Math.ceil(area));
//    }
 
    
    float newArea = (float) (5*(Math.ceil(Math.abs(area/5))));///rounds to nearest whole number then * by 5
      message+= "at new area: " + newArea;  
    
        
    float totalCost = (newArea*costPerQt)/5;///divideds cost by quarter
    
        message+="total cost is: "+totalCost;
         
        
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

    

