package com.octopus.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@ComponentScan("com.octopus")
@MapperScan("com.octopus.dao")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
        System.out.println( "Hello World!" );
    }
}
