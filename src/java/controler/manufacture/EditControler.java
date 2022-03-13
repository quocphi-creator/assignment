/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.manufacture;

import controler.account.BaseAuthenticationControler;
import dao.BillDBContext;
import dao.ManufactureDBContext;
import dao.WorkerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.ManufactureDetail;
import model.Owner;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class EditControler extends BaseAuthenticationControler {

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
        
        String mid = request.getParameter("mid");
        mid = mid.trim();
        
        ManufactureDBContext manuDB = new ManufactureDBContext();
        ManufactureDetail manuDetail = manuDB.getDetail(mid);
        request.setAttribute("detail", manuDetail);
        
        BillDBContext billDB = new BillDBContext();
        ArrayList<Bill> bills = billDB.getBills();
        request.setAttribute("bills", bills);
        
        WorkerDBContext workerDB = new WorkerDBContext();
        ArrayList<Worker> workers = workerDB.getWorkers();
        request.setAttribute("workers", workers);
        
        request.getRequestDispatcher("../view/manufacture/edit.jsp").forward(request, response);
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
        
        String raw_mid = request.getParameter("mid");
        String raw_bid = request.getParameter("bid");
        String raw_producted = request.getParameter("producted");
        String raw_removed = request.getParameter("removed");
        String raw_outdate = request.getParameter("outputdate");
        String raw_wid = request.getParameter("wid");
        
        String mid = raw_mid;
        int bid = Integer.parseInt(raw_bid);
        int producted = Integer.parseInt(raw_producted);
        int removed = Integer.parseInt(raw_removed);
        Date outdate = Date.valueOf(raw_outdate);
        int wid = Integer.parseInt(raw_wid);
        
        Bill b = new Bill();
        b.setBid(bid);
        
        Worker w = new Worker();
        w.setWid(wid);
        
        ManufactureDetail m = new ManufactureDetail();
        m.setBill(b);
        m.setWorker(w);
        m.setOrderID(mid);
        m.setOutputDate(outdate);
        m.setProducted(producted);
        m.setRemoved(removed);
        
        ManufactureDBContext manuDB = new ManufactureDBContext();
        manuDB.updateDetail(m);
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
