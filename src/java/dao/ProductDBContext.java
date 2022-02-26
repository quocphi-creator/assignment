/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.Owner;
import model.Product;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class ProductDBContext extends DBContext {

    public ArrayList<Product> getProducts(int month, int year) {

        ArrayList<Product> products = new ArrayList<>();

        try {

            String sql = "SELECT p.[pid]\n"
                    + "      ,p.[pname]\n"
                    + "      ,p.[productCategory]\n"
                    + "      ,p.[model]\n"
                    + "	  ,p.[price]\n"
                    + "      ,p.[manufactureDate]\n"
                    + "      ,p.[expireDate]\n"
                    + "      ,p.[guid]\n"
                    + "      ,p.[wid]\n"
                    + "	  ,w.wname\n"
                    + "	  ,w.phoneNumber\n"
                    + "	  ,w.monthSalary\n"
                    + "	  ,w.productSalary\n"
                    + "  FROM [Product] p left JOIN [Worker] w ON p.wid = w.wid ";

            if (year > 1) {
                sql += "   WHERE YEAR(manufactureDate) = ? and MONTH(manufactureDate)= ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);

            if (year > 1) {
                stm.setInt(1, year);
                stm.setInt(2, month);

            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getNString("pname"));
                p.setCategory(rs.getNString("productCategory"));
                p.setModel(rs.getNString("model"));
                p.setPrice(rs.getInt("price"));
                p.setManufactureDate(rs.getDate("manufactureDate"));
                p.setExpireDate(rs.getDate("expireDate"));
                p.setGuid(rs.getNString("guid"));

                Worker w = new Worker();
                w.setWid(rs.getInt("wid"));
                w.setWname(rs.getNString("wname"));
                w.setPhoneNumber(rs.getString("phoneNumber"));
                w.setMonthSalary(rs.getInt("monthSalary"));
                w.setProductSalary(rs.getInt("productSalary"));

                p.setWorker(w);
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

}
