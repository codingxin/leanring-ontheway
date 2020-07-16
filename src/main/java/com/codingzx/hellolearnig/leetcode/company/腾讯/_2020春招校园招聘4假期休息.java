package com.codingzx.hellolearnig.leetcode.company.腾讯;

import java.util.Scanner;

/**
 * @author created by zhangxin27695
 * @Classname _2020春招校园招聘3输出序列对
 * @Description 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息
 * 。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，
 * 小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，
 * 求小Q最少需要休息几天。
 * <p>
 * 输入描述:
 * 第一行一个整数  表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 * <p>
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 * <p>
 * 输入例子1:
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
 * @Date 2020-07-02 17:23
 */
public class _2020春招校园招聘4假期休息 {

    public static void main(String[] args) {
        int n = 4;
        int a[] = {1, 1, 0, 0};
        int b[] = {0, 1, 1, 0};
        int count = 0;
        boolean waitflag = false;
        boolean workflag = false;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (a[i] == 1 && b[i] == 0) {
                    workflag = true;
                    waitflag = false;
                } else if (a[i] == 0 && b[i] == 1) {
                    waitflag = true;
                    workflag = false;
                } else if (a[i] == 1 && b[i] == 1) {
                    workflag = true;
                    waitflag = false;
                }
            } else {
                if (b[i] == 1 && waitflag == false && workflag == true) {
                    count += 1;
                    waitflag = true;
                    workflag = false;
                    continue;
                }
                if (a[i] == 1 && workflag == false && waitflag == true) {
                    workflag = true;
                    waitflag = false;
                    continue;
                }
            }
        }
        System.out.println(count);
    }
}
