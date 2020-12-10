package com.edt.one2many2one.many2one.mapper;

import com.edt.one2many2one.many2one.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    void save(Employee employee);
    Employee get(Long id);
    List<Employee> getList();
}
