package com.codingzx.deke;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 双十一众多商品进行打折销售
 小明想购买自己心仪的一些物品
 但由于购买资金限制
 所以他决定从众多心仪商品中购买三件
 而且想尽可能得花完资金
 现在请你设计一个程序 计算小明尽可能花费的最大资金数

 输入描述：
   输入第一行为一维整型数组m
   数组长度小于100
   数组元素记录单个商品的价格
   单个商品加个小于1000

   输入第二行为购买资金的额度r
   r<100000

 输出描述：
    输出为满足上述条件的最大花费额度

  注意：如果不存在满足上述条件的商品请返回-1

 示例：
    输入
     23,26,36,27
     78
    输出
     76
    说明：
     金额23、26、27得到76而且最接近且小于输入金额78

  示例：
      输入
      23,30,40
      26
      输出
       -1
      说明
      因为输入的商品无法满足3件之和小于26
      故返回-1

  输入格式正确无需考虑输入错误情况

  */
public class Hello_77 {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());
        int n = scanner.nextInt();
        scanner.close();

        // 找出最大的三件之和
        int max = -1;
        if (list.size() < 3) {
            System.out.println(max);
            return;
        }
        int result = list.get(0) + list.get(1) + list.get(2);
        max = n > result ? result : max;
        System.out.println(max);

    }
}
