package com.edt.webcrud_product.qo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResult<T> {

    private int totalCount; //总数量
    private List<T> data; //某页数据

    //3个计算出来的
    private int totalPage; //总页数
    private int prePage;//上一页
    private int nextPage;//下一页

    //用户传递的
    private int currentPage;
    private int pageSize;

    public PageResult(int totalCount,int pageSize , int currentPage,List<T> data ) {
        this.totalCount = totalCount;
        this.data = data;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize ==0 ?  (totalCount / pageSize)  :  (totalCount / pageSize +1);
        this.prePage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.nextPage =  currentPage + 1 <= this.totalPage ? currentPage + 1 : this.totalPage;
    }
}
