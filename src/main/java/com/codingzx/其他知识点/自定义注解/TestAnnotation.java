package com.codingzx.其他知识点.自定义注解;

/**
 * @author codingzx
 * @description
 * @date 2020/7/15 21:46
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyClassAndMethodAnnotation;
import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyClassAndMethodAnnotation.EnumType;
import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyClassAnnotation;
import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyConstructorAnnotation;
import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyFieldAnnotation;
import com.codingzx.其他知识点.自定义注解.MyAnnotation.MyMethodAnnotation;

@MyClassAnnotation(desc = "这是类注解", uri = "com.sgl.annotation")
@MyClassAndMethodAnnotation(classType = EnumType.util)
public class TestAnnotation {
    @MyFieldAnnotation(desc = "这是字段注解", uri = "com.sgl.annotation#id")
    private String id;

    @MyConstructorAnnotation(desc = "这是构造方法注解", uri = "com.sgl.annotation#constructor")
    public TestAnnotation() {
    }

    public String getId() {
        return id;
    }

    @MyMethodAnnotation(desc = "这是方法注解1", uri = "com.sgl.annotation#setId")
    public void setId(String id) {
        this.id = id;
    }

    @MyMethodAnnotation(desc = "这是方法注解2 sayHello", uri = "com.sgl.annotation#sayHello")
    public void sayHello(String name) {
        if (name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "\t:say hello world");
        }
    }

    public static void main(String[] args) throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;

        // 获取类注解
        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);
        System.out.println(myClassAnnotation.desc() + "+" + myClassAnnotation.uri());

        // 获得构造方法注解
        Constructor<TestAnnotation> constructors = clazz.getConstructor(new Class[] {});// 先获得构造方法对象
        MyConstructorAnnotation myConstructorAnnotation = constructors.getAnnotation(MyConstructorAnnotation.class);// 拿到构造方法上面的注解实例
        System.out.println(myConstructorAnnotation.desc() + "+" + myConstructorAnnotation.uri());

        // 获得方法注解
        Method method = clazz.getMethod("setId", new Class[] { String.class });// 获得方法对象
        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
        System.out.println(myMethodAnnotation.desc() + "+" + myMethodAnnotation.uri());

        // 获得字段注解
        Field field = clazz.getDeclaredField("id");// 暴力获取private修饰的成员变量
        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
        System.out.println(myFieldAnnotation.desc() + "+" + myFieldAnnotation.uri());
    }
}
