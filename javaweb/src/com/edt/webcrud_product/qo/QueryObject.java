package com.edt.webcrud_product.qo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryObject {
    private int currentPage = 1;
    private int pageSize =5;
//用Limit 子句第一个参数取值使用
    public int getStart(){
        return  (currentPage - 1 ) * pageSize;
    }
}
