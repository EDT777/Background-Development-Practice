package com.octopus.springdemo.code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.springdemo.beans.JavaBean1;
//获取bean的几种方式
public class TestSpring1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// 获取对象
		/*
		 * //第一种是根据类型获取：该类型的对象最多只能有一个 JavaBean1 bean1 =
		 * context.getBean(JavaBean1.class); System.out.println(bean1);
		 */

		// 第二种方法：根据id获取不用担心一个类型多个bean
		// JavaBean1 bean1 = (JavaBean1) context.getBean("bean1_1");
		// System.out.println(bean1);
		// 第三种方法：指定类型的指定Id的bean
		JavaBean1 bean1 = context.getBean("bean1_1", JavaBean1.class);
		System.out.println(bean1);
	}
}
