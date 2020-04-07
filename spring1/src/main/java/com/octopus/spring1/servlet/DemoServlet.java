package com.octopus.spring1.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.octopus.spring1.biz.UserBiz;
import com.octopus.spring1.biz.UserBizImpl;


@WebServlet("/test")
public class DemoServlet extends HttpServlet {
	
	private UserBiz userBiz = new UserBizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String username = req.getParameter("username");
		String pwd = req.getParameter("userpwd");
		//根据参数调用业务类
		String login = userBiz.login(username, pwd);
		//根据业务类的返回值向用户返回结果，有可能是json，也可能是跳转到某个页面
		Map<String, Object> result = new HashMap<String, Object>();
		if(UserBiz.SUCCESS.equals(login)) {
			result.put("code",0);
			result.put("msg", "登录成功");
		}else {
			result.put("code",1);
			result.put("msg", "登录失败，用户名或者密码错误");
		}
		String jsonString = JSON.toJSONString(result);
		//设置返回内容的编码
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonString);
	}
}
