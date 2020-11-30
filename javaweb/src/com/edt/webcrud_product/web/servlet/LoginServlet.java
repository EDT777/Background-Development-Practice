package com.edt.webcrud_product.web.servlet;

import com.edt.webcrud_product.dao.IUserDao;
import com.edt.webcrud_product.dao.impl.UserDaoImpl;
import com.edt.webcrud_product.domain.User2;
import com.edt.webcrud_product.service.IUserService;
import com.edt.webcrud_product.service.impl.UserServiceImpl;
import com.edt.webcrud_product.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static final int One_Week = 60 * 60 * 24 * 7;
    public static final int No_Time = 0;
    IUserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remeberMe= req.getParameter("remeberMe");
        String randomCode= req.getParameter("randomCode");
        boolean b =Boolean.valueOf(remeberMe);
        //效验验证码
        String randomCodeInSession = (String) req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
        if (randomCode==null || randomCodeInSession==null || !randomCodeInSession.equalsIgnoreCase(randomCode)) {
            req.setAttribute("errorMsg","验证码有误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        //验证成功
        req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");
        //验证登录账号密码
        try {
            User2 user = userService.checkUser(username,password);
            //登陆成功
            Cookie cookie = new Cookie("name",username);
            cookie.setMaxAge(b?One_Week: No_Time);
            resp.addCookie(cookie);
            req.getSession().setAttribute("USER_IN_SESSION",user);
            resp.sendRedirect("/product");
        }catch (Exception e){
            req.setAttribute("errorMsg",e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }
}
