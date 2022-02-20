/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.bill;

import com.sun.faces.util.CollectionsUtils;
import dao.BillDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;

/**
 *
 * @author ADMIN
 */
public class SearchControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String raw_year = request.getParameter("year");
        String raw_month = request.getParameter("month");
        raw_year = (raw_year==null || raw_year.length()==0)?"-1":raw_year;
        raw_month = (raw_month==null || raw_month.length()==0)?"-1":raw_month;
        
        int year = Integer.parseInt(raw_year);
        int month = Integer.parseInt(raw_month);
        
        BillDBContext billDB = new BillDBContext();
        ArrayList<Bill> bills = billDB.getBill(month, year);
        
        ArrayList<Integer> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthList.add(i);
        }
        request.setAttribute("monthList", monthList);
        request.setAttribute("bills", bills);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        request.getRequestDispatcher("../view/bill/search.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
