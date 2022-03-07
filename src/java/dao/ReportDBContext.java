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
import model.Product;
import model.ReportInventory;
import model.ReportWorkerSalary;
import model.Worker;

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
                sql += "  WHERE B.cname LIKE N'%" + cname + "%'";
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

    public ArrayList<ReportWorkerSalary> getSalaries(int month, int year) {
        ArrayList<ReportWorkerSalary> salaries = new ArrayList<>();
        String whereStm = "";
        try {
            if (year > 1) {
                whereStm = "  where YEAR(P.manufactureDate) = ? AND MONTH(p.manufactureDate) = ? ";
            }
            String sql = "SELECT w.[wid]\n"
                    + "	,w.[wname]\n"
                    + "	,w.[phoneNumber]\n"
                    + "	,w.[monthSalary]\n"
                    + "	,w.[productSalary]\n"
                    + "	,COUNT(P.pid) AS [CountProduct]	  \n"
                    + "FROM [dbo].[Worker] w inner join [Product] p on w.wid = p.wid "
                    + whereStm
                    + "   GROUP BY W.wid, W.wname, W.phoneNumber, W.monthSalary, W.productSalary";

            PreparedStatement stm = connection.prepareStatement(sql);
            if (year > 1) {
                stm.setInt(1, year);
                stm.setInt(2, month);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                ReportWorkerSalary salary = new ReportWorkerSalary();
                salary.setCount(rs.getInt("CountProduct"));
                salary.setWorker(w);
                
                salaries.add(salary);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReportDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salaries;
    }

}
