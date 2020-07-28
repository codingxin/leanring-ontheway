package com.codingzx.leetcode.leetcode.初级算法.Array;

/**
 * @author created by zhangxin27695
 * @Classname 加一
 * @Description  TODO
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 输入 【9】
 * 输出  【1，0】
 * @Date 2019-11-12 11:13
 */
public class 加一 {
    public static int[] plusOne(int[] digits) {
        /**
         * 最高位进位
         * 若最高位进位，那么比他低的位数字都为9，且加1后都为0，需要初始化一个长度为(lenght+1)的新数组
         * ，0位置为1代表进位。
         *
         * 最高位不进位
         * 若最高位不进位，那么不需要产生新数组，后续数字由更低位计算而来。
         */
        int carry = 1;
        for(int i=digits.length - 1; i >= 0; i--){
            if(carry==0) {
                return digits;
            }
            int tmp=digits[i]+1;
            carry=tmp/10;
            digits[i]=tmp%10;
        }
        if(carry ==1){
            int[] a=new int[digits.length+1];
            a[0]=1;
            return  a;
        }
         return digits;
    }
    public static void main(String[] args) {
        int a2[] = {1, 2, 2, 1};
        int a3[] = {9,9,9};
        plusOne(a3);
        for (int i = 0; i < a3.length; i++) {
            System.out.println(plusOne(a3).toString());
        }
    }
}
