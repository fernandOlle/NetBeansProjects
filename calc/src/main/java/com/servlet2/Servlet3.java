package com.servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author owzi
 */
@WebServlet(name = "Servlet2", urlPatterns = {"/add"})
public class Servlet3 extends HttpServlet {

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

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        if (exception == null) {
//            try {
//                Connection conn = dataSource.getConnection();
//                out.write("Conexão pronta");
//                conn.close();
//            } catch (SQLException ex) {
//                out.write("Falha na conexão");
//                ex.printStackTrace(out);
//            }
//        } else {
//            out.write("Falha na conexão");
//            exception.printStackTrace(out);
//        }
//        
//        out.close();
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;

        PrintWriter out = resp.getWriter();

        out.println("<p> resultado é " + result + "</p>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;

        PrintWriter out = resp.getWriter();

        out.println("<p> resultado é " + result + "</p>");
    }
}
