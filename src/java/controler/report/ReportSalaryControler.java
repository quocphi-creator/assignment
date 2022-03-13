/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.report;

import controler.account.BaseAuthenticationControler;
import dao.ReportDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ReportWorkerSalary;

/**
 *
 * @author ADMIN
 */
public class ReportSalaryControler extends BaseAuthenticationControler {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String raw_ym = request.getParameter("month");
        if (raw_ym==null || raw_ym.length()==0) {
            raw_ym = "0001-01";
        }
        YearMonth ym = YearMonth.parse(raw_ym);
        int year = ym.getYear();
        int month = ym.getMonth().getValue();
        
        ReportDBContext reportDB = new ReportDBContext();
        ArrayList<ReportWorkerSalary> salary = reportDB.getSalaries(month, year);
        
        request.setAttribute("salary", salary);
        request.setAttribute("ym", ym);
        request.getRequestDispatcher("../view/report/salary.jsp").forward(request, response);
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
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
