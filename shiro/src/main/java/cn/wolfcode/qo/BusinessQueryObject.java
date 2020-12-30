package cn.wolfcode.qo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class BusinessQueryObject extends QueryObject {
    private String name;//门店名称
    private String scope;//经营范围
    private String tel;//门店电话
    private String legalName;//法人名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//开始时间

}
