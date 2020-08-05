package com.codingzx.leetcode.leetcode.中级算法;

import com.codingzx.leetcode.leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname _2两数相加顺序
 * @Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * (5 -> 6 -> 4)
 * (7 -> 0 -> 7+1)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020-05-16 14:16
 * <p>
 * 修改为逆序输出
 * (2 →4 → 3)+ (5 → 6 → 4 ) = 8 →0 →7
 * <p>
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class _2两数相加逆序 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //
        ListNode dummyhead = new ListNode(0);  //返回结果
        ListNode p = l1, q = l2;
        ListNode cur = dummyhead;  //负责移动存储当前值的
        int carry = 0;
        Stack<ListNode> stack1 = new Stack<>();
        while (p != null && q != null) {
            stack1.push(p);
            stack1.push(q);
            p = p.next;
            q = q.next;
        }
        while (stack1.size() > 0) {
            int x = (p != null) ? (int) p.val : 0;  // 2  4
            int y = (q != null) ? (int) q.val : 0;  // 5  6
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next.val = sum % 10;
            cur = cur.next;
            if (p != null) p = p.next;  // 移动指针到下一个 4  3
            if (q != null) q = q.next;  // 移动指针到下一个 6  4

        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode("1");
        ListNode l2 = new ListNode();
        l1 = l1.next;
//        l1.next.val = 1;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next.val = 2;
        l1 = l1.next;
        l1.next.val = 3;
        l2 = l2.next;
        l2.next.val = 1;
        l2 = l2.next;
        l2.next.val = 2;
        l2 = l2.next;
        l2.next.val = 3;
        ListNode hello = addTwoNumbers(l1, l2);
        while (hello.next != null) {
            System.out.println(hello.val);
            hello = hello.next;
        }
    }

}
