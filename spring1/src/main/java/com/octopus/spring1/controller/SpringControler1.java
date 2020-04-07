package com.octopus.spring1.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.octopus.spring1.entity.UserInfo;

@Controller
public class SpringControler1 {
	/**
	 * 基本请求处理和参数接收
	 */
	@RequestMapping("/test2")
	public String test1(String username,String pwd,Integer code) {
		System.out.println("springmvc的第一个请求:userName:"+username+",pwd:"+pwd+",code:"+code);
		return "page1";
	}
	
	@RequestMapping("/test3")
	public void test3() {
		System.out.println("springmvc的第二个请求");
	}
	/**
	 * 如何配置参数的详细特性
	 */
	@RequestMapping("/test4")
	public String test4(String name,@RequestParam(value="myage",required=false,defaultValue = "7")int age) {
		System.out.println("name为:"+name+" ,age为"+age);
		return "page1";
	}
	/**
	 * 如何接收同名的多个参数
	 */
	@RequestMapping("/test5")
	public String test5(String[] names) {
		System.out.println("参数name为:"+Arrays.toString(names));
		return "page1";
	}
	/**
	 * 如何接收实体类参数
	 */
	@RequestMapping("/test6")
	public String test6(UserInfo user) {
		System.out.println("参数User为："+user);
		return "page1";
	}
	/**
	 * 演示map接收所有请求参数,表单只需要传递实体的属性参数
	 */
	@RequestMapping("/test7")
	public String test7(@RequestParam Map<String, String> params) {
		System.out.println("参数params为："+params);
		return "page1";
	}
	/**
	 *日期参数格式必须为yyyy/MM/dd 
	 */
	@RequestMapping("/test8")
	public String test8(Date date) {
		System.out.println("参数date为："+date);
		return "page1";
	}
	/**
	 *演示重定向
	 */
	@RequestMapping("/test9")
	public String test9() {
		System.out.println("开始使用/开始路径的重定向使用");
		return "redirect:/index.jsp";
	}
	/**
	 * 访问Servlet API 对象
	 */
	@RequestMapping("/test10")
	public String test10(HttpServletRequest req,HttpServletResponse resp,String name) {
		System.out.println("req对象:"+req);
		System.out.println("resp对象:"+resp);
		HttpSession session = req.getSession();
		System.out.println("session:"+session);
		System.out.println("name为:"+name);
		return "page1";
	}
	
	@RequestMapping("/test11")
	public ModelAndView test11() {
		ModelAndView mav = new ModelAndView();
		UserInfo user = new UserInfo();
		user.setUserName("EDT");
		mav.setViewName("page2");//要跳转页面的名称
		mav.addObject("data1",user);//等效于req.setAttribute()
		return mav;
	}
}
