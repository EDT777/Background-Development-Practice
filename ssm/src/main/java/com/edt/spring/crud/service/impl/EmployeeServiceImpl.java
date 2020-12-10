package com.edt.spring.crud.service.impl;

import com.edt.spring.crud.domain.Employee;
import com.edt.spring.crud.mapper.EmployeeMapper;
import com.edt.spring.crud.qo.PageResult;
import com.edt.spring.crud.qo.Queryobject;
import com.edt.spring.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void save(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Employee get(Long id) {

        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeMapper.selectAll();
    }

    @Override
    public PageResult<Employee> query(Queryobject qo) {
     int count = employeeMapper.selectForCount(qo);
     if (count ==0){
         return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count, Collections.emptyList());
     }

     List<Employee> employees = employeeMapper.selectForList(qo);
        return new PageResult<>(qo.getCurrentPage(),qo.getPageSize(),count,employees);
    }
}
