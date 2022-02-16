/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = "SELECT oname, [password] from Owner\n"
                    + "WHERE oname = ? and password=?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, oname);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Owner owner = new Owner();
                owner.setOname(rs.getString(oname));
                owner.setPassword(rs.getString(password));
                return owner;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OwnerDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
