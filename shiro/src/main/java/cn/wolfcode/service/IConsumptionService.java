package cn.wolfcode.service;

import cn.wolfcode.domain.Consumption;
import cn.wolfcode.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IConsumptionService {
    void save(Consumption consumption);
    void update(Consumption consumption);
    void delete(Long id);
    Consumption get(Long id);
    List<Consumption> listAll();
    // 分页查询的方法
    PageInfo<Consumption> query(QueryObject qo);
    // 根据预约单生成结算单
    Consumption saveByAppointmentAno(String ano);
}