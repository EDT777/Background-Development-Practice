package com.octopus.spring1.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.octopus.spring1.entity.UserInfo;

/**
 * 演示Json相关的数据操作
 * 
 * @author EDT灬谭泽豪
 *
 */
@Controller
@RequestMapping("/json")
public class JsonController {

	@RequestMapping("/test1")
	public String test(UserInfo user, HttpServletRequest req) {
		System.out.println("接收到user:" + user);
		req.setAttribute("user", user);
		return "json";
	}

	/**
	 * 接收以json方式提交数据为数组
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping("/test2")
	public String test2(@RequestBody UserInfo[] user,HttpServletRequest req) {
		System.out.println("接收到user:"+Arrays.toString(user));
		req.setAttribute("user",Arrays.toString(user));
		return "json";
		}
	/**
	 *返回json对象
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping("/test3")
	@ResponseBody//实现spring自动将所有返回的内容自动序列化为Json
	public UserInfo test3(@RequestBody UserInfo[] user, HttpServletRequest req) {
		System.out.println("接收到user:" + Arrays.toString(user));
		req.setAttribute("user", Arrays.toString(user));
		return user[0];
	}
	/**
	 *返回json对象数组
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping("/test4")
	@ResponseBody//实现spring自动将所有返回的内容自动序列化为Json
	public UserInfo[] test4(@RequestBody UserInfo[] user, HttpServletRequest req) {
		System.out.println("接收到user:" + Arrays.toString(user));
		req.setAttribute("user", Arrays.toString(user));
		return user;
	}
}
