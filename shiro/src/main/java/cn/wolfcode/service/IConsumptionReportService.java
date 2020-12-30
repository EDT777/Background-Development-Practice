package cn.wolfcode.service;

import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IConsumptionReportService {

    PageInfo<Map> query(QueryObject qo);

    List<Map> selectAll(QueryObject qo);
}
