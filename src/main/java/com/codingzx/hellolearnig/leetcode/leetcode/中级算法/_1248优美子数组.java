package com.codingzx.hellolearnig.leetcode.leetcode.中级算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author created by zhangxin27695
 * @Classname _1248优美子数组
 * @Description 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「_1248优美子数组」。
 * <p>  TODO
 * 请返回这个数组中「_1248优美子数组」的数目。
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * @Date 2019-11-08 9:54
 */
public class _1248优美子数组 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int i = 0;  //滑动窗口起始
        int j = 0;  //滑动窗口结束
        int a=k;    //滑动窗口尺寸
        int cishu = 0; //需要循环判断的次数
        for (j = i+a-1; j <= nums.length - 1;) {
            //每次传入一个滑动窗口 ，如果滑动窗口里面奇数正好是K ，次数+1
            if (number(nums, i, j) == k) {
                count++;
            }
            if (j == nums.length-1) {
               i=0;
               a+=1;
               j=i+a-1;
               continue;
            }
            if(a==nums.length){break;}
            i++;j++;
        }
        return count;
    }

    public static int number(int[] arr, int i, int j) {
        int qishu = 0;
        int k = i;
        for (; k <= j; k++) {
            if (arr[k] % 2 != 0) qishu++;
        }
        return qishu;
    }

    public static void main(String[] args) {
        int a[] = {1, 1, 2, 1, 1};
        int a2[] = {2, 4, 6};
        int a3[] = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
//        numberOfSubarrays(a, 3);
        System.out.println("这个数组" + numberOfSubarrays(a3, 2));
    }
    public int numberOfSubarrays2(int[] nums, int k) {
        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        for(int i = 0; i < len; i ++) {
            // if it is odd
            if((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        // left border
        arr[0] = -1;
        // right border
        arr[feed + 1] = len;
        for(int i = 1; i + k < feed + 2; i ++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }

    public int numberOfSubarrays3(int[] nums, int k) {
        /*使用前缀和的原因也是子数组要连续
        使用前缀和（将奇数变为1，偶数为0）
        sum[i] = sum[i-1]+num;
        如果存在sum[i]-k>0,那就说明肯定存在一段数组的和等于k
        假设从（j,n]的和为k ,那么当我们找到sum[n]的时候，就会存在sum[n]-k=sum[j],
        此时times就加上sum[j]的个数，因为这里j可能不是一个值
        */
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int temp = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2!=0)
            {
                sum += 1;
            }
            if(sum>=k)
            {
                //和为j
                int j = sum-k;
                //找和为j的个数
                temp+=map.get(j);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return temp;
    }



}
