/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.account;

import dao.GroupDBContext;
import dao.OwnerDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Group;
import model.Owner;

/**
 *
 * @author ADMIN
 */
public class AccountRegisterControler extends HttpServlet {

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
        
        GroupDBContext db = new GroupDBContext();
        ArrayList<Group> groups = db.getGroups();
        
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("../view/account/register.jsp").forward(request, response);
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
        
        String raw_user = request.getParameter("username");
        String raw_pass = request.getParameter("password");
        String raw_email = request.getParameter("email");
        String raw_group = request.getParameter("group");
        
        String username = raw_user;
        String password = raw_pass;
        String email = raw_email;
        
        int gid = Integer.parseInt(raw_group);
        
        Owner o = new Owner();
        o.setOname(username);
        o.setPassword(password);

        GroupDBContext db = new GroupDBContext();
        db.insertAccount(o);
        db.insertAG(o, gid);
        response.sendRedirect("login");
//        response.sendRedirect("");
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
