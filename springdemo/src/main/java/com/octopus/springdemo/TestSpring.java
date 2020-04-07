package com.octopus.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octopus.springdemo.beans.JavaBean1;

public class TestSpring {
	public static void main(String[] args) {
		BeanFactory factory = null;// ���󹤳���Ҳ������
		ApplicationContext context = null;//Ӧ�������ģ��Ǹ߼���Ķ��󹤳�
		context = new ClassPathXmlApplicationContext("beans.xml");//����Spring��������
		//ͨ��context��ñ�����Ķ���
		JavaBean1 bean1 = (JavaBean1) context.getBean("bean1");
		System.out.println(bean1);
		
		JavaBean1 bean2 = (JavaBean1) context.getBean("bean2");
		System.out.println(bean2);
	}
}
