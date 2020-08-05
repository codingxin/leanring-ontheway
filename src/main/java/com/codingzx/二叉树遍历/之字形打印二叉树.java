package com.codingzx.二叉树遍历;

import com.codingzx.leetcode.leetcode.entity.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 之字形打印二叉树
 * @Description 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Date 2020-08-05 11:29
 */
public class 之字形打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //二叉树层次标记
        int level = 1;
        //保存二叉树当前层次的节点信息
        Stack<TreeNode> concurrent = new Stack<>();
        concurrent.push(pRoot);
        while (!concurrent.isEmpty()) {

            Stack<TreeNode> to = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();

            if (level % 2 == 0) {
                // 双数层
                while (!concurrent.isEmpty()) {
                    TreeNode node = concurrent.pop();
                    if (node != null) {
                        list.add((Integer) node.val);
                        System.out.println(node.val + " ");
                        if (node.right != null) {
                            to.push(node.right);
                        }
                        if (node.left != null) {
                            to.push(node.left);
                        }
                    }
                }
            } else {
                // 单数层
                while (!concurrent.isEmpty()) {
                    TreeNode node = concurrent.pop();
                    if (node != null) {
                        list.add((Integer) node.val);
                        System.out.println(node.val + " ");
                        if (node.left != null) {
                            to.push(node.left);
                        }
                        if (node.right != null) {
                            to.push(node.right);
                        }
                    }
                }
            }
            result.add(list);
            concurrent = to;
            level++;
            System.out.println();
        }
        return result;

    }
}


