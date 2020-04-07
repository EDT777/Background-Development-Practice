package com.octopus.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用properties api 读取
 *
 */
public class JdkPropertiesRead {
public static void main(String[] args) throws IOException {
	Properties props = new Properties();
	//读取数据一般使用inputStream 方式获得数据
	InputStream is =  JdkPropertiesRead.class.getResourceAsStream("/test.properties");
	//从流中获取
	props.load(is);
	
	System.out.println(props.getProperty("name"));


	ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
	JavaBean1 javaBean = context.getBean("bean1",JavaBean1.class);
	javaBean.showInfo();
	

}
}
