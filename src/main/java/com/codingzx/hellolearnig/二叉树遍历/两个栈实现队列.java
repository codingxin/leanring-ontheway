package com.codingzx.hellolearnig.二叉树遍历;

import java.util.Stack;

/**
 * @author created by zhangxin27695
 * @Classname 两个栈实现队列  后进先出/先进先出
 * @Description n 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。一个元素进入 in 栈之后，出栈的顺序被反转。
 * 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
 * <p>
 * push 元素时，始终是进入栈，pop 和 peek 元素时始终是走出栈。
 * <p>
 * pop 和 peek 操作，如果出栈为空，则需要从入栈将所有元素移到出栈，也就是调换顺序，比如开始push的顺序是 3-2-1，1 是最先进入的元素，则到出栈的顺序是 1-2-3，那 pop 操作拿到的就是 1，满足了先进先出的特点。
 * <p>
 * pop 和 peek 操作，如果出栈不为空，则不需要从入栈中移到数据到出
 * @Date 2020-07-02 14:04
 */
public class 两个栈实现队列 {
    static Stack<Integer> in = new Stack<>();
    static Stack<Integer> out = new Stack<>();

    public static void main(String[] args) throws Exception {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
//        out.stream().forEach(e -> {
//
//            try {
//                System.out.println(pop());
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//                }
//        );
    }

    public static void push(int node) {
        in.push(node);
    }

    public static int pop() throws Exception {
        while (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();

    }
}
