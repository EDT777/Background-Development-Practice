package com.edt.one2many2one.one2many.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString // 一
public class Department {
    private Long id;
    private String name;

//    关联属性
    private List<Employee> employees =new ArrayList<>();
}
