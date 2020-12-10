package com.edt.one2many2one.one2many.mapper;

import com.edt.one2many2one.one2many.domain.Department;

public interface DepartmentMapper {
    void save(Department department);
    Department get(Long id);
}
