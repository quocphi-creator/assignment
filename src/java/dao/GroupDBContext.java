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
import model.Group;
import model.Owner;

/**
 *
 * @author ADMIN
 */
public class GroupDBContext extends DBContext {

    public ArrayList<Group> getGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            String sql = "SELECT [gid]\n"
                    + "      ,[gname]\n"
                    + "  FROM [dbo].[Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Group g = new Group();
                g.setGid(rs.getInt("gid"));
                g.setGname(rs.getNString("gname"));

                groups.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groups;

    }

    public void insertAccount(Owner o) {
        String sql = "INSERT INTO [dbo].[owner]\n"
                + "           ([oname]\n"
                + "           ,[password]\n"
                + "			)\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, o.getOname());
            stm.setString(2, o.getPassword());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void insertAG(Owner o, int gid) {
        String sql = "INSERT INTO [dbo].[Account-Group]\n"
                + "           ([oname]\n"
                + "           ,[gid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, o.getOname());
            stm.setInt(2, gid);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GroupDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
