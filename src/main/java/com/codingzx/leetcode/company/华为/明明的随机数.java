package com.codingzx.leetcode.company.华为;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author created by zhangxin27695
 * @Classname 明明的随机数
 * @Description 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * ————————————————
 * 版权声明：本文为CSDN博主「beautiful_huang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/beautiful_huang/article/details/105009791
 * @Date 2020-07-16 16:32
 */
public class 明明的随机数 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int number = input.nextInt();
            Set<Integer> intset = new TreeSet<>();
            for (int i = 0; i < number; i++) {
                intset.add(input.nextInt());
            }
            for(Integer i:intset){
                System.out.println(i);
            }
            intset.stream().forEach(e->{
                System.out.println(e);
            });
        }
    }
}
