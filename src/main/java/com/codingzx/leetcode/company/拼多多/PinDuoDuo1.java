package com.codingzx.leetcode.company.拼多多;

/**
 * @author created by zhangxin27695
 * @Classname PinDuoDuo1
 * @Description 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * @Date 2019-11-18 19:18 TODO
 * 1.两个负数与与一个正数相乘
 *
 * 2.全为最大正数相乘得到最大值
 *
 * 思路： 这里要注意的是当数字足够大的时候，我们要使用long long形式的类型，用来记录那个最大值
 * 最大值共有四种情况：
 * 三个正数：数字本身越大则乘积越大
 * 两个负数一个正数：负负得正，所以两个负数最小，之积最大
 * 两个正数一个负数：
 * 这种情况，如果只有【正，正，负】【正，正，负，负】【正，正，负，负，负】【正，正，正，负，负】
 * 所有的情况都包含在第一种和第二种情况里，所以这种情况可以去掉。
 * 三个负数：
 * ​​​​​​​这种情况只有【负，负，负】这一种情况，这种情况和第一种相重合，所以也可以去掉
 * ————————————————
 */
import java.util.Arrays;
import java.util.Scanner;

public class PinDuoDuo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextLong();
        }
        getLargestMul(array,n);
    }
    /**
     * 思路:定义五个数:一个最大,一个次大,一个第三大,一个最小,一个次小
     * 只要找出这五个数,问题就解决了
     *
     * 思考：三个数所以情况中，为正数的情况：正正正，正负负，因此只要比较两者那个大就行了。
     *
     * 1. 排列最大正数m1,m2，m3,最小负数x1,x2;
     *
     * 2. 比较m1*m2*m3和m1*x1*x2，输出。
     * @param
     * @return
     */
    static void getLargestMul(long[] num, int len){
        long max1=0,max2=0,max3=0, min1=0,min2=0;
        for (int i = 0; i <len ; i++) {
            if(num[i]!=0){
                if(num[i]>max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = num[i];
                }else if(num[i]>max2){
                    max3 = max2;
                    max2 = num[i];
                }else if(num[i]>max3){
                    max3 = num[i];
                }else if(num[i]<min1 ){
                    min2 = min1;
                    min1 = num[i];
                }else if(num[i]>min1 && num[i]<min2){
                    min2 = num[i];
                }
            }else continue;

        }
        long max = Math.max(max1*max2*max3,max1*min1*min2);
        System.out.println(max);
    }
}
