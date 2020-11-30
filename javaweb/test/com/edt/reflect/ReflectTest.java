package com.edt.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//字节码对象获取
public class ReflectTest {

    @Test
    public void testReflect() throws Exception {
        //权限名方式获取
        Class clz = Class.forName("com.edt.reflect.Person");
        System.out.println(clz);
        //通过类型获取
        Class clz2 = Person.class;
        System.out.println(clz2);
        //通过对象获取
        Person p = new Person();
        Class clz3 = p.getClass();
        System.out.println(clz3);
    }

    @Test
    public void testGetConstructor() throws NoSuchMethodException {
        //获取字节码对象
        Class<Person> clz = Person.class;
        //获取构造器
        Constructor<?>[] cons = clz.getConstructors(); //获取所有public 修饰的构造器
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
        System.out.println("===================");
        Constructor<?>[] conss = clz.getDeclaredConstructors(); //获取所有构造器
        for (Constructor con : conss) {
            System.out.println(con);
        }
        System.out.println("=========");
        Constructor con = clz.getConstructor(String.class, int.class);//获取指定public构造器
        System.out.println(con);
        System.out.println("====");
        Constructor con2 = clz.getDeclaredConstructor(String.class, int.class);//获取指定构造器,可以是private
        System.out.println(con2);

    }

    @Test
    public void testNewObject() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clz = Class.forName("com.edt.reflect.Person");
        Constructor con = clz.getConstructor(); //获取无参构造器
        Object o = con.newInstance(); //获取无参对象
        System.out.println(o);
        System.out.println("=============");
        Constructor con2 = clz.getConstructor(String.class, int.class); //获取public构造器
        Object o2 = con2.newInstance("小豪", 22);
        System.out.println(o2);
        System.out.println("========");
        Constructor con3 = clz.getDeclaredConstructor(String.class); //获取私有构造器
        con3.setAccessible(true); //让此private 构造器能够被访问
        Object o3 = con3.newInstance("小豪");
        System.out.println(o3);
        System.out.println("========");
        //快捷方式
        Object oo = clz.newInstance();
        System.out.println(oo);
    }

    @Test
    public void testGetMethod() throws ClassNotFoundException, NoSuchMethodException {
        Class clz = Class.forName("com.edt.reflect.Person");
        //获取所有public 方法,包括父类
        Method[] ms = clz.getMethods();

        for (Method m : ms) {
            System.out.println(m);
        }
        System.out.println("========");
        //获取所有方法,包括 private 不包括父类的
     Method[] ms2 =clz.getDeclaredMethods();
        for (Method method : ms2) {
            System.out.println(method);
        }
        System.out.println("===========");

        //获取指定参数的public 的方法 包括父类的
        Method m1 =clz.getMethod("doWork", String.class);
        System.out.println(m1);
        System.out.println("============");
        //获取指定参数的private 方法,也可以public,不包括父类
        Method m2 =clz.getDeclaredMethod("doWork");
        System.out.println(m2);
    }

    @Test
    public void testInvoke() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //通过反射去调用方法
      Class clz = Class.forName("com.edt.reflect.Person");
      Object obj =clz.newInstance();
      //调用公共的带参数的方法
        Method doWork =clz.getMethod("doWork", String.class);
        doWork.invoke(obj,"小豪");
        //调用公共无参的方法
        Method eat =clz.getMethod("eat");
        eat.invoke(obj);
        //调用静态方法
        Method sleep =clz.getMethod("sleep", int.class);
        sleep.invoke(null,3);
        //调用私有的方法
        Method doo =clz.getDeclaredMethod("doo");
        doo.setAccessible(true);//使私有方法可以被访问
        doo.invoke(obj);
    }
    //测试反射获取字段 了解一下即可
    @Test
    public  void  testField() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clz = Class.forName("com.edt.reflect.Person");
        Object obj =clz.newInstance();
        //获取所有公共的字段
        Field[] fs =clz.getFields();
        for (Field f : fs) {
            System.out.println(f);
        }
        System.out.println("======");
        //获取所有字段 包括private
        Field[] fs2=clz.getDeclaredFields();
        for (Field field : fs2) {
            System.out.println(field);
        }
        System.out.println("=======");
        //获取单个字段
        Field f =clz.getDeclaredField("age");
        f.setAccessible(true);//设置私有可以被访问
        f.set(obj,22);//设置字段数据
        Object value=f.get(obj); //获取字段数据
        System.out.println(value);
    }
}
