package com.edt.cookie_session.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
@WebServlet("/session/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("list", Arrays.asList("邮件1","邮件2","邮件3"));
//获取session对象
        HttpSession session = req.getSession();
//        从session 获取数据
        System.out.println(session.getAttribute("USERNAME_IN_SESSION"));

        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
    }
}
