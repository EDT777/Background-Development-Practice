package cn.wolfcode.mapper;

import cn.wolfcode.domain.SystemDictionaryItem;
import cn.wolfcode.qo.QueryObject;

import java.util.List;

public interface SystemDictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);

    List<SystemDictionaryItem> selectForList(QueryObject qo);

    List<SystemDictionaryItem> selectByTypeId(Long typeId);

    List<SystemDictionaryItem> selectByTypeSn(String sn);

    List<SystemDictionaryItem> selectByParentId(Long id);
}