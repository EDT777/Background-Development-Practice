package cn.wolfcode.service;

import cn.wolfcode.domain.SystemDictionaryItem;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISystemDictionaryItemService {
    void save(SystemDictionaryItem systemDictionaryItem);
    void update(SystemDictionaryItem systemDictionaryItem);
    void delete(Long id);
    SystemDictionaryItem get(Long id);
    List<SystemDictionaryItem> listAll();
    // 分页查询的方法
    PageInfo<SystemDictionaryItem> query(QueryObject qo);

    List<SystemDictionaryItem> selectByTypeId(Long typeId);

    List<SystemDictionaryItem> selectByTypeSn(String sn);

    List<SystemDictionaryItem> selectByParentId(Long sn);
}