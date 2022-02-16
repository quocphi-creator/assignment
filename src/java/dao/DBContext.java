/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBContext {
    //init a Connection object
    protected Connection connection;
    //init a constructor
    public DBContext() {      
        try {
            //sql server name
            String user = "SE1616";
            //sql password
            String pass = "22012001";
            //sql database url
            String url = "jdbc:sqlserver://DESKTOP-01NQ3KO:1433;databaseName=Assignment";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //get connection with sql server
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

