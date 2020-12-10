package com.edt.one2many2one.many2many.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Student {
    private Long id;
    private String name;
    //关联属性
    private List<Teacher> teachers= new ArrayList<>();
}
