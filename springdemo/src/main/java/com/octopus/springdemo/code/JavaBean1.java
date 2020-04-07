package com.octopus.springdemo.code;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JavaBean1 {
	@Value("注解提供的值")
	private String name;
	@Value("1000")
	private Long id;
	
	private List<String> tags;
	
	public JavaBean1() {
		
	}
	
	public JavaBean1(String name,Long id) {
		this.name = name;
		this.id = id;
	}
	
	/**
	 *一个类对另一个类的依赖
	 */
	//@Autowired
	//多个bean同类型时，指定id
	//@Qualifier("javaBean2")
	//name后面 默认将类名称写为骆驼命名
	@Resource(name="javaBean2",type=JavaBean2.class)
	private JavaBean2 bean2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public JavaBean2 getBean2() {
		return bean2;
	}

	public void setBean2(JavaBean2 bean2) {
		this.bean2 = bean2;
	}

	@Override
	public String toString() {
		return "JavaBean1 [name=" + name + ", id=" + id + ", tags=" + tags + ", bean2=" + bean2 + "]";
	}
	
	
}
