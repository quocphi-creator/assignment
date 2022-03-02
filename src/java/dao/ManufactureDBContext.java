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
import model.Manufacture;
import model.ManufactureDetail;

/**
 *
 * @author ADMIN
 */
public class ManufactureDBContext extends DBContext{

    public ArrayList<Manufacture> getManuList(int month, int year) {
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
                ManufactureDetail 
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManufactureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
