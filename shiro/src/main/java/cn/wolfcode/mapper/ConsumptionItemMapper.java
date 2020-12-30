package cn.wolfcode.mapper;

import cn.wolfcode.domain.ConsumptionItem;
import cn.wolfcode.qo.QueryObject;

import java.util.List;

public interface ConsumptionItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ConsumptionItem record);

    ConsumptionItem selectByPrimaryKey(Long id);

    List<ConsumptionItem> selectAll(String cno);

    int updateByPrimaryKey(ConsumptionItem record);

    List<ConsumptionItem> selectForList(QueryObject qo);

}