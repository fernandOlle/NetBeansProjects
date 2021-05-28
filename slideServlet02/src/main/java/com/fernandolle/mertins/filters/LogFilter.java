package com.fernandolle.mertins.filters;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owzi
 */
@WebFilter(filterName = "MeuFiltro", urlPatterns = {"/*"})
public class LogFilter implements Filter {

    public LogFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String url = ((HttpServletRequest) request).getRequestURL().toString();

        System.out.println(((HttpServletRequest) request).getRequestURL());

        boolean logou = false;
        Cookie[] cookies = req.getCookies();
        Cookie aux = null;
        for (Cookie temp : cookies) {
            if ("logadoNaMerTIns".equals(temp.getName())) {
                aux = temp;
                logou = true;
                break;
            }
        }

        boolean desLogou = false;
        

        Enumeration<String> reqNames = req.getParameterNames();
        while (reqNames.hasMoreElements()) {
            if ("logout".equals(reqNames.nextElement()) && aux != null) {
                desLogou = true;
            }
        }
        

        if (logou && url.contains("login")) {
            chain.doFilter(request, response);
        } else if (logou && url.contains("logado") && desLogou) {
            if (aux != null) {
                aux.setMaxAge(0);
                resp.addCookie(aux);
                chain.doFilter(request, response);
            }
            chain.doFilter(request, response);
        } else if (logou && url.contains("logado")) {
            RequestDispatcher dispBackward = req.getRequestDispatcher("/logado");
            dispBackward.forward(req, resp);
        } else if (!logou && url.contains("login")) {
            chain.doFilter(request, response);
        } else if (!logou && url.contains("logado")) {
            
            RequestDispatcher dispForward = req.getRequestDispatcher("/");
            dispForward.forward(req, resp);
        
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
