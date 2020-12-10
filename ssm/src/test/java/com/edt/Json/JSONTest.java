package com.edt.Json;

import com.alibaba.fastjson.JSON;
import com.edt.spring.crud.domain.Department2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;


public class JSONTest {
    @Test
    public void testJSON() throws IOException {
//        id 1 name 开发部 sn DEV
//        {"id":1,"name":"开发部","sn":"DEV"}
        String name ="开发部";
        Long id = 1L;
        String sn = "DEV";
        String jsonStr = "{\"id\":1,\"name\":\"开发部\",\"sn\":\"DEV\"}";

        ObjectMapper objectMapper = new ObjectMapper();
//        JSON -> java对象
        Department2 department2 =objectMapper.readValue(jsonStr,Department2.class);
        System.out.println(department2);

//        java 对象转 -> JSON
        System.out.println(objectMapper.writeValueAsString(department2));


        // 阿里巴巴的Json方式!!!!!!!!!!!!!!!!!!!!!!!! 记得加依赖
//        JSON -> java对象
        System.out.println(JSON.parseObject(jsonStr,Department2.class));
//        java对象 ->JSON
        System.out.println(JSON.toJSONString(department2));
    }


}
