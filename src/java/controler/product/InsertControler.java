/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.product;

import dao.BillDBContext;
import dao.OwnerDBContext;
import dao.ProductDBContext;
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
import model.Owner;
import model.Product;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class InsertControler extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        WorkerDBContext workerDB = new WorkerDBContext();
        ArrayList<Worker> workers = workerDB.getWorkers();
        request.setAttribute("workers", workers);
        request.getRequestDispatcher("../view/product/insert.jsp").forward(request, response);
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
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String raw_pid = request.getParameter("pid");
        String raw_pname = request.getParameter("pname");
        String raw_category = request.getParameter("category");
        String raw_model = request.getParameter("model");
        String raw_price = request.getParameter("price");
        String raw_manuDate = request.getParameter("manufactureDate");
        String raw_expireDate = request.getParameter("expireDate");
        String raw_guid = request.getParameter("guid");
        String raw_wid = request.getParameter("wid");
         
        int pid = Integer.parseInt(raw_pid);
        String pname = raw_pname;
        String category = raw_category;
        String model = raw_model;
        int price = Integer.parseInt(raw_price);
        Date manufactureDate = Date.valueOf(raw_manuDate);
        Date expireDate = Date.valueOf(raw_expireDate);
        String guid = raw_guid;
        int wid = Integer.parseInt(raw_wid);
        
        Worker w = new Worker();
        w.setWid(wid);        
        
        Product p = new Product();
        p.setPid(pid);
        p.setPname(pname);
        p.setCategory(category);
        p.setModel(model);
        p.setPrice(price);
        p.setManufactureDate(manufactureDate);
        p.setExpireDate(expireDate);
        p.setGuid(guid);
        
        p.setWorker(w);
        ProductDBContext productDB = new ProductDBContext();
        productDB.insertProduct(p);
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
