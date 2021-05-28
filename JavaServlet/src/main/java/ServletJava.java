/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

/**
 *
 * @author owzi
 */
@WebServlet(name = "BoasVindas", urlPatterns = {"/ServletJava"})
public class ServletJava extends HttpServlet {

    private DataSource dataSource;
    private Exception exception;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try (PrintWriter out = res.getWriter()) {
            if (exception == null) {
                try {
                    Connection conn = (Connection) dataSource.getConnection();
                    out.write("Conexão pronta");
                    conn.close();
                } catch (SQLException ex) {
                    out.write("Falha na conexão");
                    ex.printStackTrace(out);
                } catch (JMSException ex) {
                    Logger.getLogger(ServletJava.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                out.write("Falha na conexão");
                exception.printStackTrace(out);
            }
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/testeAula");
        } catch (NamingException ex) {
            exception = ex;
        }
    }

}
