/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandolle.mertins.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owzi
 */
//@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("logadoNaMerTIns")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(loginCookie);
                    break;
                }
            }
        }
//        if (loginCookie != null) {
//            loginCookie.setMaxAge(0);
//            resp.addCookie(loginCookie);
//        }
        RequestDispatcher dispBackward = req.getRequestDispatcher("/");
        dispBackward.forward(req, resp);
    }

}
