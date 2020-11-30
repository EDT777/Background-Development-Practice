package com.edt.Servlet.req_resp_jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo")
public class HttpSerlvetRequestDemoSerlvet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取请求行和请求头
        System.out.println(req.getMethod());//获取请求方式
        System.out.println(req.getRequestURI());//获取资源标识符
        System.out.println(req.getRequestURL());//代表一个可以访问的地址
        System.out.println(req.getProtocol());//获取协议和版本
        System.out.println(req.getContextPath());//获取项目名 上下文路径

        //获取请求头信息
        System.out.println("浏览器信息是: "+req.getHeader("User-Agent"));
    }
}
