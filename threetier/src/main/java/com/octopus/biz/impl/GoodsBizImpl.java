package com.octopus.biz.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

import com.octopus.biz.GoodsBiz;
import com.octopus.dao.*;
import com.octopus.dao.impl.GoodsDaoImpl;
import com.octopus.dao.impl.MybatisSqlSessionFatory;
import com.octopus.entiy.Goods;
@Service
public class GoodsBizImpl implements GoodsBiz {
		//业务层依赖于数据访问层
	@Resource
	private GoodsDao goodsDao ;
	
	//private GoodsDao goodsDao = MybatisSqlSessionFatory.openSession().getMapper(GoodsDao.class);
	
	
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public List<Goods> query(String keyword){
			Map<String,Object> params = new HashMap<>();
			if(keyword!=null && keyword.length()!=0) {
				params.put("name","%"+keyword+"%");
			}
			
			return goodsDao.findBymap(params, 10, 1);
				
		
	}
	public static void main(String[] args) {
		GoodsBizImpl biz = new GoodsBizImpl();
		List<Goods> query = biz.query("测试");
		System.out.println(query);
		System.out.println(query.size());
	}
}
