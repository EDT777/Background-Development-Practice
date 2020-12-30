package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 权限
 */
@Setter
@Getter
public class Permission extends BaseDomain{
    /** 权限名称*/
    private String name;

    /** 权限表达式*/
    private String expression;
}