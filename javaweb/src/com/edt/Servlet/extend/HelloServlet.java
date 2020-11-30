package com.edt.Servlet.extend;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet implements Servlet {
    private ServletConfig servletConfig;
    public HelloServlet(){
        System.out.println("创建对象");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("初始化操作");

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("进来了");
        System.out.println(servletConfig.getServletName());
        //通过某个变量在指定编码格式
        String encoding = servletConfig.getInitParameter("encoding");
        if ("UTF-8".equalsIgnoreCase(encoding)){//忽略大小写比较
            System.out.println("你好，世界");
        }else {
            System.out.println("hello world");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁操作");
    }
}
