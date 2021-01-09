package cn.wolfcode.qo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
public class ConsumptionQueryObject extends QueryObject {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;//开始时间

    public Date getEndDate(){
        if(endDate==null){
            return null;
        }
        //设置秒为59
//       endDate.setSeconds(59);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }
}
