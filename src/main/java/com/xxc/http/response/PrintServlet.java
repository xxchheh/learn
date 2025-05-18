package com.xxc.http.response;

import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 设置响应消息体具体内容
 */
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = "中国";
        resp.setContentType("text/html;charset=utf-8");
//        //也可以使用writer方法输出，但是两种方法互斥,只会执行先定义的方法
//        PrintWriter outWriter = resp.getWriter();
//        outWriter.println("nihao");
//        outWriter.write(data);
        //使用输出流设置响应消息体
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(data.getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req,resp);
    }
}
