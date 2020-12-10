package com.codingzx.极客时间算法营.递归;

import com.codingzx.leetcode.leetcode.entity.TreeNode;

public class 求二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
/**
 * 1. 终止条件 二叉树为空，树的深度为空结束
 * 2. 找返回值 返回值应该是当前树的最大深度
 * 3. 本地递归应该做什么 在左右子树中最大深度,+1 即为以root为根的最大深度
 */
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}