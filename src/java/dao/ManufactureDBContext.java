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
import model.Manufacture;
import model.ManufactureDetail;
import model.Owner;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class ManufactureDBContext extends DBContext {

    public ArrayList<ManufactureDetail> getManuList(int month, int year) {
        ArrayList<ManufactureDetail> ManuList = new ArrayList<>();
        try {
            String sql = "SELECT M.[orderID]\n"
                    + "      ,M.[bid]\n"
                    + "      ,M.[wid]\n"
                    + "      ,M.[producted]\n"
                    + "      ,M.[removed]\n"
                    + "      ,M.[outputDate]\n"
                    + "	  ,B.[cname]\n"
                    + "	  ,B.[componentCategory]\n"
                    + "	  ,B.[unitprice]\n"
                    + "	  ,B.[quantity]\n"
                    + "	  ,B.[totalMoney]\n"
                    + "	  ,B.[inputDate]\n"
                    + "	  ,B.[supplierName]\n"
                    + "	  ,B.[address]\n"
                    + "	  ,B.[contact]\n"
                    + "	  ,B.[origin]\n"
                    + "	  ,B.[oname]\n"
                    + "	  ,W.[wname]\n"
                    + "	  ,W.[phoneNumber]\n"
                    + "	  ,W.[monthSalary]\n"
                    + "	  ,W.[productSalary]\n"
                    + "  FROM [dbo].[Manufactoring] M inner JOIN [Bill] B ON B.bid = M.bid LEFT JOIN [Worker] W ON W.wid = M.wid ";
            if (year > 1) {
                sql += "   WHERE MONTH(outputDate) = ? AND YEAR(outputDate)=?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (year > 1) {
                stm.setInt(1, month);
                stm.setInt(2, year);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ManufactureDetail manuDetail = new ManufactureDetail();

                manuDetail.setOrderID(rs.getString("orderID"));
                manuDetail.setProducted(rs.getInt("producted"));
                manuDetail.setRemoved(rs.getInt("removed"));
                manuDetail.setOutputDate(rs.getDate("outputDate"));

                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("cname"));
                b.setCategory(rs.getNString("componentCategory"));
                b.setUnitPrice(rs.getInt("unitprice"));
                b.setTotal(rs.getInt("totalMoney"));
                b.setQuantity(rs.getInt("quantity"));
                b.setInputDate(rs.getDate("inputDate"));
                b.setSupplierName(rs.getNString("supplierName"));
                b.setAddress(rs.getNString("address"));
                b.setContact(rs.getString("contact"));
                b.setOrigin(rs.getNString("origin"));

                Owner o = new Owner();
                o.setOname(rs.getString("oname"));
                o.setPassword(rs.getString("wname"));

                b.setOwner(o);

                manuDetail.setWorker(w);
                manuDetail.setBill(b);

                ManuList.add(manuDetail);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ManuList;
    }

    public ManufactureDetail getManuDetail(int bid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ManufactureDetail> getManuDetails() {
        ArrayList<ManufactureDetail> ManuList = new ArrayList<>();
        try {
            String sql = "SELECT M.[orderID]\n"
                    + "      ,M.[bid]\n"
                    + "      ,M.[wid]\n"
                    + "      ,M.[producted]\n"
                    + "      ,M.[removed]\n"
                    + "      ,M.[outputDate]\n"
                    + "	  ,B.[cname]\n"
                    + "	  ,B.[componentCategory]\n"
                    + "	  ,B.[unitprice]\n"
                    + "	  ,B.[quantity]\n"
                    + "	  ,B.[totalMoney]\n"
                    + "	  ,B.[inputDate]\n"
                    + "	  ,B.[supplierName]\n"
                    + "	  ,B.[address]\n"
                    + "	  ,B.[contact]\n"
                    + "	  ,B.[origin]\n"
                    + "	  ,B.[oname]\n"
                    + "	  ,W.[wname]\n"
                    + "	  ,W.[phoneNumber]\n"
                    + "	  ,W.[monthSalary]\n"
                    + "	  ,W.[productSalary]\n"
                    + "  FROM [dbo].[Manufactoring] M INNER JOIN [Bill] B ON B.bid = M.bid LEFT JOIN [Worker] W ON W.wid = M.wid ";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ManufactureDetail manuDetail = new ManufactureDetail();

                manuDetail.setOrderID(rs.getString("orderID"));
                manuDetail.setProducted(rs.getInt("producted"));
                manuDetail.setRemoved(rs.getInt("removed"));
                manuDetail.setOutputDate(rs.getDate("outputDate"));

                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("cname"));
                b.setCategory(rs.getNString("componentCategory"));
                b.setUnitPrice(rs.getInt("unitprice"));
                b.setTotal(rs.getInt("totalMoney"));
                b.setQuantity(rs.getInt("quantity"));
                b.setInputDate(rs.getDate("inputDate"));
                b.setSupplierName(rs.getNString("supplierName"));
                b.setAddress(rs.getNString("address"));
                b.setContact(rs.getString("contact"));
                b.setOrigin(rs.getNString("origin"));

                Owner o = new Owner();
                o.setOname(rs.getString("oname"));
                o.setPassword(rs.getString("wname"));

                b.setOwner(o);

                manuDetail.setWorker(w);
                manuDetail.setBill(b);

                ManuList.add(manuDetail);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ManuList;
    }

    public void insertManuDetails(ManufactureDetail detail) {
        String sql = "INSERT INTO [dbo].[Manufactoring]\n"
                + "           ([orderID]\n"
                + "           ,[bid]\n"
                + "           ,[wid]\n"
                + "           ,[producted]\n"
                + "           ,[removed]\n"
                + "           ,[outputDate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, detail.getOrderID());
            stm.setInt(2, detail.getBill().getBid());
            stm.setInt(3, detail.getWorker().getWid());
            stm.setInt(4, detail.getProducted());
            stm.setInt(5, detail.getRemoved());
            stm.setDate(6, detail.getOutputDate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public int getProductedDetailByBid(int bid) {
        int productedTotal = 0;
        try {
            String sql = "SELECT [bid]\n"
                    + "      ,SUM(producted) AS [prductedTotal]\n"
                    + "	  \n"
                    + "  FROM [dbo].[Manufactoring] GROUP BY bid\n"
                    + "  having bid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                productedTotal = rs.getInt("prductedTotal");
            }
            return productedTotal;
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productedTotal;
    }

    public int getRemovedDetailByBid(int bid) {
        int RemovedDetail = 0;
        try {
            String sql = "SELECT [bid]\n"
                    + "      ,SUM(removed) as [removedTotal]\n"
                    + "  FROM [dbo].[Manufactoring] GROUP BY [bid]\n"
                    + "  having [bid]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                RemovedDetail = rs.getInt("removedTotal");
            }
            return RemovedDetail;
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RemovedDetail;
    }

    public ManufactureDetail getDetail(String mid) {
        try {
            String sql = "SELECT M.[orderID]\n"
                    + "      ,M.[bid]\n"
                    + "      ,M.[wid]\n"
                    + "      ,M.[producted]\n"
                    + "      ,M.[removed]\n"
                    + "      ,M.[outputDate]\n"
                    + "	  ,B.[cname]\n"
                    + "	  ,B.[componentCategory]\n"
                    + "	  ,B.[contact]\n"
                    + "	  ,B.[inputDate]\n"
                    + "	  ,B.[oname]\n"
                    + "	  ,B.[origin]\n"
                    + "	  ,B.[quantity]\n"
                    + "	  ,B.[totalMoney]\n"
                    + "	  ,b.[unitprice]\n"
                    + "	  ,B.[address]\n"
                    + "	  ,B.[contact]\n"
                    + "	  ,B.[supplierName]\n"
                    + "	  ,W.[wname]\n"
                    + "	  ,W.[phoneNumber]\n"
                    + "	  ,W.[monthSalary]\n"
                    + "	  ,W.[productSalary]\n"
                    + "  FROM [dbo].[Manufactoring] m INNER JOIN [Bill] B ON M.bid=B.bid LEFT JOIN [Worker] W ON M.wid = W.wid\n"
                    + "  WHERE M.[orderID] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, mid);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("cname"));
                b.setCategory(rs.getNString("componentCategory"));
                b.setUnitPrice(rs.getInt("unitprice"));
                b.setQuantity(rs.getInt("quantity"));
                b.setTotal(rs.getInt("totalMoney"));
                b.setInputDate(rs.getDate("inputDate"));
                b.setSupplierName(rs.getString("supplierName"));
                b.setAddress(rs.getString("address"));
                b.setContact(rs.getString("contact"));
                b.setOrigin(rs.getString("origin"));

                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                ManufactureDetail detail = new ManufactureDetail();
                detail.setOrderID(rs.getString("orderID"));
                detail.setOutputDate(rs.getDate("outputDate"));
                detail.setProducted(rs.getInt("producted"));
                detail.setRemoved(rs.getInt("removed"));
                detail.setBill(b);
                detail.setWorker(w);

                return detail;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void updateDetail(ManufactureDetail m) {
        String sql = "UPDATE [dbo].[Manufactoring]\n"
                + "   SET [bid] = ?\n"
                + "      ,[wid] = ?\n"
                + "      ,[producted] = ?\n"
                + "      ,[removed] = ?\n"
                + "      ,[outputDate] = ?\n"
                + " WHERE orderID = ?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(6, m.getOrderID());
            stm.setInt(1, m.getBill().getBid());
            stm.setInt(2, m.getWorker().getWid());
            stm.setInt(3, m.getProducted());
            stm.setInt(4, m.getRemoved());
            stm.setDate(5, m.getOutputDate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void deleteManuDetail(String mid) {
        String sql = " DELETE FROM [dbo].[Manufactoring]\n"
                + "      WHERE [orderID] = ?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, mid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
