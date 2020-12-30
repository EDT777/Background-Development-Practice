package cn.wolfcode.service.impl;

import cn.wolfcode.domain.Business;
import cn.wolfcode.mapper.BusinessMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IBusinessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessServiceImpl implements IBusinessService {

    private BusinessMapper businessMapper;

    @Autowired
    public void setBusinessMapper(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    @Override
    @Transactional
    public void save(Business business) {
        businessMapper.insert(business);
    }

    @Override
    @Transactional
    public void update(Business business) {
        businessMapper.updateByPrimaryKey(business);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        businessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Business get(Long id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Business> listAll() {
        return businessMapper.selectAll();
    }

    @Override
    public PageInfo<Business> query(QueryObject qo) {
        //使用分页插件， 传入当前页，每页显示数量（要分页的sql必须写到startPage的后面）
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(),"main_store desc");
        List<Business> businesss = businessMapper.selectForList(qo);
        return new PageInfo<>(businesss);
    }

    @Override
    public List<Business> selectByMainStore(boolean mainStore) {
        return businessMapper.selectByMainStore(mainStore);
    }
}
