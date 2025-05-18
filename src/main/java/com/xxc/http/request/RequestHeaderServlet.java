package com.xxc.http.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/requestheader")   //与web.xml文件中配置相同
public class RequestHeaderServlet extends HttpServlet {
    // 处理HTTP GET请求
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的内容类型为HTML，字符编码为UTF - 8
        response.setContentType("text/html;charset=utf-8");
        // 获取用于向客户端输出内容的PrintWriter对象
        PrintWriter out = response.getWriter();

        // 获取请求消息中所有头字段名称的枚举
        Enumeration<String> headerNames = request.getHeaderNames();

        // 开始构建HTML页面内容
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Request Headers Information</title></head>");
        out.println("<body>");
        out.println("<h2>HTTP Request Headers</h2>");

        // 使用循环遍历所有请求头，并通过getHeader()方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.print(headerName + " : " + request.getHeader(headerName) + "<br />");
        }

        out.println("</body>");
        out.println("</html>");
    }

    // 对于POST请求，这里简单转发给doGet方法处理
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
