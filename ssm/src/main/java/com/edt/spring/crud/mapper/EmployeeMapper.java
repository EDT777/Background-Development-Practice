package com.edt.spring.crud.mapper;

import com.edt.spring.crud.domain.Employee;
import com.edt.spring.crud.qo.Queryobject;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int selectForCount(Queryobject qo);

    List<Employee> selectForList(Queryobject qo);
}