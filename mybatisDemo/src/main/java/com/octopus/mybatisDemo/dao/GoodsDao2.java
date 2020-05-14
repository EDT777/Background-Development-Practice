package com.octopus.mybatisDemo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.octopus.mybatisDemo.entity.Goods;


/**
 * 商品的数据操作类:演示使用注解实现mybatis查询
 * @author hw
 *
 */
public interface GoodsDao2 {
	/**
	 * 添加商品
	 * @param goods
	 * @return 是否添加成功
	 */
	public int insert(Goods goods);
	
	/**
	 * 修改商品
	 * @param goods
	 * @return 是否修改成功
	 */
	public int update(Goods goods);
	
	/**
	 * 删除商品
	 * @param goods
	 * @return 是否删除成功
	 */
	public int delete(Long id);
	
	
	/**
	 * 根据主键的值获取整个对象
	 * @param id
	 * @return
	 */
	@Select("select * from goods where id=#{id}")
	public Goods getById(Long id);
	
	public Goods getById1(Long id);
	
	/**
	 * 根据条件查找
	 * @param where sql语句的条件
	 * @param params 条件中对应的参数
	 * @param pageNum 页码，从1开始
	 * @param pageSize 页大小
	 * @return
	 */
	@SelectProvider(type = MySqlProvider.class,method = "buildSqlDemo")
	public List<Goods> findByWhere(Map<String,Object> params);

	
	/**
	 * 分页辅助方法，查询指定条件下数据的总条数
	 * @param where sql语句的条件
	 * @param params 条件中对应的参数
	 * @return
	 */
	public int countByWhere(String where,Object[] params);
}
