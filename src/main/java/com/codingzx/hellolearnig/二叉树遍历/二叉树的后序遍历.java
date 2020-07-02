package com.codingzx.hellolearnig.二叉树遍历;

import com.codingzx.hellolearnig.leetcode.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 二叉树的后序遍历
 * @Description
 * 用栈(Stack)的思路来处理问题。
 *
 * 后序遍历的顺序为左-右-根，具体算法为：
 *
 * 先将根结点压入栈，然后定义一个辅助结点head
 *
 * while循环的条件是栈不为空
 *
 * 在循环中，首先将栈顶结点t取出来
 *
 * 如果栈顶结点没有左右子结点，或者其左子结点是head，或者其右子结点是head的情况下。我们将栈顶结点值加入结果res中，并将栈顶元素移出栈，然后将head指向栈顶元素
 *
 * 否则的话就看如果右子结点不为空，将其加入栈
 *
 * 再看左子结点不为空的话，就加入栈
 * @Date 2020-07-02 13:52
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0, (Integer) node.val);                        //逆序添加结点值
        }
        return res;
    }
}
