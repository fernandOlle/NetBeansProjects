/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "ArquivoDeFora", urlPatterns = {"/ArquivoDeFora"})
public class ArquivoDeFora extends HttpServlet {

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
        PrintWriter out = resp.getWriter();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/owzi/testePC2/ola.txt"))) {
            String line = br.readLine();
            String line2 = "";

            while (line != null) {
                line2 += line + "\n";
                line = br.readLine();
            }

            out.println("<h1>" + line2 + "</h1>");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
