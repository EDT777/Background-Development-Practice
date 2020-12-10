package com.edt.spring.aop.service;

import java.math.BigDecimal;

public interface IAccountService {
//    转账
    void transfer(Long outId, Long inId, BigDecimal amount);

}
