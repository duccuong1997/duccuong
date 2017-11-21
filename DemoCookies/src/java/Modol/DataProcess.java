/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modol;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucCuong
 */
public class DataProcess {

    public Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "1234";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BOOK";
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
            System.out.println("Connectg Success");
        }
        return conn;
    }

    public boolean checkLogin(String _u, String _p) {
        boolean f = false;
        String sql = "SELECT * FROM tblAccount WHERE _user=? and _pass=?";
        try {
            PreparedStatement prst = getConnection().prepareStatement(sql);
            prst.setString(1, _u);
            prst.setString(2, _p);
            ResultSet rs = prst.executeQuery();
            f = rs.next();
            rs.close();
            prst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;

    }
}
