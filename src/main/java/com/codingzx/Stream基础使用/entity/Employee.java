package com.codingzx.Stream基础使用.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @author created by zhangxin27695
 * @Classname Employee
 * @Description
 * @Date 2020-04-08 11:35
 */
@Data
@AllArgsConstructor
public class Employee {
    public static Predicate<Employee> ageGreaterThan70 = x -> x.getAge() >70;
    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");

    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName;
    private String lastName;
}
