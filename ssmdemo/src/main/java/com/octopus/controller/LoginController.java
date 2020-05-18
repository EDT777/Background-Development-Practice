package com.octopus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.biz.UserLoginBiz;


@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserLoginBiz loginBiz;

	@RequestMapping("login")
	@ResponseBody
	public Map<String, Object> login(String username, String pwd, HttpServletRequest req) {
		Map<String, Object> returnData = new HashMap<>();
		String result = loginBiz.login(username, pwd);
		if (UserLoginBiz.LOGIN_SUCCESS.equals(result)) {
			returnData.put("code", 0);// code=0表示登录成功
			// 处理会话跟踪
			HttpSession session = req.getSession();
			session.setAttribute("LOGIN_USER", loginBiz.findUserByUsername(username));
		} else {
			returnData.put("code", 1);
			returnData.put("msg", "用户名或者密码不正确");
		}
		
		return returnData;
	}
}
