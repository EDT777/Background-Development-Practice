package com.octopus.dao;

import java.util.*;

import com.octopus.entiy.Goods;

//定义商品访问的数据接口
public interface GoodsDao {
	
		public Goods get(Long id);
		//标准查询方法
/*
 * params 查询条件
 * pageSize 分页大小
 * pageNum 分页页码
 * return 数据集合
 *  */
		public List<Goods> findBymap(Map<String,Object> params,int pageSize,int pageNum);
		
		//查询符合条件的数据条数
		public int count(Map<String,Object> params);
		
		public int uodate(Goods goods);
		
		public int insert(Goods goods);
		
		public int delete(Goods goods);
		
		
}
