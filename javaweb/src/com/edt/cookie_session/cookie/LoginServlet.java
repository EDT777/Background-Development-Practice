package com.edt.cookie_session.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("edt") && password.equals("123")) {
            //往作用域存入登陆用户名
            //创建Cookie 对象
            Cookie cookie = new Cookie("username", username);
           cookie.setMaxAge(60);//存在60秒
            cookie.setMaxAge(0);//存在0秒 ,即删除此cookie
            //响应回浏览器
            resp.addCookie(cookie);
            req.setAttribute("username",username);
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

        }

    }
}
