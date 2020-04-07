package com.octopus.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bean1")
public class JavaBean1 {
	@Value("${name}")
	private String prop1;
	
	/**
	 * 通过实例方法setter为静态属性注入值
	 */
	@Value("${name2}")
	public void setProp2(String value) {
		prop2=value;
	}
	
	private static String prop2;
	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}
		
	public void showInfo() {
		System.out.println("prop1:"+prop1+" prop2:"+prop2);
	}
}
