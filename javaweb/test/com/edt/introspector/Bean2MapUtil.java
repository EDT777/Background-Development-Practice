package com.edt.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Bean2MapUtil {

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException, InstantiationException {
        Person p = new Person("小豪",22,true);
        Map<String,Object> map=bean2map(p);
        System.out.println(map);
        Object o =map2bean(map,Person.class);
        System.out.println(o);
    }
    //将javaBean对象 转换成map
    public static Map<String,Object> bean2map(Object o) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Map<String,Object> map =new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass(),Object.class); //将javaBean对象转化成JavaBean信息描述对象 beanInfo
        PropertyDescriptor[] pds=beanInfo.getPropertyDescriptors();//获取所有属性
        for (PropertyDescriptor pd :pds){//遍历获取属性
            String key =pd.getName();//将属性名 作为key
            Object value =pd.getReadMethod().invoke(o);//将属性的get方法的返回值 即属性值 作为value
            map.put(key,value);//放入map中
        }
        return map;
    }

    //将map转化为JavaBean对象
    public static Object map2bean(Map map,Class clz) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
          Object o =clz.newInstance();
          BeanInfo beanInfo=Introspector.getBeanInfo(clz,Object.class);//获取Javabean描述信息对象
          PropertyDescriptor[] pds =beanInfo.getPropertyDescriptors();//获取属性
          for (PropertyDescriptor pd :pds){
              String key =pd.getName();//属性名 则对应map的key
              Object value =map.get(key);//获取map的value值 即对应转化的属性值
              pd.getWriteMethod().invoke(o,value);// 将获取的value值 调用Set方法传值给属性值
          }

        return o;
    }
}
