/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandolle.mertins.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author owzi
 */
public class ValidaID_DEPRICATED {

    private static DataSource dataSource;
    private Exception exception;
    private int id;

    public ValidaID_DEPRICATED(int id) {
        this.id = id;
    }

    private static Connection getConn() throws SQLException {
        Connection conn;
        try {
            Context context = new InitialContext();
            ValidaID_DEPRICATED.dataSource = (DataSource) context.lookup("jdbc/servletMerTIns");
            conn = dataSource.getConnection();
        } catch (NamingException ex) {
            return null;
        }
        return conn;
    }
    
    public boolean testaID () throws SQLException {
        Connection conn = ValidaID_DEPRICATED.getConn();

        String sql = "SELECT * FROM login_user WHERE id_user=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, String.valueOf(this.id));
        ResultSet rs = pst.executeQuery();
        boolean logou = false;

        while (rs.next()) {
            if (this.id == Integer.parseInt(rs.getString("user_id"))) {
                logou = true;
                break;
            }
        }
        return logou;
    }
}
