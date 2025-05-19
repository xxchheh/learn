package com.xxc.filter.forwardfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "/first.jsp",dispatcherTypes = DispatcherType.FORWARD)
public class forwardFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.println("fortunately your request haven been serve by forwardservlet,but go to jsp you need pass filter");
    }

    public void destroy() {

    }
}
