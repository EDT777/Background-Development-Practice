package com.edt.one2many2one.many2one.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //一 对应数据库
public class Department {
    private Long id;
    private String name;
}
