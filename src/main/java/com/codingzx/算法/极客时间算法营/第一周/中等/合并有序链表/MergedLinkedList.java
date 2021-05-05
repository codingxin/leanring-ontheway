package com.codingzx.算法.极客时间算法营.第一周.中等.合并有序链表;

import com.codingzx.leetcode.leetcode.entity.ListNode;

public class MergedLinkedList {
    /**
     * 迭代
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merger = new ListNode();
        ListNode curr = merger;
        while (l1 != null && l2 != null) {
            if ((Integer) l1.val < (Integer) l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; // 移动指针到下一个
        }
        curr.next = l1 != null ? l1 : l2;
        return merger.next;
    }




    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 1.终止条件  ： 任意链表已经移动到最后为空
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        // 2.找返回值    返回最小的子节点
        // 3.本级递归应该做什么 找出最小的并返回
        if ((Integer) l1.val < (Integer) l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);  // 每次接在最小的值后面
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }


    }
}
