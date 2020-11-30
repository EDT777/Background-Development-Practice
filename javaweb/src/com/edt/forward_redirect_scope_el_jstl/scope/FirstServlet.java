package com.edt.forward_redirect_scope_el_jstl.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/scope/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在firstServlet 中来设置数据到作用域中,然后跳转到SecondServlet 中来获取作用域中数据
        //请求域
        req.setAttribute("name","request");
        //会话域
        req.getSession().setAttribute("name","session");
        //上下文域
        req.getServletContext().setAttribute("name","application");
        //转发
        req.getRequestDispatcher("/scope/second").forward(req,resp);
    }
}
