package com.codingzx.Stream基础使用.testclass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author created by zhangxin27695
 * @Classname Stream并发
 * @Description
 * @Date 2020-04-09 14:30
 */
public class Stream并发 {

    public static void main(String[] args) {
        //limt方法传入一个整数n，用于截取管道中的前n个元素。经过管道处理之后的数据是：[Monkey, Lion]。
        List<String> limitN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .limit(2)
                .collect(Collectors.toList());
        //skip方法与limit方法的使用相反，用于跳过前n个元素，截取从n到末尾的元素。经过管道处理之后的数据是： [Giraffe, Lemur]
        List<String> skipN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .skip(2)
                .collect(Collectors.toList());

        //Distinct元素去重
        List<String> uniqueAnimals = Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .distinct()
                .collect(Collectors.toList());

        //Sorted排序
        List<String> alphabeticOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .sorted()
                .collect(Collectors.toList());


        //串行、并行与顺序

        //1.parallel()函数表示对管道中的元素进行并行处理，而不是串行处理。但是这样就有可能导致管道流中后面的元素先处理，前面的元素后处理，也就是元素的顺序无法保证。
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .parallel()
                .forEach(System.out::println);
        //如果数据量比较小的情况下，不太能观察到，数据量大的话，就能观察到数据顺序是无法保证的。



    }

}
