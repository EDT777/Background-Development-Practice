package cn.wolfcode.qo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SystemDictionaryItemQueryObject extends QueryObject{
    private Long typeId;//所属目录id
    private Long parentId;//上级明细id
}
