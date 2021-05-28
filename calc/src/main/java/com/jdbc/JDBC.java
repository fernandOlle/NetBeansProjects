/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbc;

import com.jdbc.bean.Aluno;
import com.jdbc.bean.Funcionario;
import com.jdbc.dao.AlunoDAO;
import com.jdbc.dao.FuncionarioDAO;
import com.jdbc.util.Conexao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "JDBC", urlPatterns = {"/jdbc"})
public class JDBC extends HttpServlet {

    private static Connection conexao;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JDBC.conexao = Conexao.get();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrintWriter out = resp.getWriter();

        if (req.getParameter("bd").equals("aluno")) {
            try {

                AlunoDAO alunoDAO = new AlunoDAO(JDBC.conexao);
                List<Aluno> lista = alunoDAO.listaTodos();

                for (Aluno aluno : lista) {
                    out.println("<p>" + aluno.getNome() + "</p>");
                    out.println("<p>" + aluno.getMatricula() + "</p>");
                    out.println("<p>" + aluno.getDtIngresso() + "</p>");
                    out.println("<br>");
                    out.println("<br>");
                }
            } catch (SQLException ex) {
            }
        } else if (req.getParameter("bd").equals("funcionario")) {
            try {

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(JDBC.conexao);
                List<Funcionario> lista = funcionarioDAO.listaTodos();

                for (Funcionario aluno : lista) {
                    out.println("<p>" + aluno.getNome() + "</p>");
                    out.println("<p>" + aluno.getCargo()+ "</p>");
                    out.println("<p>" + aluno.getCod()+ "</p>");
                    out.println("<p>" + aluno.getDtContratacao()+ "</p>");
                    out.println("<p>" + aluno.getGerente()+ "</p>");
                    out.println("<p>" + aluno.getSalario()+ "</p>");
                    out.println("<br>");
                    out.println("<br>");
                }
            } catch (SQLException ex) {
            }
        }
    }

}
