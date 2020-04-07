package com.octopus.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.entiy.Goods;

public class testAop2 {
	public static void main(String[] args) {
		// 创建管家对象并让其读取指定配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("aop2.xml");
		
		TestBiz biz = factory.getBean(TestBiz.class);
		String result = biz.targetTest1("张三");
		System.out.println("方法执行结果为:"+result);
		
	}
}
