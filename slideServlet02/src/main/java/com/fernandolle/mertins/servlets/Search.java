/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandolle.mertins.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owzi
 */
@WebServlet(name = "Search", urlPatterns = {"/search"})
public class Search extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opc = (String) req.getParameter("searcher");
        
        if (null == opc) {
            resp.sendRedirect("http://www.youtube.com.br");
        } else switch (opc) {
            case "google":
                {
                    String URL = "https://www.google.com/search?q=" + req.getParameter("keyWord");
                    resp.sendRedirect(URL);
                    break;
                }
            case "bing":
                {
                    String URL = "https://www.bing.com/search?q=" + req.getParameter("keyWord");
                    resp.sendRedirect(URL);
                    break;
                }
            case "yahoo":
                resp.sendRedirect("https://br.search.yahoo.com/");
                break;
            default:
                resp.sendRedirect("http://www.youtube.com.br");
                break;
        }
    }
}
