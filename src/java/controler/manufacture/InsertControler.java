/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.manufacture;

import controler.account.BaseAuthenticationControler;
import dao.ManufactureDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.ManufactureDetail;
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
        HttpSession session = request.getSession();
        
        int bid = (int) session.getAttribute("bid");
        String raw_mid = request.getParameter("mid");
        String raw_producted = request.getParameter("producted");
        String raw_removed = request.getParameter("removed");
        String raw_outdate = request.getParameter("outputdate");
        String raw_wid = request.getParameter("wid");
        
        String mid = raw_mid;
        int producted = Integer.parseInt(raw_producted);
        int removed = Integer.parseInt(raw_removed);
        Date outdate = Date.valueOf(raw_outdate);
        int wid = Integer.parseInt(raw_wid);
        
        Bill b = new Bill();
        b.setBid(bid);
        
        Worker w = new Worker();
        w.setWid(wid);
        
        ManufactureDetail detail = new ManufactureDetail();
        detail.setOrderID(mid);
        detail.setProducted(producted);
        detail.setRemoved(removed);
        detail.setOutputDate(outdate);
        detail.setBill(b);
        detail.setWorker(w);
        
        ManufactureDBContext manuDB = new ManufactureDBContext();
        manuDB.insertManuDetails(detail);
        
        
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
