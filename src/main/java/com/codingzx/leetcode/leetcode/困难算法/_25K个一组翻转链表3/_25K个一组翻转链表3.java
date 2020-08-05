package com.codingzx.leetcode.leetcode.困难算法._25K个一组翻转链表3;

import com.codingzx.leetcode.leetcode.entity.ListNode;

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
 * 来源：力扣（LeetCode）   递归解法
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-16 10:21
 * K个一组翻转链表，具体到每一段，其实就是一个简单的翻转链表的问题
 * 所以我们只需要将每一个段翻转的头结点返回，拼接到前一段的翻转后的尾结点即可
 */
public class _25K个一组翻转链表3 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int i = k;
        // 先遍历找到下一段的开头
        while (i > 0 && cur != null) {
            cur = cur.next;
            i--;
        }
        // 如果没有到k个，那么原顺序返回
        if (i > 0) return head;
        // 关键在于这个位置，返回值拼接到当前段翻转后的尾结点即可
        // 而尾结点就是原链表在当前段的头
        ListNode pre = reverseKGroup(cur, k);
        cur = head;
        i = k;
        while (i > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            i--;
        }
        return pre;
    }
}
