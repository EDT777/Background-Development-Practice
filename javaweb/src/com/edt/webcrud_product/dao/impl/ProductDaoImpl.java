package com.edt.webcrud_product.dao.impl;

import com.edt.webcrud_product.dao.IProductDao;
import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.QueryObject;
import com.edt.webcrud_product.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public void insert(Product p) {
        SqlSession session = MybatisUtil.openSession();
        session.insert("com.edt.webcrud_product.mapper.ProductMapper.insert", p);
        session.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        SqlSession session = MybatisUtil.openSession();
        session.delete("com.edt.webcrud_product.mapper.ProductMapper.delete", id);
        session.commit();
        session.close();
    }

    @Override
    public void update(Product p) {
        SqlSession session = MybatisUtil.openSession();
        session.update("com.edt.webcrud_product.mapper.ProductMapper.update", p);
        session.commit();
        session.close();
    }

    @Override
    public Product selectOne(Long id) {
        SqlSession session = MybatisUtil.openSession();
        Product p = session.selectOne("com.edt.webcrud_product.mapper.ProductMapper.selectOne", id);
        session.commit();
        session.close();
        return p;
    }

    @Override
    public List<Product> selectList() {
        SqlSession session = MybatisUtil.openSession();
        List<Product> list = session.selectList("com.edt.webcrud_product.mapper.ProductMapper.selectList");
        session.commit();
        session.close();
        return list;
    }

    @Override
    public int selectForCount(QueryObject qo) {
        SqlSession session = MybatisUtil.openSession();
        int count = session.selectOne("com.edt.webcrud_product.mapper.ProductMapper.selectForCount",qo);
        session.commit();
        session.close();
        return count;
    }

    @Override
    public List<Product> selectForList(QueryObject qo) {
        SqlSession session = MybatisUtil.openSession();
        List<Product> products = session.selectList("com.edt.webcrud_product.mapper.ProductMapper.selectForList",qo);
        session.commit();
        session.close();
        return products;
    }
}
