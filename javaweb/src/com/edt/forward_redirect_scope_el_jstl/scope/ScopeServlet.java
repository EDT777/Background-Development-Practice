package com.edt.forward_redirect_scope_el_jstl.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    //从scopeServlet 中获取三个作用域中的数据 num,如果获取到则加1再存入,
    //如果获取不到则存入 num的值为1,最后跳转到ResultServlet中来做数据的获取和显示

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域
        Object num = req.getAttribute("num");
        if (num==null){
            req.setAttribute("num",1);
        }else {
            req.setAttribute("num",(Integer)num+1);
        }
        //会话域
        HttpSession session = req.getSession();
        Object sessionNum = session.getAttribute("num");
        if (sessionNum == null){
            session.setAttribute("num",1);
        }else {
            session.setAttribute("num",(Integer)sessionNum+1);
        }
        //上下文域
        ServletContext servletContext =req.getServletContext();
        Object appNum = servletContext.getAttribute("num");
        if (appNum == null){
            servletContext.setAttribute("num",1);
        }else {
            servletContext.setAttribute("num",(Integer)appNum+1);
        }
        //跳转Result,去显示数据
        req.getRequestDispatcher("/result").forward(req,resp);
    }
}
