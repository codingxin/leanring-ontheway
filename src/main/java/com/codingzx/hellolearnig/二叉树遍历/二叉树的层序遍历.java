package com.codingzx.hellolearnig.二叉树遍历;

import com.codingzx.hellolearnig.leetcode.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author created by zhangxin27695
 * @Classname 二叉树的层序遍历
 * @Description 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 该问题需要用到队列。
 *
 * 建立一个queue
 *
 * 先把根节点放进去，这时候找根节点的左右两个子节点
 *
 * 去掉根节点，此时queue里的元素就是下一层的所有节点
 *
 * 用for循环遍历，将结果存到一个一维向量里
 *
 * 遍历完之后再把这个一维向量存到二维向量里
 *
 * 以此类推，可以完成层序遍历
 * @Date 2020-07-02 13:56
 */
public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add((Integer) node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
