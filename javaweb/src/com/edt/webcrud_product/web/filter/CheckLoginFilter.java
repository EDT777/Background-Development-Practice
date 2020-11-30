package com.edt.webcrud_product.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CheckLoginFilter implements Filter {
    private List<String> unCheckUris;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            unCheckUris = Arrays.asList(filterConfig.getInitParameter("unCheckUri").split(";"));//不用登陆也能访问的资源

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取当前请求资源路径
        String requestURI = req.getRequestURI();


        //没有登录
        if (req.getSession().getAttribute("USER_IN_SESSION")== null){
            if (!unCheckUris.contains(requestURI)) {//访问的资源 需要登录才可以访问
                response.sendRedirect("/login.jsp");
                return;
            }
        }
        //放行访问
        filterChain.doFilter(req,response);
    }

    @Override
    public void destroy() {

    }
}
