package com.edt.spring.crud.service;

import com.edt.spring.crud.domain.Employee;
import com.edt.spring.crud.qo.PageResult;
import com.edt.spring.crud.qo.Queryobject;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);
    void delete(Long id);
    void update(Employee employee);
    Employee get(Long id);
    List<Employee> listAll();
    //分页查询方法
    PageResult<Employee> query(Queryobject queryobject);

}