package com.edt.one2many2one.one2many.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString //多
public class Employee {
    private Long id;
    private String name;
    //不算关联属性
    private Long deptId;
}
