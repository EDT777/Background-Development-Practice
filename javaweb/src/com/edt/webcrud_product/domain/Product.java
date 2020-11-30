package com.edt.webcrud_product.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String productName;
    private Long dir_id;
    private BigDecimal salePrice;
    private String supplier;
    private String brand;
    private BigDecimal cutoff;
    private BigDecimal costPrice;
}
