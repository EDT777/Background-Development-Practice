package com.edt.spring.ioc_di;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String name;

    public void doWork(){
        System.out.println(name+"喜欢工作");
    }
}
