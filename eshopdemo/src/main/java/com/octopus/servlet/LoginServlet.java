package com.octopus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octopus.biz.UserBiz;
import com.octopus.biz.impl.UserBizImpl;
import com.octopus.entity.UserInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserBiz userBiz = new UserBizImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取参数
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("usernamee");
		String password = req.getParameter("passwordd");
		// 判断

		// 根据结果跳转
		String result = userBiz.login(username, password);
		String returnValue = "";
		if (result.equals(UserBiz.LOGIN_SUCCESS)) {
			// 在session保存登陆信息，否则不知道谁登陆了
			UserInfo userInfo = userBiz.findByUserName(username);
			userInfo.setUserPwd("");// 保存信息要清理密码
			req.getSession().setAttribute("LOGIN_USER", userInfo);
			// resp.sendRedirect("index.jsp");
			returnValue = "{\"code\":\"0\",\"msg\":\"success\"}";
		} else {

			// 让页面执行alert提示用户
			// resp.getWriter().write("<html><head><script>alert('登陆失败,用户名或者密码错误！');history.back();</script></head></html>");
			returnValue = "{\"code\":\"1\",\"msg\":\"登陆失败,用户名或者密码错误!\"}";
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.getWriter().write(returnValue);
	}
}
