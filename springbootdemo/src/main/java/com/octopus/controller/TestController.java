package com.octopus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.dao.GoodsDao;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private GoodsDao goodsDao;
	
	@RequestMapping("/test1")
	@ResponseBody
	public Map<String,Object> test1() {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("code", 0);
		data.put("message", "正确");
		return data;
	}
	
	@RequestMapping("/test2")
	public String test2(HttpServletRequest req) {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("code", 0);
		data.put("message", "正确");
		req.setAttribute("data", data);
		return "/page2";
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public List test3() {
		return goodsDao.list(null);
	}
}
