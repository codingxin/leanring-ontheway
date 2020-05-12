package com.codingzx.hellolearnig.leetcode.leetcode;

import java.math.BigDecimal;

/**
 * @author created by zhangxin27695
 * @Classname he
 * @Description
 * @Date 2019-11-09 10:24
 */
public class he {

    public static void  main(String[] args){
        int a='2';
        BigDecimal num= new BigDecimal("11100");
        if(num.compareTo(BigDecimal.ZERO)==-1){
            num=num.negate();
        }
        System.out.println(num);
        System.out.println(a);
    }
}
