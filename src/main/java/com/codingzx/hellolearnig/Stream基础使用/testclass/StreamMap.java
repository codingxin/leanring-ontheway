package com.codingzx.hellolearnig.Stream基础使用.testclass;

import com.codingzx.hellolearnig.Stream基础使用.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author created by zhangxin27695
 * @Classname StreamFilterPredicate
 * @Description
 * @Date 2020-04-08 11:37
 */
public class StreamMap {

    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        //不使用Stream管道流
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alphaUpper); //[MONKEY, LION, GIRAFFE, LEMUR]

        // 使用Stream管道流
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        //上面使用了方法引用，和下面的lambda表达式语法效果是一样的
        List<String> collect2 = alpha.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());


        //转换数据类型
        List<Integer> lengths = alpha.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengths); //[6, 4, 7, 5]
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .mapToInt(String::length)
                .forEach(System.out::println);
        //6，4，7，5 打印长度


        /*
        将每一个Employee的年龄增加一岁
         将性别中的“M”换成“male”，F换成Female。
         */
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        List<Employee> maped = employees.stream()
                .map(e -> {
                    e.setAge(e.getAge() + 1);
                    e.setGender(e.getGender().equals("M") ? "male" : "female");
                    return e;
                }).collect(Collectors.toList());
        //peek函数是一种特殊的map函数，当函数没有返回值或者参数就是返回值的时候可以使用peek函数。
        List<Employee> maped2 = employees.stream()
                .peek(e -> {
                    e.setAge(e.getAge() + 1);
                    e.setGender(e.getGender().equals("M") ? "male" : "female");
                }).collect(Collectors.toList());


        /**
         * 对管道中的管道进行操作，如对将“hello”，“world”两个字符串组成的集合，元素的每一个字母打印出来。
         * 采用flatMap
         */
        List<String> words = Arrays.asList("hello", "word");
        words.stream()
                .flatMap(e -> Arrays.stream(e.split("")))
                .forEach(System.out::println);
    }
}
