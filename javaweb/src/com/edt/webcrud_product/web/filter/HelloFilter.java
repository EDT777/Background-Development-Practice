package com.edt.webcrud_product.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(1);
        filterChain.doFilter(servletRequest,servletResponse);//放行
        System.out.println(2);

    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");

    }
}
