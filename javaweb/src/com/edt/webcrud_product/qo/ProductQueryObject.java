package com.edt.webcrud_product.qo;

import com.edt.webcrud_product.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductQueryObject extends QueryObject{
    private String productName;
    private BigDecimal minSalePrice;
    private BigDecimal maxSalePrice;

    public String getProductName() {
        if (StringUtil.hasLength(productName)) {
            return productName;
        }
        return null;
    }

}

