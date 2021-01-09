package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 结算明细
 */
@Setter
@Getter
public class ConsumptionItem extends BaseDomain{

    /** 业务大类*/
    private SystemDictionaryItem category;

    /** 业务小类*/
    private SystemDictionaryItem categoryItem;

    /** 结算类型*/
    private SystemDictionaryItem payType;

    /** 应收金额*/
    private BigDecimal amount;

    /** 实收金额*/
    private BigDecimal payAmount;

    /** 优惠金额*/
    private BigDecimal discountAmount;

    /** 创建人*/
    private Employee createUser;

    /** 创建时间*/
    private Date createTime;

    /** 结算单流水号*/
    private String cno;

}