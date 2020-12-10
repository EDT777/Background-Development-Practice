package com.edt.spring.ioc_di;

import org.springframework.beans.factory.FactoryBean;

//cat 工厂类,里面专门有方法创建 cat 对象
public class Cat2FactoryBean implements FactoryBean<Cat2> {
    @Override
    public Cat2 getObject() throws Exception {
        return new Cat2();
    }

    @Override
    public Class<?> getObjectType() {
        return Cat2.class;
    }
}
