package com.xxc.http.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 利用referer字段实现对于非法下载请求的拦截
 */
public class DownManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String refer = req.getHeader("referer");
        System.out.println(refer);
        String refersite = "http://"+req.getServerName();
        System.out.println(refersite);

        if(refer != null && refer.startsWith(refersite)){
            //利用html页面的链接再次请求会匹配当前界面
            out.write("downloading ....");
        }else{
            //首次请求当前downloadservlet由于没有refer字段会匹配当前情况，直接跳转至html页面
            RequestDispatcher rd = req.getRequestDispatcher("/download.html");
            rd.forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
