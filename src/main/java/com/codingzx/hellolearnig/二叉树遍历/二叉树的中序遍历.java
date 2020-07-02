package com.codingzx.hellolearnig.二叉树遍历;

import com.codingzx.hellolearnig.leetcode.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 二叉树的中序遍历
 * @Description
 * 用栈(Stack)的思路来处理问题。
 *
 * 中序遍历的顺序为左-根-右，具体算法为：
 *
 * 从根节点开始，先将根节点压入栈
 *
 * 然后再将其所有左子结点压入栈，取出栈顶节点，保存节点值
 *
 * 再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中
 * @Date 2020-07-02 13:50
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add((Integer) cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
