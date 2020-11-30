package com.edt.forward_redirect_scope_el_jstl.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //获取三个作用域的数据
        Object reqName=req.getAttribute("name");
        Object sessionName = req.getSession().getAttribute("name");
        Object appName = req.getServletContext().getAttribute("name");
        writer.println("<br> request:"+reqName);
        writer.println("<br> session:"+sessionName);
        writer.println("<br> servletContext:"+appName );
    }
}
