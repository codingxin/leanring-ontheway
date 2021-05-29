package com.codingzx.leetcode.剑指offer.第一周;


import com.codingzx.leetcode.leetcode.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codingzx
 * @description
 * @date 2021/5/29 9:44
 */
public class _07offer重建二叉树 {
    Map<Integer, Integer> treeIndexMap;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        treeIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            treeIndexMap.put(preorder[i], i);
        }
        return buildSonTree(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    /**
     * @param preorder   先序遍历数组
     * @param inorder    中序遍历数组
     * @param preleft    先序左树起始
     * @param preright   先序右树起始
     * @param orderleft  中序左树起始
     * @param orderright 中序右树起始
     * @return
     */
    public TreeNode buildSonTree(int[] preorder, int[] inorder, int preleft, int preright, int orderleft, int orderright) {
        if (preleft > preright) return null;
        // 根节点 val
        int root_value = preorder[preleft];
        // 根节点在先序数组中索引
        int order_root = treeIndexMap.get(root_value);
        // 中序遍历中求出左子树长度
        int order_left_length = order_root - orderleft;
        // 构造根节点
        TreeNode treeNode = new TreeNode(root_value);


        // 递归构造左子树
        treeNode.left = buildSonTree(preorder, inorder, preleft + 1, preleft + order_left_length, orderleft, order_root - 1);
        // 递归构造右子树
        treeNode.right = buildSonTree(preorder, inorder, preleft + order_left_length + 1, preright, order_root + 1, orderright);

        return treeNode;

    }


}

