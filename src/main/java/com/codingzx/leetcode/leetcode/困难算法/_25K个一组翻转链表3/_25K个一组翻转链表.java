package com.codingzx.leetcode.leetcode.困难算法._25K个一组翻转链表3;

import com.codingzx.leetcode.leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _25K个一组翻转链表
 * @Description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-16 10:21
 * * 给你这个链表：1->2->3->4->5
 * * <p>
 * * 当 k = 2 时，应当返回: 2->1->4->3->5
 * * <p>
 * * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class _25K个一组翻转链表 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode first = new ListNode(0);  // 保存返回数据
        ListNode p = first;
        while (true) {
            int count = 0;
            // 当前元素 tmp
            ListNode tmp = head;
            // 将前K个元素取出来放进栈中
            while (tmp != null && count < k) {
                stack.push(tmp);
                count++;
                // tmp不断移动，直到一个循环结束或者当前元素为空
                tmp = tmp.next;
            }
            //当最后一个循环的时候
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return first.next;
    }
}
