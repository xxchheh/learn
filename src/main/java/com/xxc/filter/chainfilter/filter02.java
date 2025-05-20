package com.xxc.filter.chainfilter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class filter02 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.write("这是filter02");
        //所以上面这些内容是否可以转换到一个对象中实现？那就需要是单例模式
        filterChain.doFilter(servletRequest,servletResponse);
        out.write("after servlet");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
