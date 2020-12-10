package com.edt.spring.crud.qo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeQueryObject extends Queryobject{
    private String keyword;
    private Long deptId;
}
