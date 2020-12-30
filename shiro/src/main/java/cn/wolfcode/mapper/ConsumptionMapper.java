package cn.wolfcode.mapper;

import cn.wolfcode.domain.Consumption;
import cn.wolfcode.qo.QueryObject;

import java.util.List;

public interface ConsumptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Consumption record);

    Consumption selectByPrimaryKey(Long id);

    List<Consumption> selectAll();

    int updateByPrimaryKey(Consumption record);

    List<Consumption> selectForList(QueryObject qo);
}