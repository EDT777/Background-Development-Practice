package com.octopus.biz.impl;

import java.util.List;

import com.octopus.biz.ProductBiz;
import com.octopus.dao.GenericDAO;
import com.octopus.dao.GenericDAOImpl;
import com.octopus.entity.Product;

public class ProductBizImpl implements ProductBiz {
	private GenericDAO<Product> genericDAO = new GenericDAOImpl<>(Product.class);
	
	@Override
	public Long add(Product p) {
		//判断
		return this.genericDAO.insert(p);
	}

	@Override
	public int delete(long id) {
		return this.genericDAO.delete(id);

	}

	@Override
	public int update(Product p) {
		return this.genericDAO.update(p);
	}
	
	@Override
	public Product findById(long id){
		return this.genericDAO.getById(id);
	}

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
	@Override
	public List<Product> find(String keyword, int pageSize, int pageNum) {

		String where = " name like ? or type_id in (select id from product_type where name like ?)";
		Object[] params = new String[]{"%"+keyword+"%","%"+keyword+"%"};
		

		return this.genericDAO.find(where, params, pageSize, pageNum);
	}
}
