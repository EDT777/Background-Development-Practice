package com.edt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //元注解 设置注解在类还是方法等等上
@Retention(RetentionPolicy.RUNTIME) //设置 处于哪个状态
public @interface VIP {
    String value();  //加了这个 才可以在调用此注解括号内加值,若只有这个则可以简写("666"),若有其他没有加default抽象方法则需写 (value="666")
    int age() default 20;
    String[] hobby();
}
