package com.codingzx.leetcode.leetcode.entity;

/**
 * @author created by zhangxin27695
 * @Classname ListNode
 * @Description
 * @Date 2020-05-16 10:22
 */
public class ListNode<T> {
    // 值
    public T val;
    // 模拟指针
    public ListNode next;

    public ListNode(T x) {
        val = x;
    }
}
