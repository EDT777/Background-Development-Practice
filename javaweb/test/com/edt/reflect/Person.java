package com.edt.reflect;

public class Person {
    private String name;
    private int age;

    Person() {

    }
    private void doo(){
        System.out.println("私有的敲代码方法");
    }
    public  void eat(){
        System.out.println("吃东西");
    }
    public static void sleep(int i){
        System.out.println("游泳 游了"+i+"米");
    }
    public void doWork(String s) {
        System.out.println(s+"敲代码");
    }

    private void doWork() {
        System.out.println("敲代码    了");
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
