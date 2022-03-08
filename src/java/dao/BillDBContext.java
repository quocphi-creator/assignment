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
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class BillDBContext extends DBContext {

    public ArrayList<Bill> getBills(int month, int year) {

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

    public void insertBill(Bill b) {
        String sql = "INSERT INTO [Bill]\n"
                + "           ([bid]\n"
                + "           ,[cname]\n"
                + "           ,[componentCategory]\n"
                + "           ,[unitprice]\n"
                + "           ,[quantity]\n"
                + "           ,[totalMoney]\n"
                + "           ,[inputDate]\n"
                + "           ,[supplierName]\n"
                + "           ,[address]\n"
                + "           ,[contact]\n"
                + "           ,[origin]\n"
                + "           ,[oname])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, b.getBid());
            stm.setString(2, b.getCname());
            stm.setString(3, b.getCategory());
            stm.setInt(4, b.getUnitPrice());
            stm.setInt(5, b.getQuantity());
            stm.setInt(6, b.getTotal());
            stm.setDate(7, b.getInputDate());
            stm.setString(8, b.getSupplierName());
            stm.setString(9, b.getAddress());
            stm.setString(10, b.getContact());
            stm.setString(11, b.getOrigin());
            stm.setString(12, b.getOwner().getOname());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public Bill getBill(int bid) {
        try {

            String sql = "SELECT B.bid, B.cname, B.componentCategory, B.unitprice, B.quantity, B.totalMoney, B.inputDate, B.supplierName, B.address, B.contact, B.origin, B.oname, O.[password] \n"
                    + "FROM owner O INNER JOIN Bill B ON O.oname = B.oname where [B].bid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
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
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateBill(Bill b) {

        String sql = "UPDATE [Bill]\n"
                + "   SET [cname] = ?\n"
                + "      ,[componentCategory] = ?\n"
                + "      ,[unitprice] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[totalMoney] = ?\n"
                + "      ,[inputDate] = ?\n"
                + "      ,[supplierName] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[contact] = ?\n"
                + "      ,[origin] = ?\n"
                + "      ,[oname] = ?\n"
                + " WHERE [bid] = ?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(12, b.getBid());
            stm.setString(1, b.getCname());
            stm.setString(2, b.getCategory());
            stm.setInt(3, b.getUnitPrice());
            stm.setInt(4, b.getQuantity());
            stm.setInt(5, b.getTotal());
            stm.setDate(6, b.getInputDate());
            stm.setString(7, b.getSupplierName());
            stm.setString(8, b.getAddress());
            stm.setString(9, b.getContact());
            stm.setString(10, b.getOrigin());
            stm.setString(11, b.getOwner().getOname());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void deleteBill(int bid) {

        String sql = "DELETE FROM [dbo].[Bill]\n"
                + "      WHERE bid = ?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Bill> getBillsByName(String bname) {
        ArrayList<Bill> bills = new ArrayList<>();

        try {
            String sql = "SELECT b.[bid]\n"
                    + "      ,b.[cname]\n"
                    + "      ,b.[componentCategory]\n"
                    + "      ,b.[unitprice]\n"
                    + "      ,b.[quantity]\n"
                    + "      ,b.[totalMoney]\n"
                    + "      ,b.[inputDate]\n"
                    + "      ,b.[supplierName]\n"
                    + "      ,b.[address]\n"
                    + "      ,b.[contact]\n"
                    + "      ,b.[origin]\n"
                    + "      ,b.[oname]\n"
                    + "	  ,o.[password]\n"
                    + "  FROM [dbo].[Bill] B INNER JOIN [owner] o ON b.oname = o.oname ";

            if (bname != null) {
                sql += "  WHERE cname LIKE N'%" + bname + "%'";
            }
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("cname"));
                b.setCategory(rs.getNString("componentCategory"));
                b.setUnitPrice(rs.getInt("unitprice"));
                b.setQuantity(rs.getInt("quantity"));
                b.setTotal(rs.getInt("totalMoney"));
                b.setInputDate(rs.getDate("inputDate"));
                b.setSupplierName(rs.getNString("supplierName"));
                b.setAddress(rs.getNString("address"));
                b.setContact(rs.getString("contact"));
                b.setOrigin(rs.getNString("origin"));

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

    public ArrayList<Bill> getBills() {
        ArrayList<Bill> bills = new ArrayList<>();
        try {

            String sql = "SELECT B.bid, B.cname, B.componentCategory, B.unitprice, B.quantity, B.totalMoney, B.inputDate, B.supplierName, B.address, B.contact, B.origin, B.oname, O.[password] \n"
                    + "FROM owner O INNER JOIN Bill B ON O.oname = B.oname ";

            PreparedStatement stm = connection.prepareStatement(sql);

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
