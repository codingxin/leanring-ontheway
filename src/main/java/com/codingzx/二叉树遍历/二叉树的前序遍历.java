package com.codingzx.二叉树遍历;


import com.codingzx.leetcode.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 二叉树的前序遍历
 * @Description
 * 把根节点push到栈中
 *
 * 循环检测栈是否为空，若不空，则取出栈顶元素，保存其值
 *
 * 看其右子节点是否存在，若存在则push到栈中
 *
 * 看其左子节点，若存在，则push到栈中。
 * @Date 2020-07-02 13:35
 */
public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        //第一步是将根节点压入栈中
        stack.push(root);
        //当栈不为空时，出栈的元素插入list尾部。
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add((Integer) root.val);
            if(root.right != null) stack.push(root.right);  // 先压入根
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }
}
