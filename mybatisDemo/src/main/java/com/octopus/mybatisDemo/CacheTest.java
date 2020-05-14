package com.octopus.mybatisDemo;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.octopus.mybatisDemo.dao.GoodsDao;
import com.octopus.mybatisDemo.dao.GoodsTypeDao;
import com.octopus.mybatisDemo.entity.Goods;
import com.octopus.mybatisDemo.entity.GoodsType;

/**
 * 测试mybatis的一级缓存和二级缓存
 * 
 * @author hw
 *
 */
public class CacheTest {
	public static void main(String[] args) {
		SqlSession session = MySqlSessionFactory.openSession();
		GoodsDao goodsDao = session.getMapper(GoodsDao.class);
		
		
		//第一次查询
		Goods goods = goodsDao.getById(1L);
		System.out.println(goods.getName());
		//废掉一级缓存的几种方式
		//方式1：修改任何数据
//		goodsDao.delete(1000000L);
		
		//方式2：主动清空缓存
//		session.clearCache();
		
		//方式3:不同session不共享缓存
		session.close();
		
		
		session = MySqlSessionFactory.openSession();
		goodsDao = session.getMapper(GoodsDao.class);
		//第二次查询:如果是没有开启二级缓存，则下面的查询会重新发出sql语句
		new Scanner(System.in).nextLine();//如果我不回车则不会执行
		
		Goods goods1 = goodsDao.getById(1L);
		System.out.println(goods1.getName()+":"+goods1.getPrice());
		
		
		session.close();
	}
}
