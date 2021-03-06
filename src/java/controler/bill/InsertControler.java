/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.bill;

import controler.account.BaseAuthenticationControler;
import dao.BillDBContext;
import dao.OwnerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.Owner;

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
        OwnerDBContext ownerDB = new OwnerDBContext();
        ArrayList<Owner> ownerList = ownerDB.getOwnerList();
        request.setAttribute("ownerList", ownerList);
        request.getRequestDispatcher("../view/bill/insert.jsp").forward(request, response);

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
        String raw_bid = request.getParameter("bid");
        String raw_cname = request.getParameter("cname");
        String raw_category = request.getParameter("category");
        String raw_quantity = request.getParameter("quantity");
        String raw_unitprice = request.getParameter("unitprice");
        String raw_total = request.getParameter("total");
        String raw_inputdate = request.getParameter("inputDate");
        String raw_origin = request.getParameter("origin");
        String raw_supplier = request.getParameter("supplier");
        String raw_contact = request.getParameter("contact");
        String raw_address = request.getParameter("address");
        String raw_oname = request.getParameter("oname");

        int bid = Integer.parseInt(raw_bid);
        String cname = raw_cname;
        String category = raw_category;
        int quantity = Integer.parseInt(raw_quantity);
        int unitprice = Integer.parseInt(raw_unitprice);
        int total = Integer.parseInt(raw_total);
        Date inputDate = Date.valueOf(raw_inputdate);
        String origin = raw_origin;
        String supplier = raw_supplier;
        String contact = raw_contact;
        String address = raw_address;
        String oname = raw_oname;

        Owner o = new Owner();
        o.setOname(oname);

        Bill b = new Bill();
        b.setBid(bid);
        b.setCname(cname);
        b.setCategory(category);
        b.setQuantity(quantity);
        b.setUnitPrice(unitprice);
        b.setTotal(total);
        b.setInputDate(inputDate);
        b.setOrigin(origin);
        b.setSupplierName(supplier);
        b.setContact(contact);
        b.setAddress(address);
        b.setOwner(o);

        BillDBContext db = new BillDBContext();
        db.insertBill(b);

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
