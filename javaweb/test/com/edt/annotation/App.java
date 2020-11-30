package com.edt.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Class<Employee> clz = Employee.class;
        //获取类上 注解的实例
        Annotation[] annotations = clz.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation);
        }
        //获取指定的注解
        VIP vip =  clz.getAnnotation(VIP.class);
        System.out.println(Arrays.toString(vip.hobby()));
        System.out.println(vip.value());

    }
}
