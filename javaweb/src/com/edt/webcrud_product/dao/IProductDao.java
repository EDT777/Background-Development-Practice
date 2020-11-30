package com.edt.webcrud_product.dao;

import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.QueryObject;

import java.util.List;

public interface IProductDao {
    /**
     * 添加一个货品信息
     */
    void insert(Product p);

    /**
     * 根基货品id 删除货品信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据货品Id 修改货品信息
     *
     * @param p
     */
    void update(Product p);

    /**
     * 根据货品id 查询货品信息
     *
     * @param id
     * @return
     */
    Product selectOne(Long id);

    /**
     * 查询货品信息
     */
    List<Product> selectList();

    //查询数量
    int selectForCount(QueryObject qo);

    //查询指定页数据
    List<Product> selectForList(QueryObject qo);
}
