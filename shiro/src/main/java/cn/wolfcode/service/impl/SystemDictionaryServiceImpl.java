package cn.wolfcode.service.impl;

import cn.wolfcode.domain.SystemDictionary;
import cn.wolfcode.mapper.SystemDictionaryMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.ISystemDictionaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemDictionaryServiceImpl implements ISystemDictionaryService {

    private SystemDictionaryMapper systemDictionaryMapper;

    @Autowired
    public void setSystemDictionaryMapper(SystemDictionaryMapper systemDictionaryMapper) {
        this.systemDictionaryMapper = systemDictionaryMapper;
    }

    @Override
    @Transactional
    public void save(SystemDictionary systemDictionary) {
        systemDictionaryMapper.insert(systemDictionary);
    }

    @Override
    @Transactional
    public void update(SystemDictionary systemDictionary) {
        systemDictionaryMapper.updateByPrimaryKey(systemDictionary);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        systemDictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SystemDictionary get(Long id) {
        return systemDictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemDictionary> listAll() {
        return systemDictionaryMapper.selectAll();
    }

    @Override
    public PageInfo<SystemDictionary> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        List<SystemDictionary> systemDictionarys = systemDictionaryMapper.selectForList(qo);
        return new PageInfo<>(systemDictionarys);
    }
}
