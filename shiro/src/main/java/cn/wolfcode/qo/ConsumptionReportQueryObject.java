package cn.wolfcode.qo;

import cn.wolfcode.enums.ConsumptionReportGroupTypeEnum;
import cn.wolfcode.enums.ConsumptionStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
public class ConsumptionReportQueryObject extends QueryObject {
    private Integer status;//状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Long businessId; //门店
    private Integer appointmentType;//预约类型
    private String groupType = ConsumptionReportGroupTypeEnum.BUSINESS.getValue(); //默认按照门店分组

    public Date getEndDate(){
        if(endDate==null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(Calendar.HOUR,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }
}
