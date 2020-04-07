package com.octopus.common.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.common.utils.ShiroUtil;
import com.octopus.project.domain.SysMenuDO;
import com.octopus.project.domain.SysUserDO;
import com.octopus.project.service.SysMenuService;

@Controller
@RequestMapping("/sys")
public class LoginController {
	
	@Autowired
	private SysMenuService menuService;
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public Map<String,Object> doLogin(String username,String password,HttpServletRequest req){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("code", "-1");
		result.put("msg", "未知错误");
		
		//获取subject对象
		Subject subject = SecurityUtils.getSubject();
		//封装用户名和密码
		UsernamePasswordToken token = new  UsernamePasswordToken(username,password.toCharArray());
		
		try{
			//将包装好的验证信息传递给subject去验证
			subject.login(token);
			//获取权限并保存到session中
			SysUserDO user = ShiroUtil.getCurrentUser();
			LinkedHashMap<SysMenuDO, List<SysMenuDO>> map =menuService.listAllMenusByUserId(user.getUserId());
			req.getSession().setAttribute("menus", map);
			if(subject.isAuthenticated()) {
			//通过了验证
			result.put("code","0");
			result.put("msg","success");
		}
		}catch(AuthenticationException ex){
			result.put("code", "1");
			result.put("msg", ex.getMessage());
		}
		
		
		return result;
	}
}
