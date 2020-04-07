package com.octopus.spring1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fm")
public class FreemarkerController {
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest req) {
		System.out.println("freemarker的控制器test1被访问");
		req.setAttribute("name", "EDT");
		return "page";
	}

}
