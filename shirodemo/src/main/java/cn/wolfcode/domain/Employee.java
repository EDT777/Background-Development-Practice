package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Employee extends BaseDomain{
    private String name;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private boolean admin; // true false
    private Department dept;
    private List<Role> roles = new ArrayList<>();
}