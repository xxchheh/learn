package com.xxc.http.dispatch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/Include")
public class RequestIncludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 先设置contentType，再获取PrintWriter
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Request Headers Information</title></head>");
        out.println("<body>");
        out.println("<h2>HTTP Request Headers</h2>");


        out.write("这是servlet1外层所输出的信息<p>");
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("/Inner?p1=abc");
        out.write("ready to innerservlet<p>");
        out.write("<p>");
        requestDispatcher.include(req,resp);
        out.write("<p>");
        out.write("already haven gone to inner<p>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
