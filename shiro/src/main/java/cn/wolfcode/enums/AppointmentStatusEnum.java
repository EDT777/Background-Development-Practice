package cn.wolfcode.enums;

import lombok.Getter;

@Getter
public enum AppointmentStatusEnum {
    PEND("待确认",0),
    PREFORM("履行中",1),
    CONSUME("消费中",2),
    FINISH("归档",3),
    FAILURE("废弃单",4);

    private String name;
    private int value;

    AppointmentStatusEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 根据value查名字
     * @param value
     * @return
     */
    public static String findName(Integer value) {
        //获取当前枚举类中的所有实例对象
        AppointmentStatusEnum[] enums = values();
        //获取每个枚举实例
        for (AppointmentStatusEnum anEnum : enums) {
            //判断当前实例的value值是否与传进来的参数相等
            if(anEnum.value==value){
                return anEnum.name;
            }
        }
        return null;
    }
}


