package cn.wolfcode.service.impl;

import cn.wolfcode.domain.SystemDictionaryItem;
import cn.wolfcode.mapper.SystemDictionaryItemMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.ISystemDictionaryItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemDictionaryItemServiceImpl implements ISystemDictionaryItemService {

    private SystemDictionaryItemMapper systemDictionaryItemMapper;

    @Autowired
    public void setSystemDictionaryItemMapper(SystemDictionaryItemMapper systemDictionaryItemMapper) {
        this.systemDictionaryItemMapper = systemDictionaryItemMapper;
    }

    @Override
    @Transactional
    public void save(SystemDictionaryItem systemDictionaryItem) {
        systemDictionaryItemMapper.insert(systemDictionaryItem);
    }

    @Override
    @Transactional
    public void update(SystemDictionaryItem systemDictionaryItem) {
        systemDictionaryItemMapper.updateByPrimaryKey(systemDictionaryItem);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        systemDictionaryItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SystemDictionaryItem get(Long id) {
        return systemDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemDictionaryItem> listAll() {
        return systemDictionaryItemMapper.selectAll();
    }

    @Override
    public PageInfo<SystemDictionaryItem> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemMapper.selectForList(qo);
        return new PageInfo<>(systemDictionaryItems);
    }

    @Override
    public List<SystemDictionaryItem> selectByTypeId(Long typeId) {
        return systemDictionaryItemMapper.selectByTypeId(typeId);
    }

    @Override
    public List<SystemDictionaryItem> selectByTypeSn(String sn) {
        return systemDictionaryItemMapper.selectByTypeSn(sn);
    }

    @Override
    public List<SystemDictionaryItem> selectByParentId(Long id) {
        return systemDictionaryItemMapper.selectByParentId(id);
    }
}
