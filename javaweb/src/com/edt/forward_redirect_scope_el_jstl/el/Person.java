package com.edt.forward_redirect_scope_el_jstl.el;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@ToString
public class Person {
    private Long id = 001L;
    private String username="小豪";
    private Integer age =18;
    private String[] hobby ={"java","bug","game"};
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
