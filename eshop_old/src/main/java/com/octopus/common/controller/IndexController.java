package com.octopus.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octopus.common.utils.ShiroUtil;
import com.octopus.project.domain.SysUserDO;

@Controller
public class IndexController {

	@RequestMapping("/indexback")
	public String backindex(HttpServletRequest req) {
		SysUserDO user = ShiroUtil.getCurrentUser();
		req.setAttribute("loginuser", user.getUsername());
		return "indexback";
	}
	
	@RequestMapping("/")
	public String index(HttpServletRequest req) {
		SysUserDO user = ShiroUtil.getCurrentUser();
		req.setAttribute("loginuser", user.getUsername());
		return "index";
	}
}
