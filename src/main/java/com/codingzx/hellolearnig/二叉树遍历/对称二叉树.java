package com.codingzx.hellolearnig.二叉树遍历;

import com.codingzx.hellolearnig.leetcode.leetcode.entity.TreeNode;

/**
 * @author created by zhangxin27695
 * @Classname 对称二叉树
 * @Description 用递归做比较简单：一棵树是对称的等价于它的左子树和右子树两棵树是对称的，问题就转变为判断两棵树是否对称。
 * @Date 2020-07-02 13:58
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        //把问题变成判断两棵树是否是对称的
        return isSym(root.left, root.right);
    }
    //判断的是根节点为r1和r2的两棵树是否是对称的
    public boolean isSym(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        //这两棵树是对称需要满足的条件：
        //1.俩根节点相等。 2.树1的左子树和树2的右子树，树2的左子树和树1的右子树都得是对称的
        return r1.val == r2.val && isSym(r1.left, r2.right)
                && isSym(r1.right, r2.left);
    }
}
