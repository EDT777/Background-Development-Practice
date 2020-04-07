package com.octopus.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.entiy.Goods;

public class testAop {
	public static void main(String[] args) {
		// 创建管家对象并让其读取指定配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("aop.xml");
		//这行代码不需要改变，spring就可以将增强代码加入
		//我也加注释
		//bbb
		//随时
		TestBiz biz = (TestBiz) factory.getBean("testBiz2");
		String result = biz.targetTest1("张三");
		System.out.println("方法执行结果为:"+result);
		
	}
}
