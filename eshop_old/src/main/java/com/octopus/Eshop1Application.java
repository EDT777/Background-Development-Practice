package com.octopus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.octopus.common.dao","com.octopus.project.dao"})
public class Eshop1Application {

	public static void main(String[] args) {
		SpringApplication.run(Eshop1Application.class, args);
		System.out.println("开启成功");
	}

}
