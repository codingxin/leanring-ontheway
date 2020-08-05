package com.codingzx.leetcode.leetcode.初级算法.Array;

/**
 * @author created by zhangxin27695
 * @Classname 旋转数组
 * @Description
 * @Date 2019-11-09 11:19
 */
public class 旋转数组 {
    /* 
        * 经典方法，三次倒置数组中对应位置的元素; 
        * 简单说一下原理：数组元素右移K个位置的结果是，原来在 
        * 后面的K个元素跑到了数组前面，原来在前面的LENGTH-K 
        * 个元素，跑到了数组的后面，并且前后两部分元素各自的顺序和 
        * 移动前一致，而倒置整个数组元素就是让后面K个元素跑到前面去， 
        * 让前面LENGTH-K个元素跑到后面去，但是倒置之后前后两部分 
        * 元素的顺序跟移动之前不一样了，倒置了，所以要把两部分的元素 
        * 倒置回来 
        * @PARAM ARRAY 
        * @PARAM K 
        */
    public static void rotate(int[] nums, int k) {
        k = (nums.length + (k % nums.length)) % nums.length; // 保证k为正
        int tmp;
        /**
         * 7, 1, 5, 3, 6, 4
         * 4  6  3  5  1  7
         * 倒置所有元素
         */
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            // 交换 num[i]和num[j]
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        /**
         * 倒置前K个元素
         */
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            // 交换 num[i]和num[j]
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        /**
         * 倒置 后面 k 到 最后的元素
         */
        for (int i = k, j = nums.length - 1; i < j; i++, j--) {
            // 交换 num[i]和num[j]
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        while (k > 0) {  //循环k次， 从倒数length-1-k 到 lenth-1 共 k个数 需要循环变换
            int t = 0;
            t = nums[length - 1];  // 保存最后一位 因为要被后移的顶替掉
            for (int j = length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j]; //循环后移 1位
            }
            nums[0] = t;
            k--;
        }
    }

    public static void rotate3(int[] nums, int k) {
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};
        //rotate(a, 3);
        rotate3(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
