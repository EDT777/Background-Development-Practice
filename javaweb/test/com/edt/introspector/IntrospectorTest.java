package com.edt.introspector;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectorTest {

    @Test
    public void testIntrospect() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clz =Person.class;
        Object obj =clz.newInstance();
        //通过内省来获取javaBean属性和操作属性
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class ,Object.class);//前闭后开,1起始,2停止点   把javaBean转化成javaBean信息描述对象
        //获取和操作属性
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd :pds){
            System.out.print(pd.getName()+":");
            //获取set方法
            Method m =pd.getWriteMethod();
            if(pd.getName().equals("username")){//判断不同属性 给值的类型不同
                m.invoke(obj,"小豪");  //调用set方法,赋值进去
                Method m1 = pd.getReadMethod();//获取get方法
                Object o1 =m1.invoke(obj);//调用get方法后 返回值
                System.out.println(o1);//输出属性数值
            }else  if(pd.getName().equals("age")){
                m.invoke(obj,22);
                Method m2 = pd.getReadMethod();
                Object o2 =m2.invoke(obj);
                System.out.println(o2);
            }else if(pd.getName().equals("man")){
                m.invoke(obj,true);
                Method m3 = pd.getReadMethod();
                Object o3 =m3.invoke(obj);
                System.out.println(o3);
            }
        }

    }
}
