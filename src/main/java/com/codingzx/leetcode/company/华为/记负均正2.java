package com.codingzx.leetcode.company.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author created by zhangxin27695
 * @Classname 记负均正2
 * @Description 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * @Date 2020-07-16 19:51
 */
public class 记负均正2 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str[] = buffer.readLine().split(" ");
        int negatecount = 0;
        int positivecount = 0;
        int avage = 0;
        for (int i = 0; i < str.length; i++) {
            int tmp = Integer.parseInt(str[i]);
            if (tmp < 0) {
                negatecount += 1;
            } else {
                avage += tmp;
                positivecount += 1;
            }
        }
        System.out.println(negatecount);
        System.out.println(Math.round(avage * 10 / positivecount) / 10.0);

    }


}
