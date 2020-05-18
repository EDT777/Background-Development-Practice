package com.example.demo;


import org.springframework.web.bind.annotation.*;


//第一个Java数据api接口
@RestController
public class Hello {


    @GetMapping("/hello")
    public String hello() {
        return "你好，我是编程小石头123456";
    }

    /*
    * http://localhost:8080/demo/20
    * */
    @GetMapping("/demo/{id}")
    public String demo(@PathVariable("id") String id) {
        System.out.println("id="+id);
        return id;
    }

    /*
    * http://localhost:8080/demo2?age=20
    * */
    @GetMapping("/demo2")
    public String demo2(@RequestParam("age") String age) {
        System.out.println("age="+age);
        return age;
    }

    /*
    * http://localhost:8080/demo3
    * */
    @PostMapping("/demo3")
    public String demo3(@RequestParam("name") String name) {
        System.out.println("name="+name);
        return name;
    }

    /*
    * java后台实现加法，
    * http://localhost:8080/demo4
    * */
    @PostMapping("/demo4")
    public String demo4(@RequestParam("a") int a,@RequestParam("b") int b) {
        System.out.println("a+b="+(a+b));
        return ""+(a+b);
    }


}
