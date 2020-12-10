package com.edt.spring.crud.mapper;

import com.edt.spring.crud.domain.Department2;
import com.edt.spring.crud.qo.Queryobject;

import java.util.List;

public interface Department2Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department2 record);

    Department2 selectByPrimaryKey(Long id);

    List<Department2> selectAll();

    int updateByPrimaryKey(Department2 record);

    int selectForCount(Queryobject qo);

    List<Department2> selectForList(Queryobject qo);
}