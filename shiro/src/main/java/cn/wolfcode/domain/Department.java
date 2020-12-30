package cn.wolfcode.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Setter
@Getter
@ToString
public class Department extends BaseDomain{
    private String name;
    private String sn;

    //转为json格式的字符串
    public String getJson(){
        HashMap map = new HashMap(); //更安全,页面要什么就给什么
        map.put("id",getId());
        map.put("name",name);
        map.put("sn",sn);
        return JSON.toJSONString(map);
    }
}