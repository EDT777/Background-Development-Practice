package com.edt.cookie_session.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //往作用域存入登陆用户名
        //获取session对象
        HttpSession session = req.getSession();
//            往里面存入数据
        session.setAttribute("USERNAME_IN_SESSION", username);

//            session.invalidate();//销毁操作
        //设置15秒存活时间,默认30分钟
//        session.setMaxInactiveInterval(15);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);


    }
}
