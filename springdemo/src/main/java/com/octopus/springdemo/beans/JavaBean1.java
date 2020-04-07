package com.octopus.springdemo.beans;

import java.util.List;


import org.springframework.stereotype.Component;

@Component
public class JavaBean1 {
	private String name;
	
	private Long id;
	
	private List<String> tags;
	
	public JavaBean1() {
		
	}
	
	public JavaBean1(String name,Long id) {
		this.name = name;
		this.id = id;
	}
	
	/**
	 * һ���������һ���������
	 */
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
