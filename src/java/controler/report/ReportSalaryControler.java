/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.report;

import controler.account.BaseAuthenticationControler;
import dao.BillDBContext;
import dao.ProductDBContext;
import dao.ReportDBContext;
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
import model.ReportInventory;
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
        
        ReportDBContext reportDB = new ReportDBContext();
        ArrayList<ReportWorkerSalary> salary = reportDB.getSalaries(getMonth, getYear);
        request.setAttribute("salary", salary);
        
        int totalSalary = 0;
        for (ReportWorkerSalary w : salary) {
            totalSalary += w.getWorker().getMonthSalary() + w.getWorker().getProductSalary() + w.getCount();
        }
        request.setAttribute("totalSalary", totalSalary);
        
        BillDBContext billDB = new BillDBContext();
        ArrayList<Bill> bills = billDB.getBills(getMonth, getYear);
        request.setAttribute("bills", bills);
        
        int totalCost = 0;
        for (Bill bill : bills) {
            totalCost += bill.getTotal();
        } 
        request.setAttribute("totalCost", totalCost);
        
        
        ProductDBContext productDB = new ProductDBContext();
        ArrayList<Product> products = productDB.getProducts(getMonth, getYear);
        request.setAttribute("products", products);
        
        int totalProduct = 0;
        for (Product p : products) {
            totalProduct += p.getPrice();
        }
        request.setAttribute("totalProduct", totalProduct);
        
        ArrayList<ReportInventory> wastes = reportDB.getWastes(getMonth, getYear);
        request.setAttribute("wastes", wastes);
        int totalWaste = 0;
        for (ReportInventory waste : wastes) {
            totalWaste += waste.getRemoved() * waste.getBill().getUnitPrice();
        }
        request.setAttribute("totalWaste", totalWaste);
        
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
