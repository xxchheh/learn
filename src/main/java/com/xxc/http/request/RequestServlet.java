package com.xxc.http.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Request Information</title></head>");
        out.println("<body>");

        out.println("<h2>HTTP Request Information</h2>");
        out.println("<p>getMethod : " + request.getMethod() + "</p>");
        out.println("<p>getRequestURI : " + request.getRequestURI() + "</p>");
        out.println("<p>getQueryString:" + request.getQueryString() + "</p>");
        out.println("<p>getProtocol : " + request.getProtocol() + "</p>");
        out.println("<p>getContextPath:" + request.getContextPath() + "</p>");
        out.println("<p>getPathInfo : " + request.getPathInfo() + "</p>");
        out.println("<p>getPathTranslated : " + request.getPathTranslated() + "</p>");
        out.println("<p>getServletPath:" + request.getServletPath() + "</p>");
        out.println("<p>getRemoteAddr : " + request.getRemoteAddr() + "</p>");
        out.println("<p>getRemoteHost : " + request.getRemoteHost() + "</p>");
        out.println("<p>getRemotePort : " + request.getRemotePort() + "</p>");
        out.println("<p>getLocalAddr : " + request.getLocalAddr() + "</p>");
        out.println("<p>getLocalName : " + request.getLocalName() + "</p>");
        out.println("<p>getLocalPort : " + request.getLocalPort() + "</p>");
        out.println("<p>getServerName : " + request.getServerName() + "</p>");
        out.println("<p>getServerPort : " + request.getServerPort() + "</p>");
        out.println("<p>getScheme : " + request.getScheme() + "</p>");
        out.println("<p>getRequestURL : " + request.getRequestURL() + "</p>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
