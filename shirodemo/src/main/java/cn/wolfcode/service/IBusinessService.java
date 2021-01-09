package cn.wolfcode.service;

import cn.wolfcode.domain.Business;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBusinessService {
    void save(Business business);
    void update(Business business);
    void delete(Long id);
    Business get(Long id);
    List<Business> listAll();
    // 分页查询的方法
    PageInfo<Business> query(QueryObject qo);
    //根据门店性质查询门店
    List<Business> selectByMainStore(boolean mainStore);
}