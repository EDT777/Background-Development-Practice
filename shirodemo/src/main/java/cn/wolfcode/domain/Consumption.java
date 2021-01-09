package cn.wolfcode.domain;

import cn.wolfcode.enums.ConsumptionStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 结算单
 */
@Setter
@Getter
public class Consumption extends BaseDomain{

    /** 结算单流水号*/
    private String cno;

    /** 结算单状态 （待结算/待审核/归档/坏账）*/
    private Integer status;

    /** 总消费金额*/
    private BigDecimal totalAmount;

    /** 实收金额*/
    private BigDecimal payAmount;

    /** 优惠金额*/
    private BigDecimal discountAmount;

    /** 结算备注*/
    private String info;

    /** 结算时间*/
    private Date payTime;

    /** 结算人*/
    private Employee payee;

    /** 客户名称*/
    private String customerName;

    /** 客户联系方式*/
    private String customerTel;

    /** 车牌信息记录*/
    private String carLicence;

    /** 车型记录*/
    private String carType;

    /** 关联预约单流水号*/
    private String appointmentAno;

    /** 进店时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date checkinTime;

    /** 离店时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date checkoutTime;

    /** 消费门店*/
    private Business business;

    /** 创建时间*/
    private Date createTime;

    /** 创建人*/
    private Employee createUser;

    /** 审核时间*/
    private Date auditTime;

    /** 审核人*/
    private Employee auditor;

    public String getStatusName(){
        return ConsumptionStatusEnum.findName(status);
    }

}