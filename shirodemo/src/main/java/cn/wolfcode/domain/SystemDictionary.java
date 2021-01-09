package cn.wolfcode.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 字典目录
 */
@Setter
@Getter
public class SystemDictionary extends BaseDomain{
    /** 编码*/
    private String sn;

    /** 标题*/
    private String title;

    /** 简介*/
    private String intro;

    //转为json格式的字符串
    public String getJson(){
        HashMap map = new HashMap(); //更安全,页面要什么就给什么
        map.put("id",id);
        map.put("title",title);
        map.put("sn",sn);
        map.put("intro",intro);
        return JSON.toJSONString(map);
    }

}