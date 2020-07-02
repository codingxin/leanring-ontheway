package com.codingzx.hellolearnig.leetcode.leetcode.entity;

/**
 * @author created by zhangxin27695
 * @Classname ListNode
 * @Description
 * @Date 2020-05-16 10:22
 */
public class TreeNode<T> {
    // 值
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T val;

    public TreeNode(T t) {
        this.val = t;
    }

}
