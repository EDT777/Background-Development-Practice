package com.octopus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octopus.dao.UserInfoDAO;
import com.octopus.dao.impl.UserInfoDAOImpl;
import com.octopus.entity.UserInfo;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 读取cookie
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("Cookie" + cookies[i].getName() + "=" + cookies[i].getValue());
				
		}
		Cookie cookie = new Cookie("myuserid", "1");
		cookie.setMaxAge(3600*24*7);//设置cookie有效期，不设置则自动关闭浏览器则失效
		// cookie的写入是通过resp实现的
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
