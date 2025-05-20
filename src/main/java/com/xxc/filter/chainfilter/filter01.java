package com.xxc.filter.chainfilter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//由于需要定义过滤器加载顺序，所以使用web.xml进行配置。在高版本中已经实现使用webfilter中的filterOrder属性定义过滤器加载优先级
public class filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=UTF-8");

        PrintWriter out = servletResponse.getWriter();
        out.println("这是第一个filter01");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
