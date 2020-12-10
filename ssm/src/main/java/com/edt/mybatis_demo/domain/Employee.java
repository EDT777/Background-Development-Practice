package com.edt.mybatis_demo.domain;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String sn;
    private BigDecimal salary;
    private Long deptId;
}
