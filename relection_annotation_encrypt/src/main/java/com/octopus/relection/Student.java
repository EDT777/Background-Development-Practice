package com.octopus.relection;

import com.octopus.annotation.Myannotation;

@Myannotation(id=100,name="test1")
public class Student implements Comparable<Student>{
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	public String showInfo() {
		return "我叫："+name+",我的id为"+id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
