package com.edt.spring.crud.service;

import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.qo.PageResult;
import com.edt.spring.crud.qo.Queryobject;

import java.util.List;

public interface IDepartment2Service {
    void save(Department2 department2);
    void delete(Long id);
    void update(Department2 department2);
    Department2 get(Long id);
    List<Department2> listAll();
//分页查询方法
     PageResult<Department2> query(Queryobject queryobject);

}