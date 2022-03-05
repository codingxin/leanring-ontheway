package com.codingzx.实战;

/**
 * @author codingzx
 * @description
 * @date 2022/2/20 16:55
 */

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

/**
 * @author codingzx
 * @description /**
 * 三个问题选一个作答，时间为一小时
 * 1、给定两个文件，两个文件中记录了商品的交易信息（格式一样，乱序），请找出两个文件中售卖量Top n的商品及其价格
 * 文件格式为：商品名（字符串）\t价格（两位小数的正数），如：
 * 西湖龙井500g	700.00
 * 长城干红750ml	75.00
 * <p>
 * 考点： 文件读取  文件分类  排序
 *
 * <p>
 * 2、实现一个针对 读多写少 场景的有序容器，可以一个一个的插入元素，可以改变这个容器内容的，
 * 容器的容量限制为固定大小，要求任何时候这个容器都是有序的。
 * 比如一次插入 [5, 3, 3, 1]，希望顺序是 [1, 3, 3, 5],
 * 要求: 不借助任何其他有能排序特性的第三方容器
 * <p>
 * 考点： 读写锁  COW  自定义排序算法插入容器
 *
 *
 *
 * <p>
 * 3、编程：假设有一个A站点，每次登陆的时候都会记录用户的登陆信息日志，
 * 对象类型是User，有3个字段： userId, userName, loginTime
 * 需求：统计最近10天（每天约10亿条日志）登陆最频繁的10个用户，
 * 排序并输出出这10个用户各登陆多少次
 * 要求：a. 不可直接使用SQL统计，请使用JAVA代码编写
 * b. 功能完备，逻辑正确
 * @date 2020/8/21 20:37
 * 100 0000 0000
 * <p>
 * <p>
 * 4. 实现手写的 LRU 算法
 * <p>
 * 5.  布隆过滤器
 * <p>
 * 6.  多级Redis缓存算法
 * <p>
 * 7.  生产者消费者模型
 * <p>
 * 8.
 */

public class HelloWorld {

    public static void main(String[] args) {

        MyList myList = new MyList();
        myList.put(1);
        myList.put(3000);
        myList.put(2000);

        System.out.println(myList);
        System.out.println(myList.get(2));

        // 随机生成  100 0000 个数字    放进自定义容器     取 100000  100001 100002 判断是否有序
        long curtime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            myList.put((int) (Math.random() * 10000));
        }
        long endtime = System.currentTimeMillis();
        System.out.println("花费 " + (endtime - curtime) + "ms");
        System.out.println(myList.get(3000));
        System.out.println(myList.get(3001));
        System.out.println(myList.get(3002));

    }


}
