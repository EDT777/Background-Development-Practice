package com.edt.spring.crud.qo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageResult<T> {
//页面传的
    private int currentPage;
    private int pageSize;
//数据库查询
    private int totalCount;
    private List<T> data;

    private int totalPage;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页

    public PageResult(int currentPage, int pageSize, int totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;

        this.totalPage = totalCount % pageSize==0? totalCount /pageSize : totalCount /pageSize +1;
        this.prePage = currentPage - 1 >=1 ? currentPage -1 :1;
        this.nextPage = currentPage +1 <= totalPage ?currentPage+1:totalPage;
    }
}
