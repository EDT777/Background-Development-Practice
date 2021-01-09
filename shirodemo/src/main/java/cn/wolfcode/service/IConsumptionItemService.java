package cn.wolfcode.service;

import cn.wolfcode.domain.ConsumptionItem;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IConsumptionItemService {
    void save(ConsumptionItem consumptionItem);
    void update(ConsumptionItem consumptionItem);
    void delete(Long id);
    ConsumptionItem get(Long id);
    //根据结算单流水号查询所有明细
    List<ConsumptionItem> listAll(String cno);
    // 分页查询的方法
    PageInfo<ConsumptionItem> query(QueryObject qo);
}