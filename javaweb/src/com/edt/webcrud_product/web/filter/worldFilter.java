package com.edt.webcrud_product.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class worldFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(3);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println(4);
    }

    @Override
    public void destroy() {

    }
}
