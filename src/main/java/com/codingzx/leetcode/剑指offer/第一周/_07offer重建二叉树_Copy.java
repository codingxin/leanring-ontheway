package com.codingzx.leetcode.剑指offer.第一周;


import com.codingzx.leetcode.leetcode.entity.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codingzx
 * @description
 * @date 2021/5/29 9:44
 */
public class _07offer重建二叉树_Copy {

    public Map<Integer, Integer> map;

    /**
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
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
        // 先序遍历中 根节点
        int root_value = preorder[preleft];
        int order_root_index = map.get(root_value);
        int left_length = order_root_index - orderleft;
        TreeNode treeNode = new TreeNode(root_value);
        treeNode.left = buildSonTree(preorder, inorder, preleft + 1, preright + left_length, orderleft, order_root_index - 1);
        treeNode.right = buildSonTree(preorder, inorder, preleft + 1 + left_length, preright, order_root_index+1, orderright);
        return treeNode;
    }


}

