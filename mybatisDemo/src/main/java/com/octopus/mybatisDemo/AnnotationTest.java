package com.octopus.mybatisDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.octopus.mybatisDemo.dao.GoodsDao;
import com.octopus.mybatisDemo.dao.GoodsDao2;
import com.octopus.mybatisDemo.dao.GoodsTypeDao;
import com.octopus.mybatisDemo.entity.Goods;
import com.octopus.mybatisDemo.entity.GoodsType;

/**
 * 测试使用注解方式
 * 
 * @author hw
 *
 */
public class AnnotationTest {
	public static void main(String[] args) {
		SqlSession session = MySqlSessionFactory.openSession();
		GoodsDao2 goodsDao = session.getMapper(GoodsDao2.class);
		
		
		//第一次查询
		Goods goods = goodsDao.getById(1L);
		System.out.println(goods.getName());
		
		//测试SqlProvier的使用
		Map<String,Object> map = new HashMap<>();
		map.put("name", "测试");
		List<Goods> goodses = goodsDao.findByWhere(map);
		System.out.println(goodses);
		
		session.close();
	}
}
