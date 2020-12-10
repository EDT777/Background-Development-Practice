package com.edt.spring.crud.service.impl;

import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.mapper.Department2Mapper;
import com.edt.spring.crud.qo.PageResult;
import com.edt.spring.crud.qo.Queryobject;
import com.edt.spring.crud.service.IDepartment2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class Department2ServiceImpl implements IDepartment2Service {

    @Autowired
    private Department2Mapper department2Mapper;

    @Override
    public void save(Department2 department2) {
        department2Mapper.insert(department2);
    }

    @Override
    public void delete(Long id) {
        department2Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Department2 department2) {
        department2Mapper.updateByPrimaryKey(department2);
    }

    @Override
    public Department2 get(Long id) {

        return department2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department2> listAll() {
        return department2Mapper.selectAll();
    }

    @Override
    public PageResult<Department2> query(Queryobject qo) {
     int count = department2Mapper.selectForCount(qo);
     if (count ==0){
         return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count, Collections.emptyList());
     }

     List<Department2> department2s = department2Mapper.selectForList(qo);
        return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count,department2s);
    }
}
