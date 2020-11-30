package com.edt.webcrud_product.service;

import com.edt.webcrud_product.domain.Product;
import com.edt.webcrud_product.qo.PageResult;
import com.edt.webcrud_product.qo.QueryObject;

public interface IProductService {
      PageResult<Product> query(QueryObject ob);
  }
