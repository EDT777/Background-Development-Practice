package com.edt.cookie_session.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("list", Arrays.asList("邮件1","邮件2","邮件3"));


//   获取Cookie
        Cookie[] cookies =req.getCookies();
        for (Cookie cookie : cookies){
            if ("username".equals(cookie.getName())){
                cookie.setValue("谭泽豪");//更改
                resp.addCookie(cookie);
                break;
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
    }
}
