package cn.wolfcode.service.impl;

import cn.wolfcode.mapper.ConsumptionReportMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IConsumptionReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ConsumptionReportServiceImpl implements IConsumptionReportService {

    @Autowired
    private ConsumptionReportMapper consumptionReportMapper;

    @Override
    public PageInfo<Map> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<Map> consumptionReports = consumptionReportMapper.selectConsumptionReport(qo);
        return new PageInfo<>(consumptionReports);
    }

    @Override
    public List<Map> selectAll(QueryObject qo) {
        return consumptionReportMapper.selectConsumptionReport(qo);
    }
}
