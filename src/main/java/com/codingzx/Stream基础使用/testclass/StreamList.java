package com.codingzx.Stream基础使用.testclass;

import java.util.LinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author created by zhangxin27695
 * @Classname StreamList
 * @Description
 * @Date 2020-06-01 13:54
 */
public class StreamList {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur","Lemur");
        alpha.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);

        alpha.stream().map(e -> {
            System.out.print(e.length());
            return 1;
        }).collect(Collectors.toList());

        alpha.stream().peek(e -> {
            System.out.print("peek方法（无返回值的循环）" + e.length());
        }).collect(Collectors.toList());
        System.out.println("/n");
        alpha.stream().flatMap(e -> Arrays.stream(e.split("")))
                .collect(Collectors.toList()).forEach(System.out::println);

        alpha.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);


        alpha.stream().collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);
        System.out.println("--------");
        alpha.stream().collect(Collectors.toCollection(CopyOnWriteArrayList::new)).forEach(System.out::println);
        System.out.println("--------");
        alpha.stream().collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);



    }
}
