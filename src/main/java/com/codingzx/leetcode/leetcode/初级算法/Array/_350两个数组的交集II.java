package com.codingzx.leetcode.leetcode.初级算法.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author created by zhangxin27695
 * @Classname _350两个数组的交集II
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @Date 2019-11-12 9:39
 */
public class _350两个数组的交集II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmplist = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] > nums1[i]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                tmplist.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[tmplist.size()];
        for (Integer list : tmplist) {
            result[k++] = list;
        }
        return result;
    }

    public static void main(String[] args) {
        int a2[] = {1, 2, 2, 1};
        int a3[] = {2, 2};
        int a[] = intersect(a2, a3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
