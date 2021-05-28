package com.ipgetter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Locale;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owzi
 */
@WebServlet(name = "IpGetter", urlPatterns = {"/IpGetter"})
public class IpGetter extends HttpServlet {

    private DataSource dataSource;
    private Exception exception;

    static final Logger logger = Logger.getLogger(IpGetter.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {
        
        logger.log(Level.INFO, "Invocou um servlet no método init");
        try {
            Context context = new InitialContext();
            this.dataSource = (DataSource) context.lookup("jdbc/servletMerTIns");

        } catch (NamingException ex) {
            this.exception = ex;
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String ipLocal = req.getLocalAddr();
        String ipClient = req.getRemoteAddr();
        PrintWriter out = res.getWriter();
        Locale clientLocale = req.getLocale();
        
        logger.log(Level.INFO, "Invocou o método service");
        logger.log(Level.SEVERE, ipClient);
        
        if (clientLocale.getDisplayLanguage().equals("Portuguese")) {
            if (ipLocal.equals(ipClient)) {
                out.println("<p> CASA </p> <br>");
            } else {
                out.println("<p> ESTRANGEIRO </p> <br>");
            }
        } else {
            if (ipLocal.equals(ipClient)) {
                out.println("<p> HOME </p> <br>");
            } else {
                out.println("<p> STRANGER </p> <br>");

            }
        }
    }
}
