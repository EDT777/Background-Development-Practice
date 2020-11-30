package com.edt.xml_properties.dao;

public class UserDaoImpl {
    //模拟添加和删除操作
    //添加功能需要打印一句话，"添加用户"
    public void add() {
        System.out.printf("添加用户");
    }
    
    public void delete(int index){
        System.out.printf("要删除的用户索引为"+index);
    }
}
