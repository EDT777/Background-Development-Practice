package com.edt.webcrud_good.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Good {
    private Long id;
    private String name;
    private float price;
    private String detail;
    private Date createTime;


}
