package com.octopus.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private final static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test1")
	public String test1(MultipartFile file, HttpServletRequest req) {

		String filename = file.getOriginalFilename();
		logger.info("接收到文件："+filename);
		req.setAttribute("filename", filename);

		return "test1";
	}
}
