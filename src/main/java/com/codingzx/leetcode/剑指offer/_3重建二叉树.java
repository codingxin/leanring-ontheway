package com.codingzx.leetcode.剑指offer;


import com.codingzx.leetcode.leetcode.entity.TreeNode;

import java.util.Arrays;

/**
 * @author created by zhangxin27695
 * @Classname _3重建二叉树
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Date 2020-05-29 10:46
 */
public class _3重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        // 定义根节点
        int rootVal = pre[0];
        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }
        // 在中序遍历中找到根节点所在下标
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),
                Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length));

        return root;

    }
}
