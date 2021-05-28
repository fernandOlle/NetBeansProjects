package com.fernandolle.mertins.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
@WebServlet(name = "Ex3Servlet", urlPatterns = {"/ex3servlet"})
public class Ex3Servlet extends HttpServlet {

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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        PrintWriter out = resp.getWriter();

        if (exception == null) {
            try {
                String sql = "SELECT funcionario.nome FROM funcionario WHERE funcionario.nome LIKE ?";
                PreparedStatement pst;
                conn = dataSource.getConnection();
                pst = conn.prepareStatement(sql);
                pst.setString(1, '%' + req.getParameter("conteudo") + '%');
                ResultSet rs = pst.executeQuery();
                String retorno = "";
                while (rs.next()) {
                    retorno += rs.getString("nome") + "\n";
                }
                
                String conteudo = req.getParameter("conteudo");
                if (conteudo == null) {
                    conteudo = "parametro não recebido";
                }
                
                Logger.getLogger(AJAXServer.class.getName()).info(String.format("Parametro [conteudo:%s]", conteudo));
                resp.setContentType("text/xml");
                resp.setHeader("Cache-Control", "no-cache");
                resp.getWriter().write(String.format("<retornoajax>%s</retornoajax>", retorno));
                
            } catch (SQLException ex) {
                Logger.getLogger(Ex3Servlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Ex3Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            out.write("Falha na conexão");
            exception.printStackTrace(out);
        }

    }
}
