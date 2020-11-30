package com.edt.forward_redirect_scope_el_jstl.demo.domin;

public class Student {
    private Long id;
    private Long number ;
    private String name;
    private String sex;
    private Double score;


    public Student() {
    }

    public Student(Long number, String name, String sex, Double score) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public Student(Long id, Long number, String name, String sex, Double score) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
