package com.codingzx.hellolearnig.leetcode.leetcode.初级算法.Array;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/9/7
 * @备注 地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 * ------返回移除后数组的新长度。----------
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 输入：nums = [1,1,2],   输出：2
 * nums = [0,0,1,1,1,2,2,3,3,4], 输出 5  数组 0 1  2 3 4 2 2 3 3 4
 *
 * 思路
 *    1.每次比较前后两个元素
 *    2.把不同的元素赋值给 a[pos++],最好返回pos
 */
public class 从排序数组中删除重复项 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        /*for (int j : nums) {
            System.out.println(j);
        }*/
        System.out.println("第一种方法：" + removeDuplicates1(nums));
        System.out.println("第二种方法：" + removeDuplicates2(nums2));
        System.out.println("第三种方法：" + removeDuplicates3(nums3));

    }

    public static int removeDuplicates1(int[] array) {
        //数组统一用字母表示
        //判断空和长度为0的情况
        if (array == null || array.length == 0) return 0;
        int pre = 0, cur = 1;
        int pos = 1; //最后返回长度
        //cur=1，pre=0 有序数组
        //a[0]=1,a[1]=1,a[2]=2
        while (cur < array.length) {  //判断条件 cur从0到length-1  1-length
            //cur：当前数组元素，pre 前一数组元素 a[pre] a[cur]
            if (array[cur] != array[pre]) {
                //当当前元素和下一元素不同时，将当前元素赋值给下一元素
                array[pos] = array[cur];
                pos++;
            }
            //每次比较相邻两个元素，发现不同就加一
            pre++;  // 0 1
            cur++;  // 1 2
        }
        return pos;
    }

    public static int removeDuplicates2(int[] array) {
        //数组统一用字母表示
        //判断空和长度为0的情况
        if (array == null || array.length == 0) return 0;
        int i = 0, j = 1;
        int pos = 1;  //记录不重复数字的个数
        for (; i < array.length-1; i++,j++) {
            if (array[i] != array[j]) {
                array[pos] = array[j];
                pos++;
            }
        }
        return pos;
    }
    public static int removeDuplicates3(int[] array) {
        //数组统一用字母表示
        //判断空和长度为0的情况
        if (array == null || array.length == 0) return 0;
        Set<Integer> arrayset=new HashSet<>();
        int i=0;
        for( i=0;i<array.length;i++)
        {
            arrayset.add(array[i]);
        }
        int j=0;
        for(Integer set:arrayset){
            array[j++]=set;
        }
        return arrayset.size();
    }



}



