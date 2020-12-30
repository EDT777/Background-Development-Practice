package cn.wolfcode.domain;

import cn.hutool.core.date.DateUtil;
import cn.wolfcode.enums.AppointmentStatusEnum;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 预约单
 */
@Setter
@Getter
public class Appointment extends BaseDomain{
    /** 预约单流水号*/
    private String ano;

    /** 预约单状态 （待确认0/履行中1/消费中2/归档3/废弃单4）*/
    private Integer status;

    /** 业务大类*/
    private SystemDictionaryItem category;

    /** 预约说明*/
    private String info;

    /** 联系电话*/
    private String contactTel;

    /** 联系人名称*/
    private String contactName;

    /** 预约门店*/
    private Business business;

    /** 创建时间*/
    private Date createTime;

    /** 预约时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date appointmentTime;

    public String getStatusName(){
        //直接传入预约单的状态值，希望返回对应中文名称
        return AppointmentStatusEnum.findName(status);
    }

    //转为json格式的字符串
    public String getJson(){
        HashMap map = new HashMap(); //更安全,页面要什么就给什么
        map.put("id",getId());
//        map.put("appointmentTime", DateUtil.format(appointmentTime,"yyyy-MM-dd HH:mm"));
//        map.put("sn",sn);
        return JSON.toJSONString(map);
    }
}