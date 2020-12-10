package com.edt.one2many2one.one2many.mapper;

import com.edt.one2many2one.one2many.domain.Employee;

public interface EmployeeMapper {
    void save(Employee employee);
    Employee queryByDeptId(Long deptId);
}
