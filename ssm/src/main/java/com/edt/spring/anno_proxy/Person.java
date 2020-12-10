package com.edt.spring.anno_proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Setter
@Component
public class Person {
    @Autowired
    private Dog dog;

}