package com.edt.spring.anno_proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Dog {
    @Value("白蓝色")
    private String color;

}
