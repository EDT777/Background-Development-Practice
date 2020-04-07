package com.octopus.entiy;

import java.util.Arrays;

//辅助演示spring对象创建和数据设置的效果
public class javaBean2 {
//基本数据类型的属性
	private int id;
	
	//引用类型的属性
	private String name;
	//数组类型的属性
	
	  
	 
	private int[] score;
	//其他对象类型的属性
	private Goods goods;
	@Override
	public String toString() {
		return "javaBean2 [id=" + id + ", name=" + name + ", score=" + Arrays.toString(score) + ", goods=" + goods
				+ "]";
	}
	public javaBean2() {
		super();
	}
	public javaBean2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScore() {
		return score;
	}
	public void setScore(int[] score) {
		this.score = score;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
