package com.octopus.biz;

import java.util.List;

import com.octopus.entity.Product;

public interface ProductBiz {

	Long add(Product p);

	int delete(long id);

	int update(Product p);

	Product findById(long id);

	/**
	 * 后台管理员所用的搜索功能
	 * 
	 * @param keyword
	 *            搜索关键字，可以为名称、分类
	 * @param pageSize
	 *            每页数量
	 * @param pageNum
	 *            第几页
	 * @return
	 */
	List<Product> find(String keyword, int pageSize, int pageNum);

}