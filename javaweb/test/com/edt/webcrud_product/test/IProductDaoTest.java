package com.edt.webcrud_product.test;


import com.edt.webcrud_product.dao.IProductDao;
import com.edt.webcrud_product.dao.impl.ProductDaoImpl;
import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.PageResult;
import com.edt.webcrud_product.qo.ProductQueryObject;
import com.edt.webcrud_product.qo.QueryObject;
import com.edt.webcrud_product.service.IProductService;
import com.edt.webcrud_product.service.impl.ProductServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class IProductDaoTest {
    private IProductDao productDao = new ProductDaoImpl();
    private IProductService productService = new ProductServiceImpl();
    @Test
    public void ProductServiceTest(){

        ProductQueryObject qb = new ProductQueryObject();
        qb.setMinSalePrice(new BigDecimal("400"));
        qb.setMaxSalePrice(new BigDecimal("600"));
        qb.setCurrentPage(1);
        PageResult result = productService.query(qb);
        System.out.println("当前页数据为:"+result.getData());
        System.out.println("当前页为:"+result.getCurrentPage());
        System.out.println("上一页为:"+result.getPrePage());
        System.out.println("下一页为:"+result.getNextPage());
        System.out.println("当前页的条数: "+result.getData().size());
        System.out.println("总条数:"+result.getTotalCount());
        System.out.println("总页数为:"+result.getTotalPage());
    }

    @Test
    public void selectForCount() {
        ProductQueryObject qb = new ProductQueryObject();
        qb.setMinSalePrice(new BigDecimal("400"));
        qb.setMaxSalePrice(new BigDecimal("600"));
        System.out.println(productDao.selectForCount(qb));
    }

    @Test
    public void selectForList() {
        QueryObject queryObject = new QueryObject();
        List<Product> list = productDao.selectForList(queryObject);
        System.out.println(list);
    }


    @Test
    public void insert() {
        Product p = new Product(null, "小豪鼠标434", 3L
                , new BigDecimal("200"), "超级工厂"
                , "EDT", new BigDecimal("0.5")
                , new BigDecimal("2000"));
        productDao.insert(p);

    }

    @Test
    public void delete() {
        productDao.delete(2L);
    }

    @Test
    public void update() {
        Product p = new Product(20L, "小豪22鼠标", 3L
                , new BigDecimal("200"), "超级工厂"
                , "EDT", new BigDecimal("0.5")
                , new BigDecimal("2000"));
        productDao.update(p);
    }

    @Test
    public void selectOne() {
        System.out.println(productDao.selectOne(2L));
    }

    @Test
    public void selectList() {
        System.out.println(productDao.selectList());
    }
}
