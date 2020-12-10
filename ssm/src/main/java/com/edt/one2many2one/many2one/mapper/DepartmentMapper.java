package com.edt.one2many2one.many2one.mapper;

import com.edt.one2many2one.many2one.domain.Department;

public interface DepartmentMapper {
        void save(Department dept);
        Department get(Long id);
}
