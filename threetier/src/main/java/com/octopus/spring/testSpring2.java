package com.octopus.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.entiy.Goods;
import com.octopus.entiy.javaBean2;

public class testSpring2 {
	public static void main(String[] args) {
		// 创建管家对象并让其读取指定配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		// 找管家要人
		//有的对象的属性可能是一个数组或者集合
		javaBean2 bean2 =factory.getBean(javaBean2.class);
		System.out.println(bean2);
	}
}
