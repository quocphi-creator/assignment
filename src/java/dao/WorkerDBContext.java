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
public class WorkerDBContext extends DBContext {

    public ArrayList<Worker> getWorkers() {

        ArrayList<Worker> workers = new ArrayList<>();
        try {

            String sql = "SELECT [wid]\n"
                    + "      ,[wname]\n"
                    + "      ,[phoneNumber]\n"
                    + "      ,[monthSalary]\n"
                    + "      ,[productSalary]\n"
                    + "  FROM [dbo].[Worker]";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                workers.add(w);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workers;
    }

    public int countProductByWid(int wid) {
        int count = 0;
        try {

            String sql = "SELECT COUNT(pid) AS 'count' FROM Product\n"
                    + "where wid = ?\n"
                    + "GROUP BY wid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, wid);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }
}
