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
public class ManufactureDBContext extends DBContext{

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
                    + "  FROM [dbo].[Manufactoring] M INNER JOIN [Bill] B ON B.bid = M.bid LEFT JOIN [Worker] W ON W.wid = M.wid ";
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

}
