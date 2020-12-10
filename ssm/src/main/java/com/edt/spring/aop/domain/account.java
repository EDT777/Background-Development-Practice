package com.edt.spring.aop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
@Setter
@Getter
@ToString
public class account {
    private Long id;
    private BigDecimal balance;
}
