package com.edt.spring.aop.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;


public interface AccountMapper {
//    加钱
    void addBalance(@Param("inId") Long inId, @Param("amount") BigDecimal amount);
//    减钱
    void subtractBalance(@Param("outId") Long outId,@Param("amount") BigDecimal amount);

}
