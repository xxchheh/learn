package com.xxc.http.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("request sucessfully!");
        System.out.println(req.getMethod());
//        System.out.println(req.getHttpServletMapping());
//        System.out.println(req.getHeader(""));
        System.out.println(req.getRequestURI());
        if(username.equals("zhangsan") && password.equals("123")){
            resp.sendRedirect("welcome.html");
        }else {
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
