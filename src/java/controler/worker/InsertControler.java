/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.worker;

import controler.account.BaseAuthenticationControler;
import dao.WorkerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Owner;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class InsertControler extends BaseAuthenticationControler {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        request.getRequestDispatcher("../view/worker/insert.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String raw_wid = request.getParameter("wid");
        String raw_wname = request.getParameter("wname");
        String raw_phoneNumber = request.getParameter("phoneNumber");
        String raw_monthSalary = request.getParameter("monthSalary");
        String raw_productSalary = request.getParameter("productSalary");
        
        int wid = Integer.parseInt(raw_wid);
        String wname = raw_wname;
        String phoneNumber = raw_phoneNumber;
        int monthSalary = Integer.parseInt(raw_monthSalary);
        int productSalary = Integer.parseInt(raw_productSalary);
        
        Worker w = new Worker();
        
        w.setWid(wid);
        w.setWname(wname);
        w.setPhoneNumber(phoneNumber);
        w.setMonthSalary(monthSalary);
        w.setProductSalary(productSalary);
        
        WorkerDBContext workerDB = new WorkerDBContext();
        workerDB.insertWorker(w);
        response.sendRedirect("search");
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
