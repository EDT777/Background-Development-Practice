package com.edt.introspector;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String username;
    private Integer age;
    private boolean man;

    public Person(String username, Integer age, boolean man) {
        this.username = username;
        this.age = age;
        this.man = man;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}
