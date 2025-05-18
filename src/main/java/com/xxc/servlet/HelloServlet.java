package com.xxc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import javax.servlet.*;

/**
 * servlet接口
 * 基本的继承servlet，httpservlet,genericservlet
 * servletconfig
 * servletcontext
 */
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Helloservlet initate sucessfully");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter outToWeb = response.getWriter();
//        outToWeb.write("hello world!");
//        System.out.println("request doGet method successfully");
//
//        ServletConfig servletConfig = this.getServletConfig();
//        String paramEncoding = servletConfig.getInitParameter("Encoding");
//        outToWeb.write("encoding = "+paramEncoding);
//        outToWeb.println("<br />");

        ServletContext servletContext = this.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/classes/info.properties");
        Properties pros = new Properties();
        pros.load(in);
        outToWeb.write("name"+pros.getProperty("name"));
        outToWeb.println("<br/>");
        outToWeb.write("address"+pros.getProperty("address"));
//        Enumeration<String> contextParams = servletContext.getInitParameterNames();
//        while (contextParams.hasMoreElements()){
//            String name = contextParams.nextElement();
//            String context = servletContext.getInitParameter(name);
//            outToWeb.write(name+ ":  " + context);
//            outToWeb.write("<br />");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
