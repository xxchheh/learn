package com.xxc.filter.easyfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/myservlet")
public class Myfilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletResponse.setContentType("text/html;charset=utf-8");
//
//        PrintWriter out = servletResponse.getWriter();
//        out.println("this is filter,if you want to myservlet , you need pass me");
        //如果上述直接转发，就不会打印上述语句，因为responses是myservlet返回的响应
        //但是由于是当前servletresponse传递的，所以如果想要设置response中的属性需要在filter中设置contenttype，也不一定，只是要在获取printewriter之前获取
        //原因是out打印的是随response一起返回给服务器的，所以当前层没有response返回
        //而response中的属性是属于这个对象的，所以还是一个response对象
        boolean filterpass=false;
        if(filterpass) {
            RequestDispatcher rd = servletRequest.getRequestDispatcher("/myservlet");
            rd.forward(servletRequest, servletResponse);
        }
                PrintWriter out = servletResponse.getWriter();
        out.println("this is filter,if you want to myservlet , you cannot pass me");

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
