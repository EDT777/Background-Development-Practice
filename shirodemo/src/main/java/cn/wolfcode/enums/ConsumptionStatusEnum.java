package cn.wolfcode.enums;

import lombok.Getter;

@Getter
public enum ConsumptionStatusEnum {
    CONSUME("待结算",0),
    AUDIT("待审核",1),
    FINISH("归档",2),
    FAILURE("坏账",3);

    private String name;
    private int value;

    ConsumptionStatusEnum(String name, int value) {
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
        ConsumptionStatusEnum[] enums = values();
        //获取每个枚举实例
        for (ConsumptionStatusEnum anEnum : enums) {
            //判断当前实例的value值是否与传进来的参数相等
            if(anEnum.value==value){
                return anEnum.name;
            }
        }
        return null;
    }
}


