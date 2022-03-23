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
import model.AccountGroup;
import model.Owner;

/**
 *
 * @author ADMIN
 */
public class OwnerDBContext extends DBContext {

    public Owner getOwner(String oname, String password) {
        try {
            String sql = "SELECT oname, password from Owner WHERE oname = ? and password=?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, oname);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Owner owner = new Owner();
                owner.setOname(rs.getString("oname"));
                owner.setPassword(rs.getString("password"));
                return owner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<Owner> getOwnerList() {

        ArrayList<Owner> ownerList = new ArrayList<>();

        try {
            String sql = "select O.[oname]\n"
                    + "	,O.[password] \n"
                    + "	from [owner] O inner join [Account-Group] ag ON O.oname=AG.oname inner join [group] g on G.gid = AG.gid\n"
                    + " where G.gid = 1;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Owner o = new Owner();
                o.setOname(rs.getString("oname"));
                o.setPassword(rs.getString("password"));
                ownerList.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ownerList;
    }

    public ArrayList<AccountGroup> getAGs() {
        ArrayList<AccountGroup> ags = new ArrayList<>();
        try {

            String sql = "SELECT [oname]\n"
                    + "      ,[gid]\n"
                    + "  FROM [dbo].[Account-Group]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AccountGroup ag = new AccountGroup();
                ag.setOname(rs.getString("oname"));
                ag.setGid(rs.getInt("gid"));
                ags.add(ag);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ags;
    }

    public int checkRole(String username, String url) {
        try {
            String sql = "SELECT COUNT(*) AS Total FROM [owner] O \n"
                    + "	INNER JOIN [Account-Group] AG ON O.oname=AG.oname \n"
                    + "	INNER JOIN [Group] G ON G.gid = AG.gid\n"
                    + "	INNER JOIN [Group-Feature] GF ON G.[gid]=GF.[gid]\n"
                    + "	INNER JOIN [Feature] F ON F.[fid] = GF.[fid]\n"
                    + "WHERE O.oname = ? AND F.url = ? ";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, username);
            stm.setString(2, url);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

    public void updateOwner(String oldUser, Owner o) {
        String sql = "UPDATE [dbo].[owner]\n"
                + "   SET [oname] = ?\n"
                + "      ,[password] = ?\n"
                + " WHERE [oname]=?";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, o.getOname());
            stm.setString(2, o.getPassword());
            stm.setString(3, oldUser);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void deleteOwner(Owner o) {
        String sql = "DELETE FROM [dbo].[owner]\n"
                + "      WHERE [oname] = ?";
        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, o.getOname());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccount(String oname) {
        String sql = "DELETE FROM [dbo].[owner]\n"
                + "      WHERE oname=?";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, oname);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
