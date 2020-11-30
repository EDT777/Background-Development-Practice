package com.edt.webcrud_product.service.impl;

import com.edt.webcrud_product.dao.IProductDao;
import com.edt.webcrud_product.dao.impl.ProductDaoImpl;
import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.PageResult;
import com.edt.webcrud_product.qo.QueryObject;
import com.edt.webcrud_product.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductDao productDao = new ProductDaoImpl();
    @Override
    public PageResult<Product> query(QueryObject ob) {
        int count = productDao.selectForCount(ob);
        List<Product> products=  productDao.selectForList(ob);
        PageResult<Product> result =new PageResult<>(count,ob.getPageSize(),ob.getCurrentPage(),products);

        return result;
    }
}
