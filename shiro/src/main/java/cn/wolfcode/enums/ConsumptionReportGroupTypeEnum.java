package cn.wolfcode.enums;

import lombok.Getter;

@Getter
public enum ConsumptionReportGroupTypeEnum {
    BUSINESS("门店","b.name"),
    YEAR("年份","YEAR(c.create_time)"),
    MONTH("月份","DATE_FORMAT(c.create_time,'%Y-%m')"),
    DAY("日期","DATE_FORMAT(c.create_time,'%Y-%m-%d')");

    private String name;
    private String value;

    ConsumptionReportGroupTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 根据value查名字
     * @param value
     * @return
     */
    public static String findName(String value) {
        //获取当前枚举类中的所有实例对象
        ConsumptionReportGroupTypeEnum[] enums = values();
        //获取每个枚举实例
        for (ConsumptionReportGroupTypeEnum anEnum : enums) {
            //判断当前实例的value值是否与传进来的参数相等
            if(anEnum.value.equals(value)){
                return anEnum.name;
            }
        }
        return null;
    }
}


