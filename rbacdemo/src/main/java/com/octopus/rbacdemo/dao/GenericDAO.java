package com.octopus.rbacdemo.dao;

import java.util.List;

public abstract class GenericDAO<T> {
	abstract public T getById(int id);
	
	public abstract List<T> find(String where,Object[] params,int pageSize,int pageNum);
	
	public  abstract int update(T t);
	
	public abstract int delete(long id);
	
	public abstract Long insert(T t);
	

	public abstract  int getCount(String where, Object[] params);
	
}
