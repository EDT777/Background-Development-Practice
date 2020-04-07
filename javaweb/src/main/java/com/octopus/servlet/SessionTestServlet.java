package com.octopus.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octopus.dao.UserInfoDAO;
import com.octopus.dao.impl.UserInfoDAOImpl;
import com.octopus.entity.UserInfo;
@WebServlet("/sessiontest")
public class SessionTestServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();//检查客户端是否带了令牌，若无则分一个新的
		System.out.println("得到的session 令牌的id:"+session.getId());
		UserInfo user = (UserInfo) session.getAttribute("user");
		System.out.println("当前登录用户名为"+(user!=null?user.getUserName():"未登录"));
		//手动放弃令牌
		//session.invalidate();
		//手动设置有效时间20秒
		//session.setMaxInactiveInterval(20);
		//session还可以携带数据
		session.setAttribute("shujuming", "shujuzhi");
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
}
