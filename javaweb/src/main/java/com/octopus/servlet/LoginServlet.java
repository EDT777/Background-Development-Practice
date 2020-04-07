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
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("接收到/login这个地址的请求");
				//在获取参数之前必须设置请求的编码
				req.setCharacterEncoding("UTF-8");
				//获取参数
				String password =req.getParameter("password");
				String username =req.getParameter("username");//双引号中的内容对应表单中元素的name
				System.out.println("得到用户名为"+username+"得到密码为"+password);
				//访问数据库
				UserInfoDAO dao = new UserInfoDAOImpl();
				UserInfo info=dao.findByUserName(username);
				String loginResult ="";
				if(info==null) {
					loginResult="用户名不对";
				}else {
					if(info.getUserPwd().equals(password)) {
						loginResult="success";
						//会将用户信息存放到session中伴随后续请求
						HttpSession session=req.getSession();
						session.setAttribute("user", info);
					}else {
						loginResult="密码不正确";
								
					}
				}
				System.out.println("登陆的结果为"+loginResult);
				//响应的处理
				//设置响应内容编码
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print(loginResult);
				
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		}
}
