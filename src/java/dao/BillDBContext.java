/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.Owner;

/**
 *
 * @author ADMIN
 */
public class BillDBContext extends DBContext {

    public ArrayList<Bill> getBill(int month, int year) {

        ArrayList<Bill> bills = new ArrayList<>();
        try {

            String sql = "SELECT B.bid, B.cname, B.componentCategory, B.unitprice, B.quantity, B.totalMoney, B.inputDate, B.supplierName, B.address, B.contact, B.origin, B.oname, O.[password] \n"
                    + "FROM owner O INNER JOIN Bill B ON O.oname = B.oname ";
            //check if owner search one year
            if (year > 0) {
                sql += " WHERE YEAR(B.inputDate) = ? ";
                //check if owner search data in the year
                if (month > 0) {
                    sql += " and MONTH(B.inputDate) = ?";
                }

            }

            PreparedStatement stm = connection.prepareStatement(sql);

            //set month to search when user select a month
            if (month > 0) {
                stm.setInt(1, year);
                stm.setInt(2, month);
            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getString("cname"));
                b.setCategory(rs.getString("componentCategory"));
                b.setUnitPrice(rs.getInt("unitprice"));
                b.setQuantity(rs.getInt("quantity"));
                b.setTotal(rs.getInt("totalMoney"));
                b.setInputDate(rs.getDate("inputDate"));
                b.setSupplierName(rs.getString("supplierName"));
                b.setAddress(rs.getString("address"));
                b.setContact(rs.getString("contact"));
                b.setOrigin(rs.getString("origin"));

                Owner o = new Owner();
                o.setOname(rs.getString("oname"));
                o.setPassword(rs.getString("password"));

                b.setOwner(o);

                bills.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;

    }
}
