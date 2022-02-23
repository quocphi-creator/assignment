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
                    + "  FROM [dbo].[Worker] ";

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

    public void insertWorker(Worker w) {
        String sql = "INSERT INTO [dbo].[Worker]\n"
                + "           ([wid]\n"
                + "           ,[wname]\n"
                + "           ,[phoneNumber]\n"
                + "           ,[monthSalary]\n"
                + "           ,[productSalary])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);

            stm.setInt(1, w.getWid());
            stm.setNString(2, w.getWname());
            stm.setString(3, w.getPhoneNumber());
            stm.setInt(4, w.getMonthSalary());
            stm.setInt(5, w.getProductSalary());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public Worker getWorker(int wid) {

        try {
            String sql = "SELECT [wid]\n"
                    + "      ,[wname]\n"
                    + "      ,[phoneNumber]\n"
                    + "      ,[monthSalary]\n"
                    + "      ,[productSalary]\n"
                    + "  FROM [dbo].[Worker]\n"
                    + "  WHERE wid = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, wid);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Worker w = new Worker();

                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                return w;
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateWorker(Worker w) {
        String sql = "UPDATE [dbo].[Worker]\n"
                + "   SET [wname] = ?\n"
                + "      ,[phoneNumber] = ?\n"
                + "      ,[monthSalary] = ?\n"
                + "      ,[productSalary] = ?\n"
                + " WHERE wid = ?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            
            stm.setInt(5, w.getWid());
            stm.setNString(1, w.getWname());
            stm.setString(2, w.getPhoneNumber());
            stm.setInt(3, w.getMonthSalary());
            stm.setInt(4, w.getProductSalary());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WorkerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
