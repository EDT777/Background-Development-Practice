package com.edt.one2many2one.many2one.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //多
public class Employee {
    private Long id;
    private String name;
    //关联属性
    private Department dept;
}
