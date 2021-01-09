package com.edt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@TableName("t_employee")//默认实体类名与表名一致,要更改则加此注解
public class Employee {
    @TableId(value = "id",type = IdType.AUTO)//指定id自动增长
    private Long id;
    //@TableField("employeeName")//指定当前属性对应的列名
    private String name;
    private String password;
    private String email;
    private int age;
    private int admin;
    private Long deptId;
    @TableField(exist = false) //指定当前属性不参与sql解析,此属性不映射表的列
    private Department dept;
}
