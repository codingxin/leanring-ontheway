package com.codingzx.算法.极客时间算法营.递归;

import com.codingzx.leetcode.leetcode.entity.ListNode;

/**
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 这个题不是简单的数字交换，而是节点之间的交换。
 * <p>
 * 1.终止条件： 链表只剩一个节点或者节点为空
 * 2.返回值： 返回交换后的链表
 * 3.本级递归完成的事：由于只考虑本级递归，所以这个链表在我们眼里
 * 其实也就三个节点：head、head.next、已处理完的链表部分。而本级递归的任务也就是交换这3个节点中的前两个节点，就很easy了。
 */
public class _24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 一共三个节点 head ,newHead,swap(newHead,next)
        // 交换前两个节点
        // 用 head 表示原始链表的头节点，新的链表的第二个节点，
        // 用 newHead 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next。
        // 令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。
        // 然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
        ListNode newHead = head.next;   // 新节点首节点
        head.next = swapPairs(newHead.next);  // 剩余节点
        newHead.next = head;    // 交换   // 老节点
        // newhead ->> head ->> head.next


        return newHead;
//        时间复杂度：O(n)，其中 nn 是链表的节点数量。需要对每个节点进行更新指针的操作。
//        空间复杂度：O(n)，其中 nn 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间


    }

}
