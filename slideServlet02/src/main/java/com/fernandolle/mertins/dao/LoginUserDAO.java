package com.fernandolle.mertins.dao;

import com.fernandolle.mertins.bean.LoginUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 *
 * @author owzi
 */
public class LoginUserDAO {

    private final LoginUser login;
    private final Connection conn;
    private int id = 0;

    public LoginUserDAO(Connection conn, LoginUser login) {
        this.conn = conn;
        this.login = login;
    }

    public boolean valida() throws SQLException {
        String sql = "SELECT * FROM login_user WHERE login=?";
        PreparedStatement pst = this.conn.prepareStatement(sql);
        pst.setString(1, this.login.getLogin());
        ResultSet rs = pst.executeQuery();
        boolean logou = false;

        while (rs.next()) {
            if (login.getSenha().equals(rs.getString("senha"))) {
                this.login.setId(Integer.parseInt(rs.getString("id_user")));
                logou = true;
                break;
            }
        }
        return logou;
    }
    
    private int getId () {
        return login.getId();
    }
}
