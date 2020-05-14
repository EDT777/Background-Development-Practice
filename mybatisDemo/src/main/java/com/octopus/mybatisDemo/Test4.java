package com.octopus.mybatisDemo;

import org.apache.ibatis.session.SqlSession;

import com.octopus.mybatisDemo.dao.GoodsDao;
import com.octopus.mybatisDemo.dao.GoodsTypeDao;
import com.octopus.mybatisDemo.entity.GoodsType;

/**
 * 引入goods和goodstype后简单测试
 * 
 * @author hw
 *
 */
public class Test4 {
	public static void main(String[] args) {
		SqlSession session = MySqlSessionFactory.openSession();
		GoodsDao goodsDao = session.getMapper(GoodsDao.class);
		GoodsTypeDao goodsTypeDao = session.getMapper(GoodsTypeDao.class);
		
//		GoodsType goods = goodsDao.getById(1L).getGoodsType();
//		GoodsType goods = goodsDao.getById1(1L).getGoodsType();
//		System.out.println(goods);
//		
//		//检验多对一
////		GoodsType goodsType = goodsTypeDao.getById(1L);
//		GoodsType goodsType = goodsTypeDao.getById1(1L);
//		System.out.println(goodsType.getGoods());
//		System.out.println(goodsType.getGoods().get(0).getGoodsType());
		
		
		//验证延迟加载
		GoodsType goodsType = goodsTypeDao.getById(1L);
		System.out.println(goodsType.getTypeName());
		//在有延迟加载的帮助下，只有访问了关联的goods属性才会主动查询
		System.out.println(goodsType.getGoods());
		session.close();
	}
}
