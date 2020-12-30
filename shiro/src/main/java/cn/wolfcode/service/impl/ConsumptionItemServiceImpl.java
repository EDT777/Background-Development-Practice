package cn.wolfcode.service.impl;

import cn.wolfcode.domain.ConsumptionItem;
import cn.wolfcode.mapper.ConsumptionItemMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IConsumptionItemService;
import cn.wolfcode.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ConsumptionItemServiceImpl implements IConsumptionItemService {

    private ConsumptionItemMapper consumptionItemMapper;

    @Autowired
    public void setConsumptionItemMapper(ConsumptionItemMapper consumptionItemMapper) {
        this.consumptionItemMapper = consumptionItemMapper;
    }

    @Override
    @Transactional
    public void save(ConsumptionItem consumptionItem) {
        consumptionItem.setCreateUser(UserContext.getCurrentUser());
        consumptionItem.setCreateTime(new Date());
        consumptionItemMapper.insert(consumptionItem);
    }

    @Override
    @Transactional
    public void update(ConsumptionItem consumptionItem) {
        consumptionItemMapper.updateByPrimaryKey(consumptionItem);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        consumptionItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ConsumptionItem get(Long id) {
        return consumptionItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ConsumptionItem> listAll(String cno) {
        return consumptionItemMapper.selectAll(cno);
    }

    @Override
    public PageInfo<ConsumptionItem> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<ConsumptionItem> consumptionItems = consumptionItemMapper.selectForList(qo);
        return new PageInfo<>(consumptionItems);
    }
}
