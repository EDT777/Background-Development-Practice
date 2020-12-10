package com.edt.spring.aop.service.impl;

import com.edt.spring.aop.mapper.AccountMapper;
import com.edt.spring.aop.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void transfer(Long outId, Long inId, BigDecimal amount) {
               accountMapper.subtractBalance(outId,amount);
               int i = 1/0;
               accountMapper.addBalance(inId,amount);
    }
}
