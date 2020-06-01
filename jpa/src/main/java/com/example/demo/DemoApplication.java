package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("springboot项目开始启动了");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("springboot项目开始启动完了");
    }

}
