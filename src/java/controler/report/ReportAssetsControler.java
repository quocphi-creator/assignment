/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.report;

import dao.BillDBContext;
import dao.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ReportAssetsControler extends HttpServlet {

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
        YearMonth ym = null;
        int getMonth;
        int getYear;
        String raw_ym = request.getParameter("month");
        if (raw_ym == null || raw_ym.length() == 0) {
            ym = ym.parse("0001-01");
            getMonth = -1;
            getYear = -1;
        } else {
            ym = YearMonth.parse(raw_ym);
            getYear = ym.getYear();
            getMonth = ym.getMonth().getValue();

        }

        ProductDBContext productDB = new ProductDBContext();
        ArrayList<Product> products = productDB.getProducts(getMonth, getYear);

        int totalAssets = 0;
        for (Product product : products) {
            totalAssets += product.getPrice();
        }
        
        request.setAttribute("total", totalAssets);
        request.setAttribute("products", products);
        request.setAttribute("ym", ym);
        
        request.getRequestDispatcher("../view/report/assets.jsp").forward(request, response);
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
