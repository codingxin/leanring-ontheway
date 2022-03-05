package com.codingzx.deke;

/*
       一天一只顽猴想要从山脚爬到山顶
        途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
        试问？猴子通过这个阶梯有多少种不同的跳跃方式

        输入描述：
          输入只有一个这个数n    0<n<50
          此阶梯有多个台阶
        输出描述：
          有多少种跳跃方式

        实例:
         输入
           50
         输出
            122106097

         输入青蛙
            3
         输出
            2
       */
public class Hello_5 {

    public static int count = 0;

    public static void main(String[] args) {
//        for (int i = 0; i < 30; i++) {
//            int result1 = JumpFloor(4);
//            int result2 = JumpFloorPrior(4, 1);
//            System.out.println("result1: " + result1 + ", result2 " + result2);
//            if (result1 == result2) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//        }
        long startTime = System.currentTimeMillis();
        System.out.println(JumpFloor(51));
        long nextTime = System.currentTimeMillis();
        System.out.println("花费时间" + (nextTime - startTime) + "ms");
        System.out.println(JumpFloorPrior(51, 1));
        long endTime = System.currentTimeMillis();
        System.out.println("花费时间" + (endTime - nextTime) + "ms");
    }


    public static int JumpFloor(int target) {
        if (target == 0) {
            count++;
            return 0;
        }
        if (target < 0) return 0;
        JumpFloor(target - 1);
        JumpFloor(target - 3);
        return count;
    }


    /**
     * 尾递归,优化版本
     *
     * @param target
     * @return
     */
    public static int JumpFloorPrior(int target, int result) {

        if (target <= 0) {
            return result++;
        }

        JumpFloorPrior(target - 1, result);
        JumpFloorPrior(target - 3, result);
        return count;
    }

}
