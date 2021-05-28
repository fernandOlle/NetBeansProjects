package com.fernandolle.mertins.servlets;

import com.fernandolle.mertins.bean.LoginUser;
import com.fernandolle.mertins.dao.LoginUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.log;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author owzi
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private DataSource dataSource;
    private Exception exception;

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            Context context = new InitialContext();
            this.dataSource = (DataSource) context.lookup("jdbc/servletMerTIns");

        } catch (NamingException ex) {
            this.exception = ex;
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispForward = req.getRequestDispatcher("/logado.html");
        RequestDispatcher dispBackward = req.getRequestDispatcher("/");
        //despachar.forward(request, response);

        PrintWriter out = resp.getWriter();

        if (exception == null) {
            Connection conn = null;
            try {
                conn = dataSource.getConnection();

                LoginUser login = new LoginUser();
                login.setLogin(req.getParameter("login"));
                login.setSenha(req.getParameter("senha"));

                LoginUserDAO loginUserDAO = new LoginUserDAO(conn, login);
                boolean logou = loginUserDAO.valida();

                if (logou) {
                    Cookie cook = new Cookie("logadoNaMerTIns", String.valueOf(login.getId()));
                    cook.setMaxAge(60*30);
                    resp.addCookie(cook);
                    dispForward.forward(req, resp);
                } else {
                    dispBackward.forward(req, resp);
                }
            } catch (SQLException ex) {
                out.write("Falha na conexão");
                ex.printStackTrace(out);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            out.write("Falha na conexão");
            exception.printStackTrace(out);
        }
    }
}
