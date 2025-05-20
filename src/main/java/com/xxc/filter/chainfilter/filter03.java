package com.xxc.filter.chainfilter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 获取配置信息
 */
public class filter03 implements Filter {
    private String CharacterEncoding ;
    FilterConfig filterConfig;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CharacterEncoding = filterConfig.getInitParameter("CharacterEncoding");
        System.out.println("CharacterEncoding = " + CharacterEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }
}
