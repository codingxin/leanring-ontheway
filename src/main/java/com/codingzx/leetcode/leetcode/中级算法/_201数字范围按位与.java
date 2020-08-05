package com.codingzx.leetcode.leetcode.中级算法;

/**
 * @author created by zhangxin27695
 * @Classname _201数字范围按位与
 * @Description [m,n]区间里元素的全都按位与就等同于m和n表示成二进制以后的公共前缀对应的数值
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 101
 * 100
 * 111
 * 100
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0

 * @Date 2019-11-29 10:51
 */
public class _201数字范围按位与 {
    public static void main(String[] args) {
        int m = 57;
        int n = 59;
        System.out.println("这个字符串" + rangeBitwiseAnd2(m, n));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m==0 || m==n) {
            return m;
        }
        int resultM = (int)Math.floor(Math.log(m)/Math.log(2));
        int resultN = (int)Math.floor(Math.log(n)/Math.log(2));

        if (resultM == resultN) {
            int result = (int)Math.pow(2, resultM);
            return result + rangeBitwiseAnd(m-result, n-result);
        }else {
            return 0;
        }
    }

    public static int rangeBitwiseAnd2(int m, int n) {
      int count=0;
      while(m!=n){
          m>>=1;
          n>>=1;
          count++;
      }
      return n<<count;
    }
}
