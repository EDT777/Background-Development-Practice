package com.edt.forward_redirect_scope_el_jstl.jstl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class Person {
    private Integer age =18;
    private Date date = new Date();
    private List<String> list = Arrays.asList("A","B","C");
    //创建HashMap对象,存入3个元素
    private Map<String,String> map = new HashMap<>(){
        {
            this.put("name","小豪");
            this.put("host","com.edt");
            this.put("com.edt","host");
        }
    };


}
