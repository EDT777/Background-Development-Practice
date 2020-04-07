package com.octopus.spring1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.spring1.biz.UserBiz;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		// 根据id找到所需要的bean
		UserBiz bean = (UserBiz) context.getBean("userBiz");
		String login = bean.login("user1111", null);
		System.out.println("得到的UserBiz为:" + bean);
		System.out.println("测试登录的结果为:" + login);
		System.out.println(bean.getClass());
		

	}
}
