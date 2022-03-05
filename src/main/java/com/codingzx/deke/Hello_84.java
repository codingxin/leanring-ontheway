package com.codingzx.deke;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author codingzx
 * @description
 * @date 2022/2/26 13:29
 * 小组中每位都有一张卡片
 * 卡片是6位以内的正整数
 * 将卡片连起来可以组成多种数字
 * 计算组成的最大数字
 * <p>
 * 输入描述：
 * ","分割的多个正整数字符串
 * 不需要考虑非数字异常情况
 * 小组种最多25个人
 * <p>
 * 输出描述：
 * 最大数字字符串
 * <p>
 * 示例一
 * 输入
 * 22,221
 * 输出
 * 22221
 * <p>
 * 示例二
 * 输入
 * 4589,101,41425,9999
 * 输出
 * 9999458941425101
 */
public class Hello_84 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String nums = in.nextLine();
//        in.close();
        String nums = "4589,101,41425,9999";
        String nums2 = "22,221";
        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums.split(",")).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();
                if (length1 == length2) {
                    Integer num1 = Integer.parseInt(o1);
                    Integer num2 = Integer.parseInt(o2);
                    return num2.compareTo(num1);
                }
                if (length1 < length2) {
                    // 补全 num1 和 num2 一样的位数
                    int dif = length2 - length1;
                    Integer num1 = Integer.parseInt(o1) * 10^dif;
                    Integer num2 = Integer.parseInt(o2);
                    return num2.compareTo(num1);
                } else {
                    int dif = length1 - length2;
                    Integer num2 = Integer.parseInt(o2) * 10^dif;
                    Integer num1 = Integer.parseInt(o1);
                    return num2.compareTo(num1);
                }
            }
        }).forEach(builder::append);
        System.out.println(builder);

    }

}
