/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author owzi
 */
public class Conexao {
 
    public static Connection get() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/BaseMerTIns", "postgres", "teste12");
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
//        return DriverManager.getConnection("jdbc:derby://localhost:1527/BaseUCPel", "aluno", "qpwo");
    }

    public static Connection Connection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
