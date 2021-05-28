package com.fernandolle.mertins.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owzi
 */
@WebServlet(name = "AJAXServer", urlPatterns = {"/ajaxserver"})
public class AJAXServer extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String conteudo = req.getParameter("conteudo");
        if (conteudo == null) {
            conteudo = "parametro não recebido";
        }
        Logger.getLogger(AJAXServer.class.getName()).info(String.format("Parametro [conteudo:%s]", conteudo));
        resp.setContentType("text/xml");
        resp.setHeader("Cache-Control", "no-cache");
        resp.getWriter().write(String.format("<retornoajax cor='%s'>%s</retornoajax>", pegaCor(), conteudo.toUpperCase()));
    }

    private String pegaCor() {
        String[] cores = {"blue", "yellow", "green", "red", "black", "brown", "gold", "orange", "purple", "skyblue"};
        Double pos = Math.random() * 10;
        return cores[pos.intValue()];
    }
}
