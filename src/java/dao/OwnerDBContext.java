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
            String sql = "SELECT oname, [password] FROM [owner]";
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
}
