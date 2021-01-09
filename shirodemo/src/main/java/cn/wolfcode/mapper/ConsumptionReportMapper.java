package cn.wolfcode.mapper;

import cn.wolfcode.qo.QueryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConsumptionReportMapper {
    List<Map> selectConsumptionReport(QueryObject qo);
}
