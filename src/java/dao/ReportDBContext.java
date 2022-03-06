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
import model.ReportInventory;

/**
 *
 * @author ADMIN
 */
public class ReportDBContext extends DBContext {

    public ArrayList<ReportInventory> getInventoryList() {

        ArrayList<ReportInventory> inventoryList = new ArrayList<>();

        try {

            String sql = "  SELECT b.[bid]\n"
                    + "	  ,MAX(b.[cname]) AS ComponentName\n"
                    + "	  ,MAX(b.[componentCategory]) as Category\n"
                    + "	  ,MAX(b.[quantity]) as Quantity\n"
                    + "	  ,MAX(b.unitprice) as Price\n"
                    + "	  ,SUM(m.[producted]) AS Producted\n"
                    + "	  ,SUM(m.[removed]) AS Removed\n"
                    + "  FROM [dbo].[Bill] b left join [Manufactoring] m on m.bid=b.bid\n"
                    + "  GROUP BY B.bid";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                ReportInventory inventory = new ReportInventory();
                inventory.setProducted(rs.getInt("producted"));
                inventory.setRemoved(rs.getInt("removed"));

                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("ComponentName"));
                b.setCategory(rs.getNString("Category"));
                b.setQuantity(rs.getInt("Quantity"));
                b.setUnitPrice(rs.getInt("Price"));

                inventory.setBill(b);

                inventoryList.add(inventory);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryList;

    }

    public ArrayList<ReportInventory> getInventoryListByCname(String cname) {
        
        ArrayList<ReportInventory> inventoryList = new ArrayList<>();
        
        try {
            String sql = "   SELECT b.[bid]\n"
                    + "	  ,MAX(b.[cname]) AS ComponentName\n"
                    + "	  ,MAX(b.[componentCategory]) as Category\n"
                    + "	  ,MAX(b.[quantity]) as Quantity\n"
                    + "	  ,MAX(b.unitprice) as Price\n"
                    + "	  ,SUM(m.[producted]) AS Producted\n"
                    + "	  ,SUM(m.[removed]) AS Removed\n"
                    + "  FROM [dbo].[Bill] b left join [Manufactoring] m on m.bid=b.bid";            
            
            if (cname != null) {
                sql += "  WHERE B.cname LIKE N'%"+cname+"%'";
            }
            sql += "  GROUP BY B.bid";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ReportInventory inventory = new ReportInventory();
                inventory.setProducted(rs.getInt("producted"));
                inventory.setRemoved(rs.getInt("removed"));

                Bill b = new Bill();
                b.setBid(rs.getInt("bid"));
                b.setCname(rs.getNString("ComponentName"));
                b.setCategory(rs.getNString("Category"));
                b.setQuantity(rs.getInt("Quantity"));
                b.setUnitPrice(rs.getInt("Price"));

                inventory.setBill(b);

                inventoryList.add(inventory);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryList;
    }

}
