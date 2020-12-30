package cn.wolfcode.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 字典明细
 */
@Setter
@Getter
public class SystemDictionaryItem extends BaseDomain{
    /** 标题*/
    private String title;

    /** 序号*/
    private Integer sequence;

    /** 所属目录*/
    private SystemDictionary type;

    /** 上级明细*/
    private SystemDictionaryItem parent;

    //转为json格式的字符串
    public String getJson(){
        HashMap map = new HashMap(); //更安全,页面要什么就给什么
        map.put("id",id);
        map.put("title",title);
        map.put("sequence",sequence);
        if(type!=null){
            map.put("typeId",type.getId());
        }
        if(parent!=null){
            map.put("parentId",parent.getId());
        }

        return JSON.toJSONString(map);
    }

}